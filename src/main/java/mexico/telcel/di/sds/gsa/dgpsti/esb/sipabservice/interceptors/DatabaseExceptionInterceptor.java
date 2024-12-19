package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors;

import java.sql.SQLException;
import java.sql.SQLRecoverableException;
import java.sql.SQLTransientConnectionException;
import java.util.Locale;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapMessage;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.ErrorDataBase;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes.SeverityLevel;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;

public class DatabaseExceptionInterceptor extends EndpointInterceptorAdapter {

    private static final Logger LOGGER = LogManager.getLogger(DatabaseExceptionInterceptor.class);

    Util util = new Util();

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) {
        // Recupera la excepción desde el contexto
        Object exceptionProperty = messageContext.getProperty("exception");
        SipabServiceException error = null;

        if (exceptionProperty instanceof DataAccessException) {
            DataAccessException dataAccessException = (DataAccessException) exceptionProperty;
            Throwable cause = dataAccessException.getCause(); // Obtener la causa de la excepción
             
            if (cause instanceof SQLException) {
                SQLException sqlException = (SQLException) cause;
                Integer errorCode = sqlException.getErrorCode();

                if(errorCode == 28001){
                    error = util.exceptionResponse(
                            ErrorDataBase.PASSWORD_EXPIRADO.getCode(),
                            ErrorDataBase.PASSWORD_EXPIRADO.getDescription() + " " + sqlException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional

                } 
                if(errorCode == 1017){
                    error = util.exceptionResponse(
                            ErrorDataBase.PAASWORD_INCORRECTO.getCode(),
                            ErrorDataBase.PAASWORD_INCORRECTO.getDescription() + " " + sqlException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }
                // Correcto para cuando ya se encuentra el ticket registrado
                if(errorCode == 1){
                    error = util.exceptionResponse(
                            ErrorDataBase.DUPLICADO.getCode(),
                            ErrorDataBase.DUPLICADO.getDescription(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }

                //Invalid identifier or table or view does not exist
                else if(errorCode == 904 || errorCode == 942){
                    error = util.exceptionResponse(
                            ErrorDataBase.ESTRUCTURA_GRAMATICA.getCode(),
                            ErrorDataBase.ESTRUCTURA_GRAMATICA.getDescription() + " " + sqlException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }
                
                // Correcto para cuando se tiene un time out al conectarse a la base de datos
                if (cause instanceof SQLTransientConnectionException) {
                    SQLTransientConnectionException sqlTransientConnectionException = (SQLTransientConnectionException) cause;

                    error = util.exceptionResponse(
                            ErrorDataBase.TIME_OUT.getCode(),
                            ErrorDataBase.TIME_OUT.getDescription() + " "
                                    + sqlTransientConnectionException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }
                
                else if (cause instanceof SQLRecoverableException) {
                    SQLRecoverableException sqlRecoverableException = (SQLRecoverableException) cause;
    
                    error = util.exceptionResponse(
                            ErrorDataBase.TIME_OUT.getCode(),
                            ErrorDataBase.TIME_OUT.getDescription() + " " + sqlRecoverableException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }
                
                else {
                    error = util.exceptionResponse(
                            String.valueOf(ErrorDataBase.GENERICO.getCode()),
                            sqlException.getMessage(),
                            SeverityLevel.EXCEPTCION.getCode(),
                            null);
                    createSoapFault(messageContext, error);
                    return false; // Detén el flujo adicional
                }

            }

            else {
                error = util.exceptionResponse(
                        String.valueOf(ErrorDataBase.GENERICO.getCode()),
                        "No details",
                        SeverityLevel.EXCEPTCION.getCode(),
                        null);
                createSoapFault(messageContext, error);
                return false; // Detén el flujo adicional
            }

        }

        // Si no es una excepción manejada, permite que otros interceptores o la lógica
        // base manejen el Fault
        return true;
    }

    public void createSoapFault(MessageContext messageContext, SipabServiceException sipabServiceException) {
        // Crea el SoapFault
        SoapMessage soapMessage = (SoapMessage) messageContext.getResponse();
        SoapFault fault = soapMessage.getSoapBody().addServerOrReceiverFault("Error en base de datos", Locale.ENGLISH);
        fault.setFaultActorOrRole("http://www.example.org/actor");

        // Agrega detalles al Fault
        SoapFaultDetail detail = fault.addFaultDetail();
        try {
            JAXBContext context = JAXBContext.newInstance(SipabServiceException.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.marshal(sipabServiceException, detail.getResult());
        } catch (JAXBException e) {
            throw new RuntimeException("Error al agregar detalles al Fault", e);
        }
    }
}
