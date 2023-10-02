package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.esprittwin.Entity.Bloc;

import java.util.List;

public interface Blocrepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerUniversteNomUniverste(String nomUniverste);
}
