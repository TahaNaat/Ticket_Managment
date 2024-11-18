package tn.esprit.eventmanager.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.eventmanager.entity.Internaute;
import tn.esprit.eventmanager.service.InternauteService;

@RestController
@RequestMapping("/internaute")
public class InternauteController {
    @Autowired
    private InternauteService internauteService;

    @PostMapping
    public ResponseEntity<Internaute> ajouterInternaute(@RequestBody Internaute internaute) {
        return ResponseEntity.ok(internauteService.ajouterInternaute(internaute));
    }
}


