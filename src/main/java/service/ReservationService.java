package service;

import domain.Animal;
import domain.Reservation;
import domain.User;

import java.util.List;
import java.util.Optional;

public interface ReservationService {
    List<Reservation> getAllReservations();
    Optional<Reservation> getReservationById(Long reservationId);
    List<Reservation> getReservationsByUser(User user);
    List<Reservation> getReservationsByAnimal(Animal animal);
    Reservation addReservation(Animal animal, User user);
    boolean deleteReservation(Long reservationId, User user);
}
