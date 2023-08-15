package repository;

import domain.Animal;
import domain.Reservation;
import domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByAnimal(Animal animal);
}
