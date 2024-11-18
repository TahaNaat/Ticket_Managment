package tn.esprit.eventmanager.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.eventmanager.entity.Evenement;
import tn.esprit.eventmanager.service.EvenementService;

@RestController
@RequestMapping("/evenement")
public class EvenementController {
    @Autowired
    private EvenementService evenementService;

    @PostMapping
    public ResponseEntity<Evenement> ajouterEvenement(@RequestBody Evenement evenement) {
        return ResponseEntity.ok(evenementService.ajouterEvenement(evenement));
    }
}

