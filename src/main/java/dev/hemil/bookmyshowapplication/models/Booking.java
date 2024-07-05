package dev.hemil.bookmyshowapplication.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Booking extends BaseModel { // This is Ticket only

    @ManyToMany
    private List<ShowSeat> showSeats;

    @ManyToOne
    private User user;

    /* Here in booking status we want to store just the string value of BookingStatus enum
    not the whole string, so we used this annotation to mark it as an Enumerated attribute
    and declared the type as number by giving the type as EnumType.ORDINAL.
    */
    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    private int amount;

    @OneToMany
    private List<Payment> payments;

    /* Cardinality :-
        Ideally this Booking : ShowSeat have cardinality of 1 : M as one booking can have
        many seats, but those seats can only belong to one booking, but the requirement that
        sir gave is even storing canceled booking, so in that way it is justifying many to many
        cardinality, it is not recommended but this just a requirement by client.
            1              M
        Booking ------ ShowSeat ===> M : M
            M              1

            1          1
        Booking ----- User ==> M : 1
            M           1

            1             M
        Booking ------ Payment ===> 1 : M
            1             1
    * */
}
