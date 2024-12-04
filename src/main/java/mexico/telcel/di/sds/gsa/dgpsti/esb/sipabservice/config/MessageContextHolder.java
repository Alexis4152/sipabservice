package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config;

import org.springframework.ws.context.MessageContext;

public class MessageContextHolder {
    private static final ThreadLocal<MessageContext> contextHolder = new ThreadLocal<>();

    public static void setMessageContext(MessageContext messageContext) {
        contextHolder.set(messageContext);
    }

    public static MessageContext getMessageContext() {
        return contextHolder.get();
    }

    public static void clear() {
        contextHolder.remove();
    }
}
