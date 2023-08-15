package com.basstkomans.ewd_examenopdracht.controllers;

import domain.Animal;
import domain.Reservation;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.AnimalService;
import service.ReservationService;
import service.UserService;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;

    @Autowired
    private ReservationService reservationService;

    /*@GetMapping
    public String showAnimalList(Model model) {
        model.addAttribute("animals", animalService.getAllAnimals());
        return "animalList";
    }*/

    @GetMapping
    public String showAnimalList(Model model) {
        List<Animal> animals = animalService.getAllAnimals();
        System.out.println("Animals: " + animals); // Check if the list is not empty
        model.addAttribute("animals", animals);
        return "animalList";
    }

    @GetMapping("/{id}")
    public String showAnimalDetail(@PathVariable("id") Long id, Model model) {
        Optional<Animal> animal = animalService.getAnimalById(id);
        if (!animal.isPresent()) {
            return "redirect:/animals";
        }

        model.addAttribute("animal", animal.get());
        return "animalDetail";
    }

    @PostMapping("/{id}/reserve")
    public String reserveAnimal(
            @PathVariable("id") Long id,
            Authentication auth,
            RedirectAttributes redirectAttributes
    ) {
        Optional<User> user = userService.getUserByUsername(auth.getName());
        Optional<Animal> animal = animalService.getAnimalById(id);

        if (!user.isPresent() || !animal.isPresent()) {
            return "redirect:/animals";
        }

        Reservation reservation = reservationService.addReservation(animal.get(), user.get()); // Use ReservationService
        if (reservation != null) {
            redirectAttributes.addFlashAttribute("message", animal.get().getName() + " was reserved.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to reserve " + animal.get().getName() + ".");
        }

        return "redirect:/animals/" + id;
    }

    @PostMapping("/{id}/cancel-reservation")
    public String cancelReservation(
            @PathVariable("id") Long id,
            Authentication auth,
            RedirectAttributes redirectAttributes
    ) {
        Optional<User> user = userService.getUserByUsername(auth.getName());
        Optional<Animal> animal = animalService.getAnimalById(id);

        if (!user.isPresent() || !animal.isPresent()) {
            return "redirect:/animals";
        }

        boolean success = reservationService.deleteReservation(animal.get().getId(), user.get()); // Use ReservationService
        if (success) {
            redirectAttributes.addFlashAttribute("message", "Reservation for " + animal.get().getName() + " was canceled.");
        } else {
            redirectAttributes.addFlashAttribute("message", "Failed to cancel reservation for " + animal.get().getName() + ".");
        }

        return "redirect:/animals/" + id;
    }
}