package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.esprittwin.Entity.Etudiant;

public interface Etudiantreposiory extends JpaRepository<Etudiant, Long> {
}
