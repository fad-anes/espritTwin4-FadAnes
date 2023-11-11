package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.Chambre;
import tn.esprit.esprittwin.Entity.TypeChambre;

import java.util.List;
import java.util.Set;

@Repository
public interface Blocrepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerUniversteNomuniverste(String nomUniverste);
    Bloc findByNombloc(String nom);
    @Query("SELECT b FROM Bloc b WHERE b.foyer.universte.nomuniverste =?1")
    List<Bloc> RetrieveBlocbyuniverste(String nom);

    long  countChambresByIdblocAndChambresTypec(long idBloc, TypeChambre type);
}
