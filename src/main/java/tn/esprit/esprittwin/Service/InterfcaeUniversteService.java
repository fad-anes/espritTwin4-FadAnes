package tn.esprit.esprittwin.Service;

import tn.esprit.esprittwin.Entity.Universte;

import java.util.List;

public interface InterfcaeUniversteService {
    List<Universte> retrieveAllUniversities();
    Universte addUniversity (Universte u);
    Universte updateUniversity (Universte u);
    Universte retrieveUniversity (long idUniversity);
    void removeUniversity  (long idUniversity );

     Universte affecterFoyerAUniversite(long idFoyer, String nomUniversite) ;

     Universte desaffecterFoyerAUniversite (long idFoyer,  long idUniversite);

}
