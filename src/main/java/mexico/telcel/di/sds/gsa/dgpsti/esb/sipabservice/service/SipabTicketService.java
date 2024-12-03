package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;

public interface SipabTicketService {

    public CrearFolioResponse responseTicket(CrearFolioPetType data);
}
