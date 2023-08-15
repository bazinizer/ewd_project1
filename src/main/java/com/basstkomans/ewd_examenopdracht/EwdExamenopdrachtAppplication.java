package com.basstkomans.ewd_examenopdracht;

import com.basstkomans.ewd_examenopdracht.mockdata.MockData;
import domain.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import repository.AnimalRepository;
import service.*;

import java.util.List;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableJpaRepositories("repository")
@EntityScan("domain")
public class EwdExamenopdrachtAppplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(EwdExamenopdrachtAppplication.class, args);
    }

  /* @Override
   public void addViewControllers(ViewControllerRegistry registry) {
       registry.addRedirectViewController("/", "/hello");
    }*/
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/", "/animals");
    }


    @Bean
    AnimalService animalService() {
        return new AnimalServiceImpl();
    }

    @Bean
    UserService userService() {
        return new UserServiceImpl();
    }

    @Bean
    ReservationService reservationService() {
        return new ReservationServiceImpl();
    }



}
