package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.DatabaseConnectionException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.GeneralDatabaseException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.PasswordExpiredException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.WrongCredentialsException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Endpoint
public class SipabEndpoint {

    private static final Logger LOGGER = LogManager.getLogger(SipabEndpoint.class);

    @Autowired
    private SipabTicketService sipabTicketResponse;

    @PayloadRoot(namespace = Constantes.NAMESPACE_URI, localPart = "CrearFolioRequest")
    @ResponsePayload
    public CrearFolioResponse crearFolioRequest(@RequestPayload CrearFolioRequest crearFolioRequest)
    throws CustomSoapFaultException, CreateTicketException, AssociateTicketException, PasswordExpiredException, WrongCredentialsException, GeneralDatabaseException, DatabaseConnectionException {
        CrearFolioResponse response = new CrearFolioResponse();
        CrearFolioPetType request = crearFolioRequest.getCrearFolioRequest();
        ControlDataRequestHeaderType control = crearFolioRequest.getControlData();
        try {

            response = sipabTicketResponse.validation(request,control);

            // SipabServiceException error = tools.exceptionResponse();
        
            // //Agrega la excepción al contexto            
            // throw new CustomSoapFaultException("Validation error occurred", error);

        } catch (NullPointerException np) {
            LOGGER.info("null pointer");
            np.printStackTrace();
        }

        return response;
    }

    public void request(CrearFolioPetType valor, ControlDataRequestHeaderType valor2, CrearFolioRequest source) {
        if (valor != null) {
            LOGGER.info("1: " + valor.getSerialNo());
            LOGGER.info("2: " + valor.getCustomerName());
            LOGGER.info("3: " + valor.getEmployeeId());
            LOGGER.info("4: " + valor.getIdtroubleTicket());
            LOGGER.info("5: " + valor.getMobileNo());
            LOGGER.info("6: " + valor.getNumber());
            LOGGER.info("7: " + valor.getTimeStamp());
        } else {
            LOGGER.info("el valor es null");
        }

        if (valor2 != null) {
            LOGGER.info("el valor2 no es null");

        } else {
            LOGGER.info("el valor2 es null");
            LOGGER.info("send " + valor2.getSendBy());
        }

        if (source != null) {
            LOGGER.info("el source no es null");

        } else {
            LOGGER.info("el source es null");
        }

    }
}
