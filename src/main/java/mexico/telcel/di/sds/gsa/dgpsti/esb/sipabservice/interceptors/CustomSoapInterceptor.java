package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;
import org.springframework.ws.soap.SoapFault;
import org.springframework.ws.soap.SoapFaultDetail;
import org.springframework.ws.soap.SoapMessage;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.util.Locale;

public class CustomSoapInterceptor extends EndpointInterceptorAdapter {

    @Override
    public boolean handleFault(MessageContext messageContext, Object endpoint) {
        // Recupera la excepción desde el contexto
        Object exceptionProperty = messageContext.getProperty("exception");
        
        // Verifica si la excepción es del tipo `CustomSoapFaultException`
        if (exceptionProperty instanceof CustomSoapFaultException) {
            CustomSoapFaultException ex = (CustomSoapFaultException) exceptionProperty;

            // Crea el SoapFault
            SoapMessage soapMessage = (SoapMessage) messageContext.getResponse();
            SoapFault fault = soapMessage.getSoapBody().addServerOrReceiverFault("Error de validación", Locale.ENGLISH);
            fault.setFaultActorOrRole("http://www.example.org/actor");

            // Agrega detalles al Fault
            SoapFaultDetail detail = fault.addFaultDetail();
            try {
                JAXBContext context = JAXBContext.newInstance(SipabServiceException.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.marshal(ex.getSipabServiceException(), detail.getResult());
            } catch (JAXBException e) {
                throw new RuntimeException("Error al agregar detalles al Fault", e);
            }

            return false; // Detén el flujo adicional
        }

        // Si no es una excepción manejada, permite que otros interceptores o la lógica base manejen el Fault
        return true;
    }
}
