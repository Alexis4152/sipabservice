package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;

public class CustomSoapFaultException  extends RuntimeException {
    private final SipabServiceException sipabServiceException;

    public CustomSoapFaultException(String message, SipabServiceException generalException) {
        super(message);
        this.sipabServiceException = generalException;
    }

    public SipabServiceException getSipabServiceException() {
        return sipabServiceException;
    }
    
}
