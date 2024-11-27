package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.eventmanager.entity.Evenement;
@Repository
public interface EvenementRepository extends JpaRepository<Evenement, Long> {
}
