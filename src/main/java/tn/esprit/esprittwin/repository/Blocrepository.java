package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Bloc;

import java.util.List;
@Repository
public interface Blocrepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerUniversteNomUniverste(String nomUniverste);
    @Query("SELECT b FROM Bloc b WHERE b.foyer.universte.nomUniverste =?1")
    List<Bloc> RetrieveBlocbyuniverste(String nom);
}
