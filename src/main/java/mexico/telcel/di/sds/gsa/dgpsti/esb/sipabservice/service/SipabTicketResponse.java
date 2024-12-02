package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service;

// import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolio;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioRequest;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;

public interface SipabTicketResponse {

    public CrearFolioResponse responseTicket(CrearFolioRequest data);
}
