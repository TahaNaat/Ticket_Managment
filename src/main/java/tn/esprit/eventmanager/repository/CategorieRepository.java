package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.eventmanager.entity.Categorie;
@Repository
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    }
