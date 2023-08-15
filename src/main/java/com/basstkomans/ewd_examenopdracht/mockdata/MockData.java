package com.basstkomans.ewd_examenopdracht.mockdata;

import domain.Animal;
import domain.Reservation;
import domain.User;

import java.util.ArrayList;
import java.util.List;

public class MockData {

    public static List<Animal> createMockAnimals() {
        List<Animal> animals = new ArrayList<>();

        animals.add(new Animal("Lion", "Big Cat", "2020-01-01", false));
        animals.add(new Animal("Elephant", "Mammal", "2019-05-15", true));
        animals.add(new Animal("Giraffe", "Long-necked", "2021-02-10", false));

        return animals;
    }


    public static List<Reservation> createMockReservations(List<Animal> animals, List<User> users) {
        List<Reservation> reservations = new ArrayList<>();

        reservations.add(new Reservation(users.get(0), animals.get(0), true));
        reservations.add(new Reservation(users.get(1), animals.get(1), false));

        return reservations;
    }
}
