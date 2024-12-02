package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.entities.Sipab4Ticket;

@Repository
public interface Sipab4TicketRepository extends JpaRepository<Sipab4Ticket, String> {

    @Query("SELECT t FROM Sipab4Ticket t JOIN t.empleados et WHERE t.folio IS NULL AND et.numeroEmpleado = :numeroEmpleado")
    List<Sipab4Ticket> findTicketsByEmpleadoAndFolioIsNull(@Param("numeroEmpleado") String numeroEmpleado);
    
}