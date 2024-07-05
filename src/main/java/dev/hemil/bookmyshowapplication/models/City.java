package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends BaseModel {
    private String name;
    /* Now it all depends on the use-case we have, like if we need to have a list of theaters
    present in a city frequently then we need to have a list<Theater> in it, but if not,
    then non-list attributes are more preferable, so simply consider the city attribute inside
    City class so in database we will make a query like fetch all theaters where city name =
    Ahmedabad, and we can get list of all the theaters in Ahmedabad, definitely it would
    require some join operations, but still it saves a lot of database space.
    */
    //private List<Theater> theaters;
}
