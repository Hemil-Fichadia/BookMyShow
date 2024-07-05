package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    /* This class is required as the seat prices keeps on changing, according to the show,
    so a particular seat type for a particular show decides what will be the charge of that
    show for that seat.
    * */
    @ManyToOne
    private Show show;

    @ManyToOne
    private SeatType seatType;

    private int price;

    /* Here you can also get the cardinality just as other models, but a simple idea behind
    ManyToOne / M : 1 is if two entities are combined and that combination is compared to any
    of them alone, then cardinality will always be M : 1.
    * */
}
