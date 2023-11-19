package tn.esprit.esprittwin.Service;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.Chambre;
import tn.esprit.esprittwin.Entity.Reservation;

import tn.esprit.esprittwin.repository.Blocrepository;
import tn.esprit.esprittwin.repository.chambrerepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class chambreserviceimpl implements inyterfacechambreService{

    private static final Logger logger = LoggerFactory.getLogger(chambreserviceimpl.class);

    @Autowired
    private chambrerepository chambrerepository;

    @Autowired
    private Blocrepository Blocrepository;
    @Override
    public List<Chambre> retrieveAllChambres() {
        return chambrerepository.findAll();
    }

    @Override
    public Chambre addChambre(Chambre u) {
        return chambrerepository.save(u);
    }

    @Override
    public Chambre updateChambre(Chambre u) {
        return chambrerepository.save(u);
    }

    @Override
    public Chambre retrieveChambre(long idchambre) {
        return chambrerepository.getReferenceById(idchambre);
    }

    @Override
    public void removeChambre(long idchambre) {
        chambrerepository.deleteById(idchambre);
    }

    @Override
    public Bloc affecterChambresABloc(List<Long> numChambre, String nomBloc) {
        Set<Chambre> ChambresEsxiste=new HashSet<>();
        int test=0;
        Bloc b=Blocrepository.findByNombloc(nomBloc);
        if(b!=null){
            if(numChambre!=null){
                for (Long element : numChambre) {
                    Optional<Chambre> c=chambrerepository.findByNumeroChambre(element);
                    if(c.isPresent()){
                        ChambresEsxiste.add(c.get());
                    }
                    else{
                        test=1;
                        break;
                    }
                }
                if(test==0){
                    for (Chambre Chambre : ChambresEsxiste) {
                        Chambre.setBloc(b);
                        updateChambre(Chambre);
                    }
                    b.setChambres(ChambresEsxiste);
                    return b;
                }
            }
        }
        return null;
    }

    @Override
    public List<Chambre> getChambresParNomBloc(String nomBloc) {
        return chambrerepository.findByBlocNombloc(nomBloc);
    }

    @Override
    @Scheduled(cron = "0 * * * * *")
    public void listeChambresParBloc() {
        for (Bloc Bloc : Blocrepository.findAll()) {
            logger.info("bloc :"+Bloc.getNombloc()+"ayant un capacité de :"+Bloc.getCapacitebloc());
            logger.info("Liste des chambre du bloc  :"+Bloc.getNombloc());
            for (Chambre Chambre : Bloc.getChambres()) {
                logger.info("Chambre numero :"+Chambre.getNumeroChambre()+"de type  :"+Chambre.getTypec());
            }
        }
    }

    @Override
    @Scheduled(fixedRate = 300000)
    public void pourcentageChambreParTypeChambre() {
        long nbreTotal = chambrerepository.findAll().stream().count();
        float percentagesimple = 0, percentagedouble = 0, percentagetriple = 0;

        for (Chambre chambre : chambrerepository.findAll()) {
            if ("SIMPLE".equals(chambre.getTypec().toString())) {
                percentagesimple++;
            } else if ("DOUBLE".equals(chambre.getTypec().toString())) {
                percentagedouble++;
            } else {
                percentagetriple++;
            }
        }

        percentagesimple = (percentagesimple / nbreTotal) * 100;
        percentagedouble = (percentagedouble / nbreTotal) * 100;
        percentagetriple = (percentagetriple / nbreTotal) * 100;

        logger.info("Nombre total des chambres  : " + nbreTotal);
        logger.info("Le pourcentage des chambres de type simple est égal à  " + percentagesimple);
        logger.info("Le pourcentage des chambres de type Double est égal à  : " + percentagedouble);
        logger.info("Le pourcentage des chambres de type Triple est égal à   : " + percentagetriple);
    }
    //il faut faire un service qui va affecter les reservation au chambres
    @Override
    @Scheduled(fixedRate = 300000)
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        int anneeEnCours = 123;
// 2023-1900=123
        for (Chambre chambre : chambrerepository.findAll()) {
            long nombreReservations = chambre.getReservations().stream()
                    .filter(reservation -> reservation.getAnneeuniversitaire().getYear() == anneeEnCours)
                    .count();

            if ("SIMPLE".equals(chambre.getTypec().toString())) {
                logger.info("nb restantes en " + 2023 + " pour la chambre " + chambre.getNumeroChambre() +
                        " égale à " +  (1- nombreReservations));
            } else if ("DOUBLE".equals(chambre.getTypec().toString())) {
                logger.info("nb restantes en " + 2023 + " pour la chambre " + chambre.getNumeroChambre() +
                        " égale à " +  (2-nombreReservations));
            } else {
                logger.info("nb restantes en " + 2023 + " pour la chambre " + chambre.getNumeroChambre() +
                        " égale à " +  (3-nombreReservations));
            }
        }
    }

}
