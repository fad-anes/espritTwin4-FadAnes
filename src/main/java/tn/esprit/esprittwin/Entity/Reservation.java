package tn.esprit.esprittwin.Entity;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table( name = "Reservation")
public class Reservation implements Serializable{
    @Id
    @Column(name="idReservation")
    private String idReservation;
    private Boolean estValide;
    @Temporal(TemporalType.DATE)
    private Date anneeUniversitaire;
    @ManyToMany(mappedBy="reservations",cascade = CascadeType.ALL)
    private Set<Etudiant> etudiants;
}
