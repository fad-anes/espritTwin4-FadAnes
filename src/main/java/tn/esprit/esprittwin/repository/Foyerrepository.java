package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Foyer;
@Repository
public interface Foyerrepository extends JpaRepository<Foyer, Long> {
}
