package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Etudiant;
@Repository
public interface Etudiantreposiory extends JpaRepository<Etudiant, Long> {
}
