package dev.hemil.bookmyshowapplication.dtos;

import dev.hemil.bookmyshowapplication.models.Booking;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDto {
    private Booking booking;
    private ResponseStatus responseStatus;
}
