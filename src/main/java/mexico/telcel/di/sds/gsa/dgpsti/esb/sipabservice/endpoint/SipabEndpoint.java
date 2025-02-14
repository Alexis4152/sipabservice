package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
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
    throws CustomSoapFaultException, CreateTicketException, AssociateTicketException {
        CrearFolioResponse response = new CrearFolioResponse();
        CrearFolioPetType request = crearFolioRequest.getCrearFolioRequest();
        ControlDataRequestHeaderType control = crearFolioRequest.getControlData();
        try { 
            response = sipabTicketResponse.validation(request,control);
        } catch (NullPointerException np) {
            LOGGER.info("null pointer");
            np.printStackTrace();
        }

        return response;
    }

    public void request(CrearFolioRequest source) {
        CrearFolioPetType valor = source.getCrearFolioRequest();
        ControlDataRequestHeaderType valor2 = source.getControlData();
        
        
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

    public void validarRequestManual(){
                // String xmlInput = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>"
        //         + "<soapenv:Envelope xmlns:soapenv=\"http://www.w3.org/2003/05/soap-envelope/\" "
        //         + "xmlns:sip=\"http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice\" "
        //         + "xmlns:v1=\"http://amx.com/mexico/telcel/esb/v1_2\">"
        //         + "<soapenv:Header/>"
        //         + "<soapenv:Body>"
        //         + "<sip:CrearFolioRequest>"
        //         + "<controlData>"
        //         + "<v1:version>1.0</v1:version>"
        //         + "<v1:messageUUID>abc123-def456-ghi789</v1:messageUUID>"
        //         + "<v1:requestDate>2025-02-08T10:30:00</v1:requestDate>"
        //         + "<v1:sendBy>SystemUser</v1:sendBy>"
        //         + "</controlData>"
        //         + "<crearFolioRequest>"
        //         + "<serialNo>250</serialNo>"
        //         + "<employeeId>EX437672</employeeId>"
        //         + "<number>5540128467</number>"
        //         + "<customerName>Alexis Luna</customerName>"
        //         + "<mobileNo>5551234567</mobileNo>"
        //         + "<timeStamp>2024-11-26</timeStamp>"
        //         + "<idtroubleTicket>987654</idtroubleTicket>"
        //         + "</crearFolioRequest>"
        //         + "</sip:CrearFolioRequest>"
        //         + "</soapenv:Body>"
        //         + "</soapenv:Envelope>";
        //         LOGGER.info("Mandando request desde codigo" );
        // try {
        //     JAXBContext jaxbContext = JAXBContext.newInstance(CrearFolioRequest.class);
        //     Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            
        //     // Agregar un manejador para capturar errores
        //     unmarshaller.setEventHandler(new ValidationEventHandler() {
        //         @Override
        //         public boolean handleEvent(ValidationEvent event) {
        //             LOGGER.info("Error en JAXB: " + event.getMessage());
        //             return false; // Retorna false para detener el unmarshalling en caso de error
        //         }
        //     });

        //     StringReader reader = new StringReader(xmlInput);
        //     CrearFolioRequest requestS = (CrearFolioRequest) unmarshaller.unmarshal(reader);

        //     // Validar que los valores fueron mapeados correctamente
        //     LOGGER.info("Datos recibidos:");
        //     LOGGER.info("Version: " + requestS.getControlData().getVersion());
        //     LOGGER.info("MessageUUID: " + requestS.getControlData().getMessageUUID());
        //     LOGGER.info("RequestDate: " + requestS.getControlData().getRequestDate());
        //     LOGGER.info("SendBy: " + requestS.getControlData().getSendBy());
        //     LOGGER.info("SerialNo: " + requestS.getCrearFolioRequest().getSerialNo());
        //     LOGGER.info("EmployeeId: " + requestS.getCrearFolioRequest().getEmployeeId());
        //     LOGGER.info("Number: " + requestS.getCrearFolioRequest().getNumber());
        //     LOGGER.info("MobileNo: " + requestS.getCrearFolioRequest().getMobileNo());
        //     LOGGER.info("CustomerName: " + requestS.getCrearFolioRequest().getCustomerName());
        //     LOGGER.info("IdTroubleTicket: " + requestS.getCrearFolioRequest().getIdtroubleTicket());

        // } catch (JAXBException e) {
        //     e.printStackTrace();
        // }
    }
}
