package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Foyer;
import tn.esprit.esprittwin.Entity.Universte;
import tn.esprit.esprittwin.repository.Universiterepository;
import tn.esprit.esprittwin.repository.Foyerrepository;

import java.util.List;
import java.util.Optional;

@Service
public class UniversteServiceimpl implements InterfcaeUniversteService{
    @Autowired
    private Universiterepository RepoUniverste;
    @Autowired
    private Foyerrepository Foyerrepository;
    @Override
    public List<Universte> retrieveAllUniversities() {
        return RepoUniverste.findAll();
    }

    @Override
    public Universte addUniversity(Universte u) {
        return RepoUniverste.save(u);
    }

    @Override
    public Universte updateUniversity(Universte u) {
        return RepoUniverste.save(u);
    }

    @Override
    public Universte retrieveUniversity(long idUniversity) {
        return RepoUniverste.getReferenceById(idUniversity);
    }

    @Override
    public void removeUniversity(long idUniversity) {
        RepoUniverste.deleteById(idUniversity);
    }

    @Override
    public Universte affecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        Universte universte = RepoUniverste.findByNomuniverste(nomUniversite);

        if (universte != null) {
            Optional<Foyer> foyerOptional = Foyerrepository.findById(idFoyer);
            if (foyerOptional.isPresent()) {
                Foyer foyer = foyerOptional.get();
                universte.setFoyer(foyer);
                Universte updatedUniverste = updateUniversity(universte);
                return updatedUniverste;
            }
        }
        return null;
    }

    @Override
    public Universte desaffecterFoyerAUniversite(long idFoyer, long idUniversite) {
        Optional<Universte> UniversteOptional=RepoUniverste.findById(idUniversite);
        if(UniversteOptional.isPresent()){
            Optional<Foyer> foyerOptional = Foyerrepository.findById(idFoyer);
            if (foyerOptional.isPresent()) {
                if(UniversteOptional.get().getFoyer()==foyerOptional.get()){
                    Universte Universte=UniversteOptional.get();
                    Universte.setFoyer(null);
                    Universte updatedUniverste = updateUniversity(Universte);
                    return updatedUniverste;
                }
            }
        }
        return null;
    }
}
