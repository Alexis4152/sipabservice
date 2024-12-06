package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.StatusCode;

@Service
public class SipabTicketServiceImpl implements SipabTicketService{

    private static final Logger LOGGER = LogManager.getLogger(SipabTicketServiceImpl.class);

    @Autowired
    private Sipab4TicketRepository sipab4TicketRepository;

    @Override
    public CrearFolioResponse responseTicket(CrearFolioPetType datosTicket) throws CreateTicketException, AssociateTicketException {
        Util tools = new Util();

        CrearFolioResponse response = new CrearFolioResponse();

        // try{

        // }
        // catch(BadSqlGrammarException bsql){
        //     LOGGER.info("sipabService - Error en la estructura del query {}", bsql.getMessage());
        // }
        LOGGER.info("sipabService - Comenzando flujo para enrolamiento de ticket con empleado");
        
        Integer ticketCreado = sipab4TicketRepository.saveTicket(datosTicket);

        if(ticketCreado == 1){
            LOGGER.info("sipabService - Ticket creado correctamente {}", datosTicket.getSerialNo()+" "+datosTicket.getEmployeeId());
            LOGGER.info("sipabService - {}", datosTicket.getEmployeeId());

            Integer ticketEmpleadoCreado = sipab4TicketRepository.saveTicketEmpleado(datosTicket);

            if(ticketEmpleadoCreado == 1){
                LOGGER.info("sipabService - Ticket {}", datosTicket.getSerialNo());
                LOGGER.info("sipabService - Asociado correctamente con el empleado {}", datosTicket.getEmployeeId());
                response = tools.successResponse(datosTicket.getIdtroubleTicket(), String.valueOf(StatusCode.OK.getCode()), StatusCode.OK.getDescription());
            }
            else{
                LOGGER.info("sipabService - Ticket {}", datosTicket.getSerialNo());
                LOGGER.info("sipabService - No se pudo asociar correctamente con el empleado {}", datosTicket.getEmployeeId());
                SipabServiceException error = tools.exceptionResponse(String.valueOf(Constantes.StatusCode.ERROR_TICKET_EMPLEADO.getCode()), Constantes.StatusCode.ERROR_TICKET_EMPLEADO.getDescription(), Constantes.SeverityLevel.NEGOCIO.getCode());
                //Seteo de la excepción en messageContext para que el custom interceptor pueda identificar el tipo de excepción
                MessageContext context = MessageContextHolder.getMessageContext();
                context.setProperty("exception", new AssociateTicketException("Error al crear al asociar el empleado con el ticket", error));
                throw new AssociateTicketException("Error al crear al asociar el empleado con el ticket", error);
            }

        }
        else{
            LOGGER.info("sipabService - No se pudo crear el ticket {}", datosTicket.getSerialNo());                
            SipabServiceException error = tools.exceptionResponse(String.valueOf(Constantes.StatusCode.ERROR_TICKET.getCode()), Constantes.StatusCode.ERROR_TICKET.getDescription(), Constantes.SeverityLevel.NEGOCIO.getCode());
            //Seteo de la excepción en messageContext para que el custom interceptor pueda identificar el tipo de excepción
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty("exception", new CreateTicketException("Error al crear el ticket", error));
            throw new CreateTicketException("Error al crear el ticket", error);
        }
        
        return response;
    }
}
