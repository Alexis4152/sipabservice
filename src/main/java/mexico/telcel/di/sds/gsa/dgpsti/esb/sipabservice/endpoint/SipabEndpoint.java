package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.jws.WebService;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.Unmarshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.BesAdditionalPropertyType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataResponseHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRespType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailResponseType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.MyRequest;
// import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.GeneralException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabService;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabTicketResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Endpoint
public class SipabEndpoint {

    private static final Logger LOGGER = LogManager.getLogger(SipabEndpoint.class);

    private static final String NAMESPACE_URI = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice";

    @Autowired
    private SipabTicketResponse sipabTicketResponse;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "CrearFolioRequest")
    @ResponsePayload
    public CrearFolioResponse crearFolioRequest(@RequestPayload CrearFolioRequest crearFolioRequest) {
    //    public JAXBElement<CrearFolioResponse> crearFolioRequest(@RequestPayload JAXBElement<CrearFolioRequest> crearFolioRequest) {
        //CrearFolioRequest requestNew = crearFolioRequest.getValue();


        CrearFolioResponse response = new CrearFolioResponse();
        ControlDataResponseHeaderType controlData = new ControlDataResponseHeaderType();
        BesAdditionalPropertyType additionalPropertyType = new BesAdditionalPropertyType();
        DetailResponseType detailResponseType = new DetailResponseType();
        CrearFolioRespType crearFolioResponse = new CrearFolioRespType();

        try {
    //LOGGER.info("Received SOAP Request 1: " + crearFolioRequest.getCrearFolioRequest().getEmployeeId());
                        request(crearFolioRequest.getCrearFolioRequest(),crearFolioRequest.getControlData(), crearFolioRequest);
            
                        sipabTicketResponse.responseTicket(crearFolioRequest);
            // Asignar valores a los subelementos requeridos
            controlData.setVersion("1.0"); // Reemplaza "SomeField" con los campos correctos
            controlData.setResultCode("1.0"); // Reemplaza "SomeField" con los campos correctos
            controlData.setResultDesc("1.0");

            additionalPropertyType.setCode("0");
            additionalPropertyType.setValue("1");
            controlData.getAdditionalProperty().add(additionalPropertyType);
            controlData.setMsgLanguageCode("a");
            controlData.setMessageUUID("a");
            try {
                // Crear un calendario de tipo GregorianCalendar
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                gregorianCalendar.set(2024, GregorianCalendar.NOVEMBER, 26); // Establecer fecha: 26 de noviembre de
                                                                             // 2024

                // Crear una instancia de XMLGregorianCalendar
                XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance()
                        .newXMLGregorianCalendar(gregorianCalendar);
                controlData.setResponseDate(xmlGregorianCalendar);
            } catch (DatatypeConfigurationException e) {
                e.printStackTrace();
            }

            controlData.setSendBy("");
            controlData.setLatency(1);

            detailResponseType.setCode("a");
            detailResponseType.setSeverityLevel(1);
            detailResponseType.setDescription("1");
            detailResponseType.setActor("a");
            detailResponseType.setBusinessMeaning("a");

            crearFolioResponse.setIdFolio(BigDecimal.ZERO);
            crearFolioResponse.setIdResp("a");
            crearFolioResponse.setDescResp("a");

            response.setControlData(controlData);
            response.setDetailResponse(detailResponseType);
            response.setCrearFolioResponse(crearFolioResponse);
        } catch (NullPointerException np) {
            LOGGER.info("null pointer");
            np.printStackTrace();
        }
        // Lógica para procesar el request CrearFolio.
        return null;
    }


    public void request(CrearFolioPetType valor, ControlDataRequestHeaderType  valor2, CrearFolioRequest source){
        if(valor!=null){
            LOGGER.info("1: "+valor.getSerialNo());
            LOGGER.info("2: "+valor.getCustomerName());
            LOGGER.info("3: "+valor.getEmployeeId());
            LOGGER.info("4: "+valor.getIdtroubleTicket());
            LOGGER.info("5: "+valor.getMobileNo());
            LOGGER.info("6: "+valor.getNumber());
            LOGGER.info("7: "+valor.getTimeStamp());
        }
        else{
            LOGGER.info("el valor es null");
        }

        if(valor2!=null){
            LOGGER.info("el valor2 no es null");

        }else{
            LOGGER.info("el valor2 es null");
            LOGGER.info("send "+valor2.getSendBy());
        }

        if(source!=null){
            LOGGER.info("el source no es null");

        }else{
            LOGGER.info("el source es null");
        }

     }
}
