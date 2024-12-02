package mexico.telcel.di.sds.gsa.dgpsti.esb.sipabservice.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "SIPAB4_TICKET")
public class Sipab4Ticket {

    @Id
    @Column(name = "NUMERO_TICKET", nullable = false, length = 20)
    private String numeroTicket;

    @Column(name = "CLIENTE", length = 50)
    private String cliente;

    @Column(name = "LINEA")
    private Integer linea;

    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;

    @Column(name = "ANIO")
    private Integer anio;

    @Column(name = "FOLIO", length = 20)
    private String folio;

    @Column(name = "ESTATUS", length = 20)
    private String estatus;

    @Column(name = "FECHA_CIERRE")
    @Temporal(TemporalType.DATE)
    private Date fechaCierre;

    // Relación "uno a muchos" con Sipab4EmpleadoTicket
    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Sipab4EmpleadoTicket> empleados;

    // Getters y Setters

    public String getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(String numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getLinea() {
        return linea;
    }

    public void setLinea(Integer linea) {
        this.linea = linea;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getFolio() {
        return folio;
    }

    public void setFolio(String folio) {
        this.folio = folio;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public Date getFechaCierre() {
        return fechaCierre;
    }

    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    public List<Sipab4EmpleadoTicket> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(List<Sipab4EmpleadoTicket> empleados) {
        this.empleados = empleados;
    }
}
