package tn.esprit.esprittwin.Service;

import tn.esprit.esprittwin.Entity.Foyer;

import java.util.List;

public interface InterfaceFoyerService {
    List<Foyer> retrieveAllFoyers();
    Foyer addFoyer (Foyer f);
    Foyer updateFoyer (Foyer f);
    Foyer retrieveFoyer (long idFoyer);
    void archiverFoyer (long idFoyer);
    Foyer addFoyerWithBloc (Foyer foyer);
}
