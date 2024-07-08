package dev.hemil.bookmyshowapplication.services;

import dev.hemil.bookmyshowapplication.models.Show;
import dev.hemil.bookmyshowapplication.models.ShowSeat;
import dev.hemil.bookmyshowapplication.models.ShowSeatType;
import dev.hemil.bookmyshowapplication.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }
    public int calculatePrice(List<ShowSeat> showSeats, Show show){
        List<ShowSeatType> showSeatTypes =
                showSeatTypeRepository.findAllByShow(show);

        int amount = 0;
        /* Here we are simply iterating on the showSeats and then on showSeatTypes and then
        matching the showSeatType with the types that we have, and if they match, we simply
        add the price to the amount variable.
        */
        for(ShowSeat showSeat : showSeats){
            for(ShowSeatType showSeatType : showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }
}
