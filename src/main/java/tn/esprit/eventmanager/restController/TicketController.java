package tn.esprit.eventmanager.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.eventmanager.entity.Ticket;
import tn.esprit.eventmanager.service.TicketService;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class TicketController {
    @Autowired
    private TicketService ticketService;

    @PostMapping
    public ResponseEntity<List<Ticket>> ajouterTickets(@RequestBody List<Ticket> tickets,
                                                       @RequestParam Long idEvenement,
                                                       @RequestParam Long idInternaute) {
        return ResponseEntity.ok(ticketService.ajouterTicketsEtAffecterAEvenementEtInternaute(tickets, idEvenement, idInternaute));
    }
}

