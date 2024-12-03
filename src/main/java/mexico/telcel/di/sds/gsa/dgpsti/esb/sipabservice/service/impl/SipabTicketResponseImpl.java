package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.impl;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint.SipabEndpoint;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketResponse;

@Service
public class SipabTicketResponseImpl implements SipabTicketResponse{

    private static final Logger LOGGER = LogManager.getLogger(SipabTicketResponseImpl.class);

    @Autowired
    private Sipab4TicketRepository sipab4TicketRepository;

    @Override
    public CrearFolioResponse responseTicket(CrearFolioRequest request) {
        CrearFolioPetType datosTicket = request.getCrearFolioRequest();
        CrearFolioResponse response = new CrearFolioResponse();

        LOGGER.info("sipabService - Comenzando flujo para enrolamiento de ticket con empleado");

        Integer ticketCreado = sipab4TicketRepository.saveTicket(datosTicket);

        if(ticketCreado == 1){
            LOGGER.info("sipabService - Ticket creado correctamente "+datosTicket.getSerialNo()+" "+datosTicket.getEmployeeId());

            Integer ticketEmpleadoCreado = sipab4TicketRepository.saveTicketEmpleado(datosTicket);

            if(ticketEmpleadoCreado == 1){
                LOGGER.info("sipabService - Ticket "+datosTicket.getSerialNo()+" asociado correctamente con el empleado "+datosTicket.getEmployeeId());
            }
            else{
                LOGGER.info("sipabService - Ticket "+datosTicket.getSerialNo()+"no se pudo asociar correctamente con el empleado "+datosTicket.getEmployeeId());
            }

        }
        else{
            LOGGER.info("sipabService - No se pudo crear el ticket "+datosTicket.getSerialNo());
        }
        
        return response;
    }
}
