package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "operaciones_prestamos")
public class OperacionPrestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private String tipo_operacion;
    private Date fecha;
    private Integer cuenta_prestamo;
    private Float monto_operacion;
    private Integer cliente;

    @OneToMany
    @JoinColumn(name = "punto_atencion", referencedColumnName = "id")
    private PuntoAtencion punto_atencion;

    public OperacionPrestamo(String tipo_operacion, Date fecha, Integer cuenta_prestamo, Float monto_operacion,
            Integer cliente, PuntoAtencion punto_atencion) {
        this.tipo_operacion = tipo_operacion;
        this.fecha = fecha;
        this.cuenta_prestamo = cuenta_prestamo;
        this.monto_operacion = monto_operacion;
        this.cliente = cliente;
        this.punto_atencion = punto_atencion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipo_operacion() {
        return tipo_operacion;
    }

    public void setTipo_operacion(String tipo_operacion) {
        this.tipo_operacion = tipo_operacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCuenta_prestamo() {
        return cuenta_prestamo;
    }

    public void setCuenta_prestamo(Integer cuenta_prestamo) {
        this.cuenta_prestamo = cuenta_prestamo;
    }

    public Float getMonto_operacion() {
        return monto_operacion;
    }

    public void setMonto_operacion(Float monto_operacion) {
        this.monto_operacion = monto_operacion;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public PuntoAtencion getPunto_atencion() {
        return punto_atencion;
    }

    public void setPunto_atencion(PuntoAtencion punto_atencion) {
        this.punto_atencion = punto_atencion;
    }

    

}
