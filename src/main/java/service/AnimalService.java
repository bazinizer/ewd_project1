package service;

import domain.Animal;
import domain.Reservation;
import domain.User;

import java.util.List;
import java.util.Optional;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Optional<Animal> getAnimalById(Long animalId);
    List<Animal> getAnimalsByBreed(String breed);
    Animal addAnimal(Animal animal);
    Animal updateReservationStatus(Long animalId, boolean reserved);
    void deleteAnimal(Long animalId);

}

