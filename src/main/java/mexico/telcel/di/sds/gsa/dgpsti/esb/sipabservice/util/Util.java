package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.BesAdditionalPropertyType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataResponseHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRespType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailFailType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.DetailResponseType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.PropertyErrorType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ValidationRule;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.ErrorLongitud;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.ErrorVacio;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.Longitud;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.SeverityLevel;


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
            controlData.setMessageUUID("123e4567-e89b-12d3-a456-426614174000"); // UUID único generado, es el mismo que se recibe como request
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
    

    public SipabServiceException exceptionResponse(String codigo, String descripcion, Integer severityLevel, List<ErrorType> errores){
        SipabServiceException response = new SipabServiceException();
        response.setControlData(controlDataResponse(codigo, descripcion));
        response.setDetailFail(detalleFallo(codigo, descripcion, severityLevel, errores));
        return response;
    }

    public DetailFailType detalleFallo(String codigo, String descripcion, Integer severityLevel, List<ErrorType> errores){
        DetailFailType detailfFailType = new DetailFailType();
        detailfFailType.setOperationName("crearFolio");
        if(errores!= null && errores.size()>0){
            for(ErrorType error: errores){
                detailfFailType.getErrors().add(error);
            }
        }
        else{
            detailfFailType.getErrors().add(tipoError(codigo, descripcion, severityLevel));
        }

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
   
    public ErrorType setErrorType(String codigo, String descripcion){
        ErrorType errorType = new ErrorType();
        errorType.setActor("Servicio Central");
        errorType.setBusinessMeaning("Confirmación de la operación");
        errorType.setCode(codigo);
        errorType.setDescription(descripcion);
        errorType.setSeverityLevel(SeverityLevel.VALIDATION.getCode());
        errorType.getProperties().add(tipoErrores());
        return errorType;
    }

    //Asignación de reglas de validación
    public List<ValidationRule> setRules(CrearFolioPetType data, ControlDataRequestHeaderType control){
        List<ValidationRule> rules = new ArrayList<>();

        rules.add(new ValidationRule("SERIAL_NO", data.getSerialNo(), ErrorVacio.SERIAL_NO.getCode(), ErrorVacio.SERIAL_NO.getDescription(),
        ErrorLongitud.SERIAL_NO.getCode(), ErrorLongitud.SERIAL_NO.getDescription(), Longitud.SERIAL_NO.getRango()));
        
        rules.add(new ValidationRule("EMPLOYEE_ID", data.getEmployeeId(), ErrorVacio.EMPLOYEE_ID.getCode(), ErrorVacio.EMPLOYEE_ID.getDescription(),
        ErrorLongitud.EMPLOYEE_ID.getCode(), ErrorLongitud.EMPLOYEE_ID.getDescription(), Longitud.EMPLOYEE_ID.getRango()));
        
        rules.add(new ValidationRule("CUSTOMER_NAME", data.getCustomerName(), ErrorVacio.CUSTOMER_NAME.getCode(), ErrorVacio.CUSTOMER_NAME.getDescription(),
        ErrorLongitud.CUSTOMER_NAME.getCode(), ErrorLongitud.CUSTOMER_NAME.getDescription(), Longitud.CUSTOMER_NAME.getRango()));
        
        rules.add(new ValidationRule("VERSION", control.getVersion(), ErrorVacio.VERSION.getCode(), ErrorVacio.VERSION.getDescription(),
        ErrorLongitud.VERSION.getCode(), ErrorLongitud.VERSION.getDescription(), Longitud.VERSION.getRango()));
        
        rules.add(new ValidationRule("MESSAGE_UUID", control.getMessageUUID(), ErrorVacio.MESSAGE_UUID.getCode(), ErrorVacio.MESSAGE_UUID.getDescription(),
        ErrorLongitud.MESSAGE_UUID.getCode(), ErrorLongitud.MESSAGE_UUID.getDescription(), Longitud.MESSAGE_UUID.getRango()));
        
        rules.add(new ValidationRule("SEND_BY", control.getSendBy(), ErrorVacio.SEND_BY.getCode(), ErrorVacio.SEND_BY.getDescription(),
        ErrorLongitud.SEND_BY.getCode(), ErrorLongitud.SEND_BY.getDescription(), Longitud.SEND_BY.getRango()));

        rules.add(new ValidationRule("TROUBLE_TICKET_ID", data.getIdtroubleTicket(), ErrorVacio.TROUBLE_TICKET_ID.getCode(), ErrorVacio.TROUBLE_TICKET_ID.getDescription(),
        ErrorLongitud.TROUBLE_TICKET_ID.getCode(), ErrorLongitud.TROUBLE_TICKET_ID.getDescription(), 22));
        
        rules.add(new ValidationRule("NUMBER", data.getNumber(), ErrorVacio.NUMBER.getCode(), ErrorVacio.NUMBER.getDescription(),
        ErrorLongitud.NUMBER.getCode(), ErrorLongitud.NUMBER.getDescription(), 10));
        
        rules.add(new ValidationRule("MOBILE_NO", data.getMobileNo(), ErrorVacio.MOBILE_NO.getCode(), ErrorVacio.MOBILE_NO.getDescription(),
        ErrorLongitud.MOBILE_NO.getCode(), ErrorLongitud.MOBILE_NO.getDescription(), 10));
        
        rules.add(new ValidationRule("TIMESTAMP", data.getTimeStamp(), ErrorVacio.TIMESTAMP.getCode(), ErrorVacio.TIMESTAMP.getDescription()));

        rules.add(new ValidationRule("REQUEST_DATE", control.getRequestDate(), ErrorVacio.REQUEST_DATE.getCode(), ErrorVacio.REQUEST_DATE.getDescription()));

        return rules;
    }

    //Valor y tipo de validación
    public Map<String, String> values(){
        Map<String, String> val = new HashMap<>();
        val.put("SERIAL_NO", "1");
        val.put("EMPLOYEE_ID", "1");
        val.put("CUSTOMER_NAME", "1");
        val.put("VERSION", "1");
        val.put("MESSAGE_UUID", "1");
        val.put("SEND_BY", "1");
        val.put("TROUBLE_TICKET_ID", "2");
        val.put("NUMBER", "2");
        val.put("MOBILE_NO", "2");
        val.put("TIMESTAMP", "3");
        val.put("REQUEST_DATE", "3");
        return val;
    }

}
