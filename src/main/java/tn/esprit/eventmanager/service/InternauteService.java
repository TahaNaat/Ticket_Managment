package tn.esprit.eventmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.eventmanager.entity.Internaute;
import tn.esprit.eventmanager.repository.InternauteRepository;

@Service
public class InternauteService {
    @Autowired
    private InternauteRepository internauteRepository;

    public Internaute ajouterInternaute(Internaute internaute) {
        return internauteRepository.save(internaute);
    }
}
