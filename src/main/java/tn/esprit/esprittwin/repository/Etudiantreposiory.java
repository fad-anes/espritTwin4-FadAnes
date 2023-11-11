package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Etudiant;
import java.util.Optional;

@Repository
public interface Etudiantreposiory extends JpaRepository<Etudiant, Long> {

    Optional<Etudiant>  findByNomAndPrenom(String nom , String prenom);
}
