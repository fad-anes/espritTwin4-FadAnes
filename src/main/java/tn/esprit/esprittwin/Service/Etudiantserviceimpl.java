package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Etudiant;
import tn.esprit.esprittwin.repository.Etudiantreposiory;

import java.util.List;
@Service
public class Etudiantserviceimpl implements Ietudiantservice{
    @Autowired
    private Etudiantreposiory etrepo;
    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return etrepo.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etrepo.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etrepo.save(e);
    }

    @Override
    public Etudiant retrieveEtudiant(Long idEtudiant) {
        return etrepo.getReferenceById(idEtudiant);
    }

    @Override
    public void removeEtudiant(Long idEtudiant) {
        etrepo.deleteById(idEtudiant);
    }

    @Override
    public List<Etudiant> addEtudiants(List<Etudiant> etudiants) {
        return etrepo.saveAll(etudiants);
    }
}
