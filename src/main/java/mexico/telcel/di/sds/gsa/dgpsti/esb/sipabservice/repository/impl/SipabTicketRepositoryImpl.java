package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.impl;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.endpoint.SipabEndpoint;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;

@Repository
public class SipabTicketRepositoryImpl implements Sipab4TicketRepository {

    private static final Logger LOGGER = LogManager.getLogger(SipabTicketRepositoryImpl.class);

    @Autowired
    private DataSource dataSource;

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public int saveTicket(CrearFolioPetType ticket) throws BadSqlGrammarException{
        Util tools = new Util();
        jdbcTemplate.setDataSource(getDataSource());
        String sql = "INSERT INTO SIPAB4_TICKET (NUMERO_TICKET, CLIENTE, LINEA, FECHA_CREACION) VALUES (?, ?, ?, TO_DATE(?,'yyyy-MM-dd HH24:MI:ss'))";

        String fechaCreacion = tools.formatFecha(ticket.getTimeStamp());

        return jdbcTemplate.update(sql, ticket.getSerialNo(), ticket.getCustomerName(), ticket.getNumber(), fechaCreacion);
    }

    @Override
    public int saveTicketEmpleado(CrearFolioPetType ticket) throws BadSqlGrammarException{
        jdbcTemplate.setDataSource(getDataSource());
        String sql = "INSERT INTO SIPAB4_EMPLEADO_TICKET (NUMERO_EMPLEADO, NUMERO_TICKET) VALUES (?,?)";
        return jdbcTemplate.update(sql, ticket.getEmployeeId(), ticket.getSerialNo());
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
