package dev.hemil.bookmyshowapplication.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name = "shows")
public class Show extends BaseModel{
    /* Show is also a reserve keyword in MySQL, so we need to change its name with perspective
    database table with some other name
    * */

    @ManyToOne
    private Movie movie;

    private Date startTime;

    private Date endTime;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    /* Cardinality :-

          1           1
        Show ----- Movie ===> M : 1
          M           1

        Here there can be a small confusion regarding a screen running a show, like at a time
        only one show can be running, but we are storing this data in database, so it will be
        for the whole day, which shows were running on this screen, and so we need to store it
        on daily basis and multiple shows can be running on the same screen.
          1             1
        Show -------- Screen ===> M : 1
          M              1
    */
}
