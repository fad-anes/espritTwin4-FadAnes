package tn.esprit.esprittwin.Entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idetudiant")
    private Long idetudiant;
    private String nom;
    private String prenom;
    private Long cin;
    private String ecole;
    @Temporal(TemporalType.DATE)
    private Date datenaissance;
    @ManyToMany( fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private Set<Reservation> reservations;
}
