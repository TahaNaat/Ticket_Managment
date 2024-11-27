package tn.esprit.eventmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.eventmanager.entity.Ticket;
import tn.esprit.eventmanager.entity.TrancheAge;
import tn.esprit.eventmanager.entity.TypeTicket;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {
    @Query("SELECT COUNT(i) FROM Ticket t JOIN t.internaute i JOIN t.evenement e WHERE i.trancheAge = :trancheAge AND e.dateEvenement BETWEEN :dateMin AND :dateMax")
    Long countInternautesByTrancheAgeAndDateRange(@Param("trancheAge") TrancheAge trancheAge, @Param("dateMin") LocalDate dateMin, @Param("dateMax") LocalDate dateMax);

    @Query("SELECT SUM(t.prixTicket) FROM Ticket t JOIN t.evenement e WHERE e.nomEvenement = :nomEvt AND t.typeTicket = :typeTicket")
    Double calculateRevenueByEventAndType(@Param("nomEvt") String nomEvt, @Param("typeTicket") TypeTicket typeTicket);

    @Query("SELECT i.nom FROM Ticket t JOIN t.internaute i GROUP BY i.nom ORDER BY COUNT(t) DESC")
    List<String> findMostActiveInternaute();
}

