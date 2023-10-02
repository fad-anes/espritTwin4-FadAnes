package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.esprittwin.Entity.Reservation;

public interface Reservationrepository extends JpaRepository<Reservation, String> {
}
