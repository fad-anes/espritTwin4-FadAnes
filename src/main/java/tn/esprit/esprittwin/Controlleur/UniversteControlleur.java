package tn.esprit.esprittwin.Controlleur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.esprittwin.Entity.Universte;
import tn.esprit.esprittwin.Service.UniversteServiceimpl;

import java.util.List;

@RestController
public class UniversteControlleur {

    @Autowired
    private UniversteServiceimpl UniverstyService;

    public UniversteControlleur(UniversteServiceimpl UniversteServiceimpl){
        super();
        this.UniverstyService=UniversteServiceimpl;
    }

    @GetMapping("/AllUniversty")
    public List<Universte> retrieveAllUniversty() {
        return UniverstyService.retrieveAllUniversities();
    }

    @PostMapping("/AddUniversty")
    public Universte AddUniversty(@RequestBody Universte e){
        return UniverstyService.addUniversity(e);
    }

    @PutMapping("/UpdateUniversty")
    public Universte UpdateUniversty(@RequestBody Universte e){
        return UniverstyService.updateUniversity(e);
    }

    @GetMapping("/OneUniversty/{id}")
    public Universte OneUniversty(@PathVariable("id") Long id) {
        return UniverstyService.retrieveUniversity(id);
    }

    @DeleteMapping("/DeleteUniversty/{id}")
    public void DeleteUniversty(@PathVariable("id") Long id) {
        UniverstyService.removeUniversity(id);
    }

    @PutMapping("/affecterFoyerAUniversite/{id}/{nom}")
    public Universte affecterFoyerAUniversite(@PathVariable("id") Long id,@PathVariable("nom") String nom){
        return UniverstyService.affecterFoyerAUniversite(id,nom);
    }

    @PutMapping("/desaffecterFoyerAUniversite/{idf}/{idu}")
    public Universte affecterFoyerAUniversite(@PathVariable("idf") Long idf,@PathVariable("idu") Long idu){
        return UniverstyService.desaffecterFoyerAUniversite(idf,idu);
    }
}
