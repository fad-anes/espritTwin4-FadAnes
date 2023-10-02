package tn.esprit.esprittwin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.esprittwin.Entity.Chambre;

import java.util.List;

public interface chambrerepository extends JpaRepository<Chambre, Long> {

    List<Chambre> findByBlocIdBlocAndTypec(Long id , String DOUBLE);

    List<Chambre> findByReservationsEstValide(Boolean a);

    List<Chambre> findByBlocIdBlocAndBlocCapaciteBlocGreaterThan(Long id ,Long cap);
}
