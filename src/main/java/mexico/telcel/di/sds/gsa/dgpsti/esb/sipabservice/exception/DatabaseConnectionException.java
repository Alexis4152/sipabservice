package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.SipabServiceException;

public class DatabaseConnectionException extends Exception {
    private final SipabServiceException sipabServiceException;

    public DatabaseConnectionException(String message, SipabServiceException generalException) {
        super(message);
        this.sipabServiceException = generalException;
    }

    public SipabServiceException getSipabServiceException() {
        return sipabServiceException;
    }
    
}