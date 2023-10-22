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
@Table( name = "Chambre")
public class Chambre implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idchambre")
    private Long idchambre;

    private Long numeroChambre;
    @Enumerated(EnumType.STRING)
    private TypeChambre typec;
    @ManyToOne
    private Bloc bloc;
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Reservation> reservations;

}
