package tn.esprit.eventmanager.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import java.util.Set;


@Entity
@Data
public class Categorie {
    @Id
    private String codeCategorie;

    private String nomCategorie;

    @ManyToMany(mappedBy = "categories")
    private Set<Evenement> evenements;

}
