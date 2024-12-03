package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository;

import org.springframework.jdbc.BadSqlGrammarException;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;

public interface Sipab4TicketRepository {

    public int saveTicket(CrearFolioPetType ticket) throws BadSqlGrammarException;
    public int saveTicketEmpleado(CrearFolioPetType ticket) throws BadSqlGrammarException;
}