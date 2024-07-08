package dev.hemil.bookmyshowapplication.controllers;

import dev.hemil.bookmyshowapplication.dtos.ResponseStatus;
import dev.hemil.bookmyshowapplication.dtos.SignUpRequestDto;
import dev.hemil.bookmyshowapplication.dtos.SignUpResponseDto;
import dev.hemil.bookmyshowapplication.models.User;
import dev.hemil.bookmyshowapplication.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }
    public SignUpResponseDto signUp(SignUpRequestDto requestDto){
        SignUpResponseDto responseDto = new SignUpResponseDto();
        try{
            User user = userService.signUp(requestDto.getName(),
                    requestDto.getEmail(),
                    requestDto.getPassword());
            responseDto.setUser(user);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }
        catch(Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDto;
    }
}
