package tn.esprit.esprittwin.Service;

import tn.esprit.esprittwin.Entity.Bloc;
import tn.esprit.esprittwin.Entity.TypeChambre;

import java.util.List;

public interface interfaceblocService {

    List<Bloc> retrieveAllBlocs();
    Bloc addBloc (Bloc u);
    Bloc updateBloc (Bloc u);
    Bloc retrieveBloc (long idbloc);
    void removeBloc  (long idbloc );
    public long nbChambreParTypeEtBloc(TypeChambre type, long idBloc );
}
