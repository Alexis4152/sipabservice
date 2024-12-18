package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;

public interface SipabTicketService {

    public CrearFolioResponse responseTicket(CrearFolioPetType data) throws CreateTicketException, AssociateTicketException;

    public CrearFolioResponse validation(CrearFolioPetType data, ControlDataRequestHeaderType control) throws CustomSoapFaultException, CreateTicketException, AssociateTicketException;
}
