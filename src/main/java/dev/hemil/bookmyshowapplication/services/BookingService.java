package dev.hemil.bookmyshowapplication.services;

import dev.hemil.bookmyshowapplication.exceptions.ShowNotFoundException;
import dev.hemil.bookmyshowapplication.exceptions.UserNotFoundException;
import dev.hemil.bookmyshowapplication.models.*;
import dev.hemil.bookmyshowapplication.repositories.BookingRepository;
import dev.hemil.bookmyshowapplication.repositories.ShowRepository;
import dev.hemil.bookmyshowapplication.repositories.ShowSeatRepository;
import dev.hemil.bookmyshowapplication.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private UserRepository userRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;
    private BookingRepository bookingRepository;

    public BookingService(UserRepository userRepository,
                          ShowRepository showRepository,
                          ShowSeatRepository showSeatRepository,
                          PriceCalculatorService priceCalculatorService,
                          BookingRepository bookingRepository){
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
        this.bookingRepository = bookingRepository;
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, ShowNotFoundException {
        /*
        1. Get the user with userId
        2. Get the show with the showId
        3. Get the list of show seats with the showSeatIds
        4. Check if all the seats are available or not.
        5. If yes, then proceed with the booking, if not then throw an exception.
        ------------- TAKE A LOCK --------------
        6. Check if all the seats are available or not.
        7. Change the seat status to BLOCKED.
        ----------- RELEASE THE LOCK ------------
        8. Create the booking page and move to payment page.

        Just for the sake of easy implementation, we will take lock on the entire process of
        booking seats, as it is somewhat challenging to implement lock in SpringBoot
        */

        Optional<User> optionalUser = userRepository.findById(userId);
        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User with id : "+ userId + " doesn't exist");
        }
        //Fetch the user from optional object
        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);
        if(optionalShow.isEmpty()){
            throw new ShowNotFoundException("Show with showId : " + showId + " doesn't exist");
        }
        Show show = optionalShow.get();

        // Here we checked all the seats like are they AVAILABLE or not.
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new RuntimeException("ShowSeat with id : " + showSeat.getId() + " isn't available");
            }
        }

        //Now we will mark all seats as BLOCKED
        for(ShowSeat showSeat : showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            // Update the database as well, so the seats are now blocked
            showSeatRepository.save(showSeat);
        }

        //Create the booking and move to the payment page
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setShowSeats(showSeats);
        booking.setCreatedAt(new Date());
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));

        //saved booking to database.
        Booking savedBooking = bookingRepository.save(booking);

        return savedBooking;
    }
}
