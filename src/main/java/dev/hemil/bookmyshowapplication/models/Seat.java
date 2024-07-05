package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String number;

    @ManyToOne
    private SeatType seatType;

    /* As we run the project, ORM will create tables according to the relation amongst them,
    and there it will create some issue related to this reserve keywords row and col as these
    are keywords in MySQL.
    */
    private int rowVal;
    private int colVal;

    /* Cardinality :-

          1               1
        Seat --------- SeatType ===> M : 1
          M               1
    */
}
