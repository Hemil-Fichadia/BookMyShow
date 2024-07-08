package dev.hemil.bookmyshowapplication.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class BCryptPasswordEncodeFConfig {
    /* If we need some class or object in available in terms of application context, then
    we annotate it with @Configuration and the method inside it with @Bean annotation so that
    spring makes that method available at the application context means throughout the project.
    * */
    @Bean
    public BCryptPasswordEncoder getBCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
