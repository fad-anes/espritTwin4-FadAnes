package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Universte;
@Repository
public interface Universiterepository extends JpaRepository<Universte, Long> {

    Universte findByNomuniverste(String nom);
}
