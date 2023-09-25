package tn.esprit.esprittwin.Entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table( name = "Universte")
public class Universte implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idUniverste")
    private Long idUniverste;
    private String nomUniverste;
    private String adresse;
    @OneToOne
    private Foyer foyer;
}
