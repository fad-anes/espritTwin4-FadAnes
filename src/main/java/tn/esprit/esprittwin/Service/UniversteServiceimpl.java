package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Universte;
import tn.esprit.esprittwin.repository.Universiterepository;

import java.util.List;

@Service
public class UniversteServiceimpl implements InterfcaeUniversteService{
    @Autowired
    private Universiterepository RepoUniverste;
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
}
