package tn.esprit.esprittwin.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.Chambre;
import tn.esprit.esprittwin.Service.chambreserviceimpl;

import java.util.List;

@RestController
public class Chambrecontrolleur {

    @Autowired
    private chambreserviceimpl chambreserviceimpl;

    public Chambrecontrolleur(chambreserviceimpl chambreserviceimpl){
        super();
        this.chambreserviceimpl=chambreserviceimpl;
    }

    @GetMapping("/AllChambre")
    public List<Chambre> retrieveAllChambres() {
        return chambreserviceimpl.retrieveAllChambres();
    }

    @PostMapping("/AddChambre")
    public Chambre addChambre(@RequestBody Chambre e){
        return chambreserviceimpl.addChambre(e);
    }

    @PutMapping("/UpdateChambre")
    public Chambre updateChambre(@RequestBody Chambre e){
        return chambreserviceimpl.updateChambre(e);
    }

    @GetMapping("/OneChambre/{id}")
    public Chambre retrieveChambre(@PathVariable("id") Long id) {
        return chambreserviceimpl.retrieveChambre(id);
    }

    @DeleteMapping("/DeleteChambre/{id}")
    public void removeChambre(@PathVariable("id") Long id) {
        chambreserviceimpl.removeChambre(id);
    }

    @PutMapping("/affecterChambresABloc/{nom}")
    public Bloc affecterChambresABloc(@PathVariable("nom") String nom, @RequestBody List<Long> c) {
        return chambreserviceimpl.affecterChambresABloc(c,nom);
    }

    @PutMapping("/getChambresParNomBloc/{nom}")
    public List<Chambre> getChambresParNomBloc(@PathVariable("nom") String nom) {
        return chambreserviceimpl.getChambresParNomBloc(nom);
    }
}
