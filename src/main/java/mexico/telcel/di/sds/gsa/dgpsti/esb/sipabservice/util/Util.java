package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.BesAdditionalPropertyType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataResponseHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRespType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailFailType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailResponseType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.PropertyErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;

public class Util {
    

    public CrearFolioResponse successResponse(BigDecimal idTroubleTicket){
        CrearFolioResponse response = new CrearFolioResponse();
        CrearFolioRespType crearFolioResponse = new CrearFolioRespType();
            crearFolioResponse.setIdFolio(idTroubleTicket);
            crearFolioResponse.setIdResp("1");
            crearFolioResponse.setDescResp("Éxito");

            response.setControlData(controlDataResponse());
            response.setDetailResponse(detailResposne());
            response.setCrearFolioResponse(crearFolioResponse);
            return response;
    }

    public ControlDataResponseHeaderType controlDataResponse(){
        ControlDataResponseHeaderType controlData = new ControlDataResponseHeaderType();
        BesAdditionalPropertyType additionalPropertyType = new BesAdditionalPropertyType();
        try {
        controlData.setVersion("1.0"); // Reemplaza "SomeField" con los campos correctos
            controlData.setResultCode("1.0"); // Reemplaza "SomeField" con los campos correctos
            controlData.setResultDesc("1.0");
            additionalPropertyType.setCode("0");
            additionalPropertyType.setValue("1");
            controlData.getAdditionalProperty().add(additionalPropertyType);
            controlData.setMsgLanguageCode("a");
            controlData.setMessageUUID("a");
            controlData.setSendBy("");
            controlData.setLatency(1);
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
            return controlData;
    }

    public DetailResponseType detailResposne(){
        DetailResponseType detailResponseType = new DetailResponseType();
        detailResponseType.setCode("a");
        detailResponseType.setSeverityLevel(1);
        detailResponseType.setDescription("1");
        detailResponseType.setActor("a");
        detailResponseType.setBusinessMeaning("a");
        return detailResponseType;
    }

    public SipabServiceException exceptionResponse(){
        SipabServiceException response = new SipabServiceException();
        response.setControlData(controlDataResponse());
        response.setDetailFail(detalleFallo());
        return response;
    }

    public DetailFailType detalleFallo(){
        DetailFailType detailfFailType = new DetailFailType();
        detailfFailType.setOperationName("ope");
        detailfFailType.getErrors().add(tipoError());
        return detailfFailType;
    }

    public ErrorType tipoError(){
        ErrorType errorType = new ErrorType();
        errorType.setActor("a");
        errorType.setBusinessMeaning("b");
        errorType.setCode("0");
        errorType.setDescription("desc");
        errorType.setSeverityLevel(1);
        errorType.getProperties().add(tipoErrores());
        return errorType;
    }

    public PropertyErrorType tipoErrores(){
        PropertyErrorType propertyErrorType = new PropertyErrorType();
        propertyErrorType.setKey("k");
        propertyErrorType.setValue("v");
        return propertyErrorType;
    }

    public String formatFecha(XMLGregorianCalendar date) {
        // Convertir la fecha del ticket a Timestamp
        java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter
                .ofPattern("yyyy-MM-dd HH:mm:ss");
        java.time.LocalDateTime localDateTime = date.toGregorianCalendar().toZonedDateTime()
                .toLocalDateTime();
        return localDateTime.format(formatter);
    }
}
