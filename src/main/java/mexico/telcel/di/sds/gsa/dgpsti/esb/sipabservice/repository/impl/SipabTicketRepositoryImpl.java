package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.impl;

import javax.sql.DataSource;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.BadSqlGrammarException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.ws.context.MessageContext;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.config.MessageContextHolder;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.model.CrearFolioPetType;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.repository.Sipab4TicketRepository;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Constantes;
import mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.util.Util;

@Repository
public class SipabTicketRepositoryImpl implements Sipab4TicketRepository {

    private static final Logger LOGGER = LogManager.getLogger(SipabTicketRepositoryImpl.class);

    @Autowired
    private DataSource dataSource;

    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public int saveTicket(CrearFolioPetType ticket) throws DataAccessException {
        Util util = new Util();
        Integer resultado = 0;
        try {
            jdbcTemplate.setDataSource(getDataSource());
            LOGGER.info("Insertando ticket");
            String sql = "INSERT INTO SIPAB4_TICKET (NUMERO_TICKET, CLIENTE, LINEA, FECHA_CREACION, ESTATUS) VALUES (?, ?, ?, TO_DATE(?,'yyyy-MM-dd HH24:MI:ss'), 37)";

            String fechaCreacion = util.formatFecha(ticket.getTimeStamp());
            resultado = jdbcTemplate.update(sql, ticket.getSerialNo(), ticket.getCustomerName(), ticket.getNumber(),
                    fechaCreacion);
            // Excepción principal al usar JdbcTemplate
        } catch (DataAccessException ex) {
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty(Constantes.EXCEPTION, ex); // Registrar la excepción
            throw ex; // Relanzar la excepción para el interceptor
        }
        return resultado;
    }

    @Override
    public int saveTicketEmpleado(CrearFolioPetType ticket) throws BadSqlGrammarException {
        jdbcTemplate.setDataSource(getDataSource());
        Integer resultado = 0;
        try {
            LOGGER.info("Asociando el ticket con el empleado");
            String sql = "INSERT INTO SIPAB4_EMPLEADO_TICKET (NUMERO_EMPLEADO, NUMERO_TICKET) VALUES (?,?)";
            resultado = jdbcTemplate.update(sql, ticket.getEmployeeId(), ticket.getSerialNo());
            // Excepción principal al usar JdbcTemplate
        } catch (DataAccessException ex) {
            MessageContext context = MessageContextHolder.getMessageContext();
            context.setProperty(Constantes.EXCEPTION, ex); // Registrar la excepción
            throw ex; // Relanzar la excepción para el interceptor
        }
        return resultado;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

}
