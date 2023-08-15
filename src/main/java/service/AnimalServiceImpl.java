package service;

import domain.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AnimalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalRepository animalRepository;

    @Override
    public List<Animal> getAllAnimals() {
        return StreamSupport.stream(animalRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Animal> getAnimalById(Long animalId) {
        return animalRepository.findById(animalId);
    }

    @Override
    public List<Animal> getAnimalsByBreed(String breed) {
        return animalRepository.findByBreed(breed);
    }

    @Override
    public Animal addAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

    @Override
    public Animal updateReservationStatus(Long animalId, boolean reserved) {
        Optional<Animal> optionalAnimal = animalRepository.findById(animalId);
        if (optionalAnimal.isPresent()) {
            Animal animal = optionalAnimal.get();
            animal.setReserved(reserved);
            return animalRepository.save(animal);
        }
        return null;
    }

    @Override
    public void deleteAnimal(Long animalId) {
        animalRepository.deleteById(animalId);
    }
}
