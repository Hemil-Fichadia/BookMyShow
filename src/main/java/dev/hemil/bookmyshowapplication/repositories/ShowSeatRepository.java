package dev.hemil.bookmyshowapplication.repositories;

import dev.hemil.bookmyshowapplication.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    List<ShowSeat> findAllById(Iterable<Long> showSeatIds);

    /* The working of this save method is straightforward, if the object has an id,
    then it preforms update operation and if id is not present in an object, then it
    creates a new row in the database.
    */
    @Override
    ShowSeat save(ShowSeat showSeat);
}
