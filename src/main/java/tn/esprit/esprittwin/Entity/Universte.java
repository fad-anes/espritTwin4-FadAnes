package tn.esprit.esprittwin.Entity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table( name = "Universte")
public class Universte implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="iduniverste")
    private Long iduniverste;
    private String nomuniverste;
    private String adresse;
    @OneToOne(fetch = FetchType.EAGER)
    private Foyer foyer;
}
