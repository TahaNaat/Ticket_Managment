package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.eventmanager.entity.Evenement;

public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
