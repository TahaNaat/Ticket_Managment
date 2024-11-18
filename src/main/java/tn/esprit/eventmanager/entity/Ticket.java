package tn.esprit.eventmanager.entity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeTicket;

    private double prixTicket;

    @Enumerated(EnumType.STRING)
    private TypeTicket typeTicket;

    @ManyToOne
    private Internaute internaute;

    @ManyToOne
    private Evenement evenement;

}
