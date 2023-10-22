package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.esprittwin.Entity.Chambre;

import java.util.List;
@Repository
public interface chambrerepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByBlocIdBlocAndTypec(Long id , String DOUBLE);

    List<Chambre> findByReservationsEstValide(Boolean a);

    List<Chambre> findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long id ,Long cap);

    @Query("SELECT c FROM Chambre c WHERE c.typec = :type AND c.bloc.nomBloc = :nom")
    List<Chambre> RetrieveChambreByTypeAndBloc(@Param("type") String type, @Param("nom") String nom);

    @Query("SELECT c FROM Chambre c WHERE NOT EXISTS (SELECT r FROM c.reservations r WHERE r.estValide = false)")
    List<Chambre> RetrieveChambreByValidationReservation(@Param("estValide") Boolean estValide);

    @Query("SELECT c FROM Chambre c WHERE c.bloc.nomBloc = :nom AND c.bloc.capaciteBloc > :capacite")
    List<Chambre> RetrieveChambresByBlocAndCapacite(@Param("nom") String nom, @Param("capacite") Long capacite);

}
