package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.context.MessageContext;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.UtilValidation;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.StatusCode;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.SeverityLevel;

@Service
public class SipabTicketServiceImpl implements SipabTicketService{

    private static final Logger LOGGER = LogManager.getLogger(SipabTicketServiceImpl.class);

    @Autowired
    private Sipab4TicketRepository sipab4TicketRepository;

    Util util = new Util();

    @Override
    public CrearFolioResponse validation(CrearFolioPetType data, ControlDataRequestHeaderType control) throws CustomSoapFaultException,
    CreateTicketException, AssociateTicketException {
        CrearFolioResponse response = new CrearFolioResponse();
        UtilValidation utilValidation = new UtilValidation();
        Map<String, List<ErrorType>> responseValidation = utilValidation.validate(data, control);
        List<ErrorType> errores = responseValidation.get("errores");
        
        if(errores!=null && !errores.isEmpty()){
            SipabServiceException error = util.exceptionResponse(String.valueOf(StatusCode.VALIDATION.getCode()), StatusCode.VALIDATION.getDescription(), SeverityLevel.VALIDATION.getCode(), errores);
            //Seteo de la excepción en messageContext para que el custom interceptor pueda identificar el tipo de excepción
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty("exception", new CustomSoapFaultException("Errores de validación", error));
            throw new CustomSoapFaultException("Errores de validación", error);
        }
        else{
            response = responseTicket(data);
        }


        return response;
    }

    @Override
    public CrearFolioResponse responseTicket(CrearFolioPetType datosTicket) throws CreateTicketException, AssociateTicketException {

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
                response = util.successResponse(datosTicket.getIdtroubleTicket(), String.valueOf(StatusCode.OK.getCode()), StatusCode.OK.getDescription());
            }
            else{
                LOGGER.info("sipabService - Ticket {}", datosTicket.getSerialNo());
                LOGGER.info("sipabService - No se pudo asociar correctamente con el empleado {}", datosTicket.getEmployeeId());
                SipabServiceException error = util.exceptionResponse(String.valueOf(StatusCode.ERROR_TICKET_EMPLEADO.getCode()), StatusCode.ERROR_TICKET_EMPLEADO.getDescription(), SeverityLevel.NEGOCIO.getCode(), null);
                //Seteo de la excepción en messageContext para que el custom interceptor pueda identificar el tipo de excepción
                MessageContext context = MessageContextHolder.getMessageContext();
                context.setProperty("exception", new AssociateTicketException("Error al crear al asociar el empleado con el ticket", error));
                throw new AssociateTicketException("Error al crear al asociar el empleado con el ticket", error);
            }

        }
        else{
            LOGGER.info("sipabService - No se pudo crear el ticket {}", datosTicket.getSerialNo());                
            SipabServiceException error = util.exceptionResponse(String.valueOf(StatusCode.ERROR_TICKET.getCode()), StatusCode.ERROR_TICKET.getDescription(), SeverityLevel.NEGOCIO.getCode(), null);
            //Seteo de la excepción en messageContext para que el custom interceptor pueda identificar el tipo de excepción
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty("exception", new CreateTicketException("Error al crear el ticket", error));
            throw new CreateTicketException("Error al crear el ticket", error);
        }
        
        return response;
    }

}
