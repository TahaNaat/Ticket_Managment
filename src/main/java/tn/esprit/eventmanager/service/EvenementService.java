package tn.esprit.eventmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.eventmanager.entity.Evenement;
import tn.esprit.eventmanager.repository.EvenementRepository;

@Service
public class EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;

    public Evenement ajouterEvenement(Evenement evenement) {
        return evenementRepository.save(evenement);
    }
}
