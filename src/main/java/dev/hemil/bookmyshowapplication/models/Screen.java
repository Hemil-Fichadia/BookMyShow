package dev.hemil.bookmyshowapplication.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends BaseModel {
    private String name;

    @OneToMany
    private List<Seat> seats;

    /* Here this 'features' list attribute is an enumerator and a list of attributes as
    well, so we need to declare it as a collection of elements.
    * */
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    /* Cardinality :-

           1                M
        Screen ----------- Seat ====> 1 : M
           1                 1
    */
}
