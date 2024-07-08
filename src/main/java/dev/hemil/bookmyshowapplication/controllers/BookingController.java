package dev.hemil.bookmyshowapplication.controllers;

import dev.hemil.bookmyshowapplication.dtos.BookMovieRequestDto;
import dev.hemil.bookmyshowapplication.dtos.BookMovieResponseDto;
import dev.hemil.bookmyshowapplication.dtos.ResponseStatus;
import dev.hemil.bookmyshowapplication.models.Booking;
import dev.hemil.bookmyshowapplication.services.BookingService;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    private BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public BookMovieResponseDto bookMovie(BookMovieRequestDto bookMovieRequestDto) {
        BookMovieResponseDto responseDto = new BookMovieResponseDto();
        try{
            Booking booking = bookingService.bookMovie(bookMovieRequestDto.getUserId(),
                    bookMovieRequestDto.getShowId(),
                    bookMovieRequestDto.getShowSeatIds()
            );
            responseDto.setBooking(booking);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
