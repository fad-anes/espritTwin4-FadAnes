package tn.esprit.esprittwin.Service;

import tn.esprit.esprittwin.Entity.Reservation;

import java.util.Date;
import java.util.List;

public interface interfaceresefvationService {

    List<Reservation> retrieveAllReservations();

    Reservation addReservation(Reservation r);

    Reservation updateReservation(Reservation r);

    Reservation retrieveReservation(String idreservation);

    void removeReservation(String idreservation);
     List<Reservation> getReservationParAnneeUniversitaire(Date dateDebut , Date dateFin );
}
