package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "operaciones_cuentas")
public class OperacionCuenta {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String tipoOperacion;
    private Date fecha;
    private String cuentaSalida;
    private String montoOperacion;
    private Date cliente;
    private String puntoAtencion;
    private String cuentaLlegada;

    public OperacionCuenta(String tipoOperacion, Date fecha, String cuentaSalida, String montoOperacion,
            Date cliente, String puntoAtencion, String cuentaLlegada) {
        this.tipoOperacion = tipoOperacion;
        this.fecha = fecha;
        this.cuentaSalida = cuentaSalida;
        this.montoOperacion = montoOperacion;
        this.cliente = cliente;
        this.puntoAtencion = puntoAtencion;
        this.cuentaLlegada = cuentaLlegada;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCuentaSalida(String cuentaSalida) {
        this.cuentaSalida = cuentaSalida;
    }

    public void setMontoOperacion(String montoOperacion) {
        this.montoOperacion = montoOperacion;
    }

    public void setCliente(Date cliente) {
        this.cliente = cliente;
    }

    public void setPuntoAtencion(String puntoAtencion) {
        this.puntoAtencion = puntoAtencion;
    }

    public void setCuentaLlegada(String cuentaLlegada) {
        this.cuentaLlegada = cuentaLlegada;
    }

    public Integer getId() {
        return id;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCuentaSalida() {
        return cuentaSalida;
    }

    public String getMontoOperacion() {
        return montoOperacion;
    }

    public Date getCliente() {
        return cliente;
    }

    public String getPuntoAtencion() {
        return puntoAtencion;
    }

    public String getCuentaLlegada() {
        return cuentaLlegada;
    }

}
