package tn.esprit.esprittwin.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.Chambre;
import tn.esprit.esprittwin.repository.Blocrepository;
import tn.esprit.esprittwin.repository.chambrerepository;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class chambreserviceimpl implements inyterfacechambreService{

    @Autowired
    private chambrerepository chambrerepository;

    @Autowired
    private tn.esprit.esprittwin.repository.Blocrepository Blocrepository;
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
}
