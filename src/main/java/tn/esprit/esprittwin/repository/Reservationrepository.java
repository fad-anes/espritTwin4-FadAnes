package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Reservation;
@Repository
public interface Reservationrepository extends JpaRepository<Reservation, String> {
}
