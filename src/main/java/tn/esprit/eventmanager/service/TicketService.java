package tn.esprit.eventmanager.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.eventmanager.entity.Evenement;
import tn.esprit.eventmanager.entity.Internaute;
import tn.esprit.eventmanager.entity.Ticket;
import tn.esprit.eventmanager.repository.EvenementRepository;
import tn.esprit.eventmanager.repository.InternauteRepository;
import tn.esprit.eventmanager.repository.TicketRepository;

import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    private InternauteRepository internauteRepository;

    @Transactional
    public Ticket ajouterTicketEtAffecterAEvenementEtInternaute(Ticket ticket, Long idEvenement, Long idInternaute) {
        Evenement evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found"));
        Internaute internaute = internauteRepository.findById(idInternaute)
                .orElseThrow(() -> new EntityNotFoundException("Internaute not found"));

        if (evenement.getNbPlacesRestantes() < 1) {
            throw new UnsupportedOperationException("Aucune place disponible");
        }

        ticket.setEvenement(evenement);
        ticket.setInternaute(internaute);

        evenement.setNbPlacesRestantes(evenement.getNbPlacesRestantes() - 1);
        evenementRepository.save(evenement);

        return ticketRepository.save(ticket);
    }

    @Transactional
    public List<Ticket> ajouterTicketsEtAffecterAEvenementEtInternaute(List<Ticket> tickets, Long idEvenement, Long idInternaute) {
        Evenement evenement = evenementRepository.findById(idEvenement)
                .orElseThrow(() -> new EntityNotFoundException("Evenement not found"));
        Internaute internaute = internauteRepository.findById(idInternaute)
                .orElseThrow(() -> new EntityNotFoundException("Internaute not found"));

        if (tickets.size() > evenement.getNbPlacesRestantes()) {
            throw new UnsupportedOperationException("Nombre de places demandées indisponible");
        }

        tickets.forEach(ticket -> {
            ticket.setEvenement(evenement);
            ticket.setInternaute(internaute);
        });

        evenement.setNbPlacesRestantes(evenement.getNbPlacesRestantes() - tickets.size());
        evenementRepository.save(evenement);

        return ticketRepository.saveAll(tickets);
    }
}
