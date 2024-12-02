package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import javax.xml.ws.WebFault;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;

// @WebService(
//     endpointInterface = "mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service.SipabService", // Reemplaza con el paquete correcto
//     targetNamespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice"
// )

@WebService(targetNamespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT, use = SOAPBinding.Use.LITERAL)
public interface SipabService {
    
    @WebMethod(action = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice", 
    operationName = "crearFolio")
    @RequestWrapper(localName = "crearFolioRequest", targetNamespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
    @ResponseWrapper(localName = "crearFolioResponse", targetNamespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
    CrearFolioResponse crearFolioRequest(@WebParam(name = "CrearFolioRequest") CrearFolioRequest crearFolioRequest) throws GeneralException;

}

@WebFault(name = "generalException", targetNamespace = "http://www.amx.com.mx/mexico/telcel/di/sds/gsa/dgpsti/esb/sipabservice")
class GeneralException extends Exception {
    private static final long serialVersionUID = 1L;

    public GeneralException(String message) {
        super(message);
    }

    public GeneralException(String message, Throwable cause) {
        super(message, cause);
    }
}
