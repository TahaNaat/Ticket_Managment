package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.eventmanager.entity.Internaute;
@Repository
public interface InternauteRepository extends JpaRepository<Internaute, Long> {
}

