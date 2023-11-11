package tn.esprit.esprittwin.Service;

import tn.esprit.esprittwin.Entity.Etudiant;

import java.util.List;

public interface Ietudiantservice {
    List<Etudiant> retrieveAllEtudiants();

    Etudiant addEtudiant(Etudiant e);

    Etudiant updateEtudiant(Etudiant e);

    Etudiant retrieveEtudiant(Long idEtudiant);

    void removeEtudiant(Long idEtudiant);
    List<Etudiant> addEtudiants (List<Etudiant> etudiants);
    Etudiant affecterEtudiantAReservation(String nomEt , String prenomEt , String idReservation );
}
