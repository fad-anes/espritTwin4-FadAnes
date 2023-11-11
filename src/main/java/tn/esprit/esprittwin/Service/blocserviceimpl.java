package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.Chambre;
import tn.esprit.esprittwin.Entity.Reservation;
import tn.esprit.esprittwin.Entity.TypeChambre;
import tn.esprit.esprittwin.repository.Blocrepository;
import tn.esprit.esprittwin.repository.chambrerepository;

import java.util.*;

@Service
public class blocserviceimpl implements interfaceblocService{

    @Autowired
    private Blocrepository Blocrepository;


    @Override
    public List<Bloc> retrieveAllBlocs() {
        return Blocrepository.findAll();
    }

    @Override
    public Bloc addBloc(Bloc u) {
        return Blocrepository.save(u);
    }

    @Override
    public Bloc updateBloc(Bloc u) {
        return Blocrepository.save(u);
    }

    @Override
    public Bloc retrieveBloc(long idbloc) {
        return Blocrepository.getReferenceById(idbloc);
    }

    @Override
    public void removeBloc(long idbloc) {
        Blocrepository.deleteById(idbloc);
    }

    @Override
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc) {

        return Blocrepository.countChambresByIdblocAndChambresTypec(idBloc,type) ;
    }


}
