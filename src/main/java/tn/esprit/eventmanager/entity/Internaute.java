package tn.esprit.eventmanager.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.util.Set;


@Entity
@Data
public class Internaute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    @Enumerated(EnumType.STRING)
    private TrancheAge trancheAge;


    @OneToMany(mappedBy = "internaute", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;
}
