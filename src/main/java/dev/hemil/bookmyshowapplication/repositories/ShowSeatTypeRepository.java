package dev.hemil.bookmyshowapplication.repositories;

import dev.hemil.bookmyshowapplication.models.Show;
import dev.hemil.bookmyshowapplication.models.ShowSeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatTypeRepository extends JpaRepository<ShowSeatType, Long> {
    /* We need the price of all the seats that belongs to this show, and so we are fetching
    all the seats linked with the given show.
    * */
    List<ShowSeatType> findAllByShow(Show show);
}
