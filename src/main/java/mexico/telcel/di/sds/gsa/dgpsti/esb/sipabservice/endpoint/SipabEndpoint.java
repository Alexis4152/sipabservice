package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.GregorianCalendar;
import java.util.Locale;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapFaultException;
import org.springframework.ws.soap.SoapMessage;
import org.springframework.ws.soap.server.endpoint.SoapFaultDefinition;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.BesAdditionalPropertyType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataResponseHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRespType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailResponseType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.MyRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
// import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.GeneralException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Endpoint
public class SipabEndpoint {

    private static final Logger LOGGER = LogManager.getLogger(SipabEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice";

    @Autowired
    private SipabTicketService sipabTicketResponse;


    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CrearFolioRequest")
    @ResponsePayload
    public CrearFolioResponse crearFolioRequest(@RequestPayload CrearFolioRequest crearFolioRequest) {

        CrearFolioResponse response = new CrearFolioResponse();
        CrearFolioPetType request = crearFolioRequest.getCrearFolioRequest();
        Util tools = new Util();
        try {

            response = sipabTicketResponse.responseTicket(request);

            SipabServiceException error = tools.exceptionResponse();
        
            //Agrega la excepción al contexto
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty("exception", new CustomSoapFaultException("Validation error occurred", error));

            
            throw new CustomSoapFaultException("Validation error occurred", error);

        } catch (NullPointerException np) {
            LOGGER.info("null pointer");
            np.printStackTrace();
        }
        // Lógica para procesar el request CrearFolio.
        return response;
    }

    // @ExceptionHandler(CustomSoapFaultException.class)
    // public void handleCustomSoapFaultException(CustomSoapFaultException ex, MessageContext messageContext) {
    //     SoapMessage soapMessage = (SoapMessage) messageContext.getResponse();
    //     SoapFault fault = soapMessage.getSoapBody().addServerOrReceiverFault("Error de validación", Locale.ENGLISH);

    //     // Configurar el actor/rol
    //     fault.setFaultActorOrRole("http://www.any.org/ventos/verrantque");

    //     // Agregar detalles al Fault
    //     SoapFaultDetail detail = fault.addFaultDetail();

    //     try {
    //         JAXBContext context = JAXBContext.newInstance(SipabServiceException.class);
    //         Marshaller marshaller = context.createMarshaller();
    //         marshaller.marshal(ex.getSipabServiceException(), detail.getResult());
    //     } catch (JAXBException e) {
    //         throw new RuntimeException("Error al agregar detalles al Fault", e);
    //     }
    // }

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
