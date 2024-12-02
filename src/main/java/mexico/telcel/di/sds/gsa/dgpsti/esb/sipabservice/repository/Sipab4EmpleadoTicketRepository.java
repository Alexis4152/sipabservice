package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.entities.Sipab4EmpleadoTicket;

@Repository
public interface Sipab4EmpleadoTicketRepository extends JpaRepository<Sipab4EmpleadoTicket, String> {

}

