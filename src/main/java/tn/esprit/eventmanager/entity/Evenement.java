package tn.esprit.eventmanager.entity;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.Set;


@Entity
@Data
public class Evenement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomEvenement;
    private int nbPlacesRestantes;
    private LocalDate dateEvenement;

    @OneToMany(mappedBy = "evenement", cascade = CascadeType.ALL)
    private Set<Ticket> tickets;

    @ManyToMany(cascade = CascadeType.PERSIST)
    private Set<Categorie> categories;

}
