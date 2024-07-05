package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theater extends BaseModel {
    private String name;
    /* In city class we are not considering list<Theater> because we have this city
    attribute in Theater class and that can easily serve the purpose of linking a theater
    with a city.
    * */

    @ManyToOne
    private City city;

    @OneToMany
    private List<Screen> screens;
}
