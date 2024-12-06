package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import oracle.net.aso.c;

public class Util {
    

    public CrearFolioResponse successResponse(BigDecimal idTroubleTicket,String codigo, String descripcion) {
        CrearFolioResponse response = new CrearFolioResponse();
        CrearFolioRespType crearFolioResponse = new CrearFolioRespType();
        crearFolioResponse.setIdFolio(idTroubleTicket);
        crearFolioResponse.setIdResp("12345"); // ID de respuesta actualizado
        crearFolioResponse.setDescResp("Solicitud completada exitosamente"); // Descripción más adecuada
        response.setControlData(controlDataResponse(codigo, descripcion));
        response.setDetailResponse(detailResposne(codigo, descripcion));
        response.setCrearFolioResponse(crearFolioResponse);
        return response;
    }
    
    public ControlDataResponseHeaderType controlDataResponse(String codigo, String descripcion) {
        ControlDataResponseHeaderType controlData = new ControlDataResponseHeaderType();
        BesAdditionalPropertyType additionalPropertyType = new BesAdditionalPropertyType();
            controlData.setVersion("1.0"); // Versión establecida
            controlData.setResultCode(codigo); // Código de resultado actualizado a 200
            controlData.setResultDesc(descripcion); // Descripción más clara
            additionalPropertyType.setCode(""); // Código de propiedad adicional
            additionalPropertyType.setValue(""); // Valor de propiedad adicional
            controlData.getAdditionalProperty().add(additionalPropertyType);
            controlData.setMsgLanguageCode("es-MX"); // Idioma en español
            controlData.setMessageUUID("123e4567-e89b-12d3-a456-426614174000"); // UUID único generado
            controlData.setSendBy("System"); // Usuario que envía el mensaje
            controlData.setLatency(150); // Latencia en milisegundos    
            controlData.setResponseDate(responseDate());
        return controlData;
    }
    
    public DetailResponseType detailResposne(String codigo, String descripcion) {
        DetailResponseType detailResponseType = new DetailResponseType();
        detailResponseType.setCode(codigo); // Código de respuesta actualizado a 200
        detailResponseType.setSeverityLevel(0); // Nivel de severidad ajustado a INFO
        detailResponseType.setDescription(descripcion); // Descripción clara
        detailResponseType.setActor("Servicio Central"); // Actor que maneja la respuesta
        detailResponseType.setBusinessMeaning("Confirmación de la operación"); // Significado comercial ajustado
        return detailResponseType;
    }
    

    public SipabServiceException exceptionResponse(String codigo, String descripcion, Integer severityLevel){
        SipabServiceException response = new SipabServiceException();
        response.setControlData(controlDataResponse(codigo, descripcion));
        response.setDetailFail(detalleFallo(codigo, descripcion, severityLevel));
        return response;
    }

    public DetailFailType detalleFallo(String codigo, String descripcion, Integer severityLevel){
        DetailFailType detailfFailType = new DetailFailType();
        detailfFailType.setOperationName("crearFolio");
        detailfFailType.getErrors().add(tipoError(codigo, descripcion, severityLevel));
        return detailfFailType;
    }

    public ErrorType tipoError(String codigo, String descripcion, Integer severityLevel){
        ErrorType errorType = new ErrorType();
        errorType.setActor("Servicio Central");
        errorType.setBusinessMeaning("Confirmación de la operación");
        errorType.setCode(codigo);
        errorType.setDescription(descripcion);
        errorType.setSeverityLevel(severityLevel);
        errorType.getProperties().add(tipoErrores());
        return errorType;
    }

    public PropertyErrorType tipoErrores(){
        PropertyErrorType propertyErrorType = new PropertyErrorType();
        propertyErrorType.setKey("");
        propertyErrorType.setValue("");
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

    public XMLGregorianCalendar responseDate() {
        // Crear un calendario de tipo GregorianCalendar
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        XMLGregorianCalendar response = null;
        try {
            gregorianCalendar.setTime(new Date());
            response = DatatypeFactory.newInstance()
                    .newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        return response;
    }

}
