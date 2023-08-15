package service;

import domain.Animal;
import domain.Reservation;
import domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ReservationRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationServiceImpl implements ReservationService{
    @Autowired
    private  ReservationRepository reservationRepository;




    @Override
    public List<Reservation> getAllReservations() {
        return StreamSupport.stream(reservationRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    @Override
    public Optional<Reservation> getReservationById(Long reservationId) {
        return reservationRepository.findById(reservationId);
    }

    @Override
    public List<Reservation> getReservationsByUser(User user) {
        return null;
    }

    @Override
    public List<Reservation> getReservationsByAnimal(Animal animal) {
        return null;
    }



    @Override
    public Reservation addReservation(Animal animal, User user) {
        if (!animal.isReserved()) {
            Reservation reservation = new Reservation(user, animal, true); // Provide user and animal to the constructor
            return reservationRepository.save(reservation);
        }

        return null; // Handle reservation addition failure
    }

    @Override
    public boolean deleteReservation(Long reservationId, User user) {
        Reservation reservation = reservationRepository.findById(reservationId).orElse(null);
        if (reservation != null && reservation.getUser().equals(user)) {
            reservationRepository.delete(reservation);
            return true;
        }
        return false;
    }

}
