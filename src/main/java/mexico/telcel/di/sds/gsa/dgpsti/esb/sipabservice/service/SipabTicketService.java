package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.service;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.AssociateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CreateTicketException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.CustomSoapFaultException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.DatabaseConnectionException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.GeneralDatabaseException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.PasswordExpiredException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.exception.WrongCredentialsException;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.ControlDataRequestHeaderType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioResponse;

public interface SipabTicketService {

    public CrearFolioResponse responseTicket(CrearFolioPetType data) throws CreateTicketException, AssociateTicketException, DataAccessException;

    public CrearFolioResponse validation(CrearFolioPetType data, ControlDataRequestHeaderType control) throws CustomSoapFaultException, CreateTicketException, AssociateTicketException, DataAccessException;
}
