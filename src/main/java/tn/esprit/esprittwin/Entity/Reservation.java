package tn.esprit.esprittwin.Entity;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
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
