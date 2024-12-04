package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.interceptors;

import org.springframework.ws.context.MessageContext;
import org.springframework.ws.server.endpoint.interceptor.EndpointInterceptorAdapter;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;

public class CustomInterceptor extends EndpointInterceptorAdapter {

    @Override
    public boolean handleRequest(MessageContext messageContext, Object endpoint) {
        // Almacenar el MessageContext en el contenedor ThreadLocal
        MessageContextHolder.setMessageContext(messageContext);
        return true;
    }

    @Override
    public void afterCompletion(MessageContext messageContext, Object endpoint, Exception ex) {
        // Limpiar el contexto después de procesar la solicitud
        MessageContextHolder.clear();
    }

}