package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Foyer;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.repository.Foyerrepository;
import tn.esprit.esprittwin.repository.Blocrepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class FoyerServiceimpl implements InterfaceFoyerService{
    @Autowired
    private Foyerrepository Foyerrepo;
    @Autowired
    private Blocrepository Blocrepository;
    @Override
    public List<Foyer> retrieveAllFoyers() {
        return Foyerrepo.findAll();
    }

    @Override
    public Foyer addFoyer(Foyer f) {
        return Foyerrepo.save(f);
    }

    @Override
    public Foyer updateFoyer(Foyer f) {
        return Foyerrepo.save(f);
    }

    @Override
    public Foyer retrieveFoyer(long idFoyer) {
        return Foyerrepo.getReferenceById(idFoyer);
    }

    @Override
    public void archiverFoyer(long idFoyer) {
        Foyer foyer = Foyerrepo.findById(idFoyer).orElse(null);
        if (foyer != null) {
            foyer.setArchived(true);
            Foyerrepo.save(foyer);
        }

    }

    @Override
    public Foyer addFoyerWithBloc(Foyer foyer) {
        if(foyer!=null&&foyer.getBlocs()!=null){


            return Foyerrepo.save(foyer);
        }
        return null;
    }
}
