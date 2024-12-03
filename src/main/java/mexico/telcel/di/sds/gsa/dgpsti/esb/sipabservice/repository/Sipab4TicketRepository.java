package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;

public interface Sipab4TicketRepository {

    public int saveTicket(CrearFolioPetType ticket);
    public int saveTicketEmpleado(CrearFolioPetType ticket);
}