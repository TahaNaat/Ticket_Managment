package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.eventmanager.entity.Internaute;

public interface InternauteRepository extends JpaRepository<Internaute, Long> {
}

