package tn.esprit.esprittwin.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprittwin.Entity.Foyer;
import tn.esprit.esprittwin.Service.FoyerServiceimpl;

import java.util.List;

@RestController
public class Foyercontrolleur {
    @Autowired
    private FoyerServiceimpl Foyerservice;
    public  Foyercontrolleur(FoyerServiceimpl FoyerServiceimpl){
        super();
        this.Foyerservice=FoyerServiceimpl;
    }

    @GetMapping("/AllFoyer")
    public List<Foyer> retrieveAllFoyer() {
        return Foyerservice.retrieveAllFoyers();
    }

    @PostMapping("/AddFoyer")
    public Foyer AddFoyer(@RequestBody Foyer f){
        return Foyerservice.addFoyer(f);
    }

    @PutMapping("/UpdateFoyer")
    public Foyer UpdateFoyer(@RequestBody Foyer e){
        return Foyerservice.updateFoyer(e);
    }

    @GetMapping("/OneFoyer/{id}")
    public Foyer OneFoyer(@PathVariable("id") Long id) {
        return Foyerservice.retrieveFoyer(id);
    }

    @PostMapping("/Archiver/{idFoyer}")
    public void Archiver(@PathVariable("id") Long id){
         Foyerservice.archiverFoyer(id);
    }

    @PostMapping("/addFoyerWithBloc")
    public Foyer addFoyerWithBloc(@RequestBody Foyer f){
        return Foyerservice.addFoyerWithBloc(f);
    }
}
