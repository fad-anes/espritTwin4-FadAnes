package tn.esprit.esprittwin.Entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table( name = "Bloc")
public class Bloc implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="idbloc")
    private Long idbloc;
    private String nombloc;
    private Long capacitebloc;
    @ManyToOne
    @JsonBackReference
    private Foyer foyer;
    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy="bloc")
    private Set<Chambre> chambres;
}
