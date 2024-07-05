package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel {

    @ManyToOne
    private Seat seat;

    @ManyToOne
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    private ShowSeatStatus showSeatStatus;

    /* Cardinality :-

        One ShowSeat belongs to a particular show that's why it is ShowSeat so one ShowSeat
        is to one Show but one Show can have multiple ShowSeat so this cardinality stands as
        M : 1
           1                1
        ShowSeat -------- Show ===> M : 1
           M                1


        One ShowSeat will have only one seat, now this sounds somewhat confusing, as one type
        of object can have multiple Seat objects but here we are purely focusing in terms of
        particular seat so one ShowSeat object will only have one Seat, but one Seat object can
        be present in multiple ShowSeat object so this cardinality stands for M : 1.
           1                1
        ShowSeat -------- Seat ===> M : 1
           M                1
    */
}
