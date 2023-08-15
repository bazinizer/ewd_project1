package repository;

import domain.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findByBreed(String breed);
    List<Animal> findByReserved(boolean reserved);
}


