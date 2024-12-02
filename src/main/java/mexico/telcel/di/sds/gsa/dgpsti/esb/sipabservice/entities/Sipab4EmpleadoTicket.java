package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.entities;

import javax.persistence.*;

@Entity
@Table(name = "SIPAB4_EMPLEADO_TICKET")
public class Sipab4EmpleadoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NUMERO_EMPLEADO", length = 20)
    private String numeroEmpleado;

    @ManyToOne
    @JoinColumn(name = "NUMERO_TICKET", nullable = false)
    private Sipab4Ticket ticket;

    public String getNumeroEmpleado() {
        return numeroEmpleado;
    }

    public void setNumeroEmpleado(String numeroEmpleado) {
        this.numeroEmpleado = numeroEmpleado;
    }

    public Sipab4Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Sipab4Ticket ticket) {
        this.ticket = ticket;
    }
}

