package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Reservation;

import java.util.Date;
import java.util.List;

@Repository
public interface Reservationrepository extends JpaRepository<Reservation, String> {

    List<Reservation> findByAnneeuniversitaireGreaterThanEqualAndAnneeuniversitaireLessThanEqual(Date dateDebut, Date dateFin);
}
