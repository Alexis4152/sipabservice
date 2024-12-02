package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.entities.Sipab4Ticket;
//import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolio;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketResponse;

@Service
public class SipabTicketResponseImpl implements SipabTicketResponse{

    @Autowired
    private Sipab4TicketRepository sipab4TicketRepository;

    @Override
    public CrearFolioResponse responseTicket(CrearFolioRequest data) {
        CrearFolioResponse response = new CrearFolioResponse();
        Sipab4Ticket ticket = new Sipab4Ticket();
        List<Sipab4Ticket> ticketsPendientes = sipab4TicketRepository.findTicketsByEmpleadoAndFolioIsNull(data.getCrearFolioRequest().getEmployeeId());
        
        return response;
    }

}
