package dev.hemil.bookmyshowapplication.dtos;

import dev.hemil.bookmyshowapplication.models.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponseDto {
    private User user;
    private ResponseStatus responseStatus;
}
