package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Etudiant;
import tn.esprit.esprittwin.Entity.Reservation;
import tn.esprit.esprittwin.repository.Etudiantreposiory;
import tn.esprit.esprittwin.repository.Reservationrepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class Etudiantserviceimpl implements Ietudiantservice{
    @Autowired
    private Etudiantreposiory etrepo;
    @Autowired
    private Reservationrepository Reservationrepository;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etrepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etrepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etrepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etrepo.getReferenceById(idEtudiant);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etrepo.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etrepo.saveAll(etudiants);
    }

    @Override
    public Etudiant affecterEtudiantAReservation(String nomEt, String prenomEt, String idReservation) {
        Optional<Etudiant> opEt=etrepo.findByNomAndPrenom(nomEt,prenomEt);
        if(opEt.isPresent()){
            Optional<Reservation> opReserv =Reservationrepository.findById(idReservation);
            if(opReserv.isPresent()){
                Set<Reservation> Reservations = new HashSet<>();
                Reservations.add(opReserv.get());
                opEt.get().setReservations(Reservations);
                Etudiant updatedetudiant=opEt.get();
                updateEtudiant(updatedetudiant);
                return updatedetudiant;
            }
        }
        return null;
    }
}
