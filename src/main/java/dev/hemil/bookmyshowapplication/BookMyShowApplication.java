package dev.hemil.bookmyshowapplication;

import dev.hemil.bookmyshowapplication.controllers.UserController;
import dev.hemil.bookmyshowapplication.dtos.SignUpRequestDto;
import dev.hemil.bookmyshowapplication.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowApplication implements CommandLineRunner {
    /* Here command line runner is the alternate way of running the project by feeding
    all the required inputs here in the main function itself.
    * */
    @Autowired
    private UserController userController;
    public static void main(String[] args) {
        SpringApplication.run(BookMyShowApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto signUpRequestDto = new SignUpRequestDto();
        signUpRequestDto.setName("ABC");
        signUpRequestDto.setEmail("abc@femail.com");
        signUpRequestDto.setPassword("password");

        SignUpResponseDto responseDto = userController.signUp(signUpRequestDto);
    }
}
