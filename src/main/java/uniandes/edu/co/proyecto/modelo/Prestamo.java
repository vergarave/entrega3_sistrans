package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="prestamos")
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numPrestamo;
    private String estado;
    private String tipoPrestamo;
    private Integer monto;
    private Float intereses;
    private Integer numCuotas;
    private String diaMesAPagarCuota;
    private Float valorCuota;
    private String gerenteCreador;
    private Float saldoPendiente;



    public Prestamo(int id, Integer numPrestamo, String estado, String tipoPrestamo, Integer monto, Float intereses,
    Integer numCuotas, String diaMesAPagarCuota, Float valorCuota, String gerenteCreador, Float saldoPendiente ) {
        this.id = id;
        this.numPrestamo = numPrestamo;
        this.tipoPrestamo = tipoPrestamo;
        this.monto=monto;
        this.intereses=intereses;
        this.numCuotas=numCuotas;
        this.diaMesAPagarCuota=diaMesAPagarCuota;
        this.valorCuota=valorCuota;
        this.gerenteCreador=gerenteCreador;
        this.saldoPendiente=saldoPendiente;

    }



    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }



    public Integer getNumPrestamo() {
        return numPrestamo;
    }



    public void setNumPrestamo(Integer numPrestamo) {
        this.numPrestamo = numPrestamo;
    }



    public String getEstado() {
        return estado;
    }



    public void setEstado(String estado) {
        this.estado = estado;
    }



    public String getTipoPrestamo() {
        return tipoPrestamo;
    }



    public void setTipoPrestamo(String tipoPrestamo) {
        this.tipoPrestamo = tipoPrestamo;
    }



    public Integer getMonto() {
        return monto;
    }



    public void setMonto(Integer monto) {
        this.monto = monto;
    }



    public Float getIntereses() {
        return intereses;
    }



    public void setIntereses(Float intereses) {
        this.intereses = intereses;
    }



    public Integer getNumCuotas() {
        return numCuotas;
    }



    public void setNumCuotas(Integer numCuotas) {
        this.numCuotas = numCuotas;
    }



    public String getDiaMesAPagarCuota() {
        return diaMesAPagarCuota;
    }



    public void setDiaMesAPagarCuota(String diaMesAPagarCuota) {
        this.diaMesAPagarCuota = diaMesAPagarCuota;
    }



    public Float getValorCuota() {
        return valorCuota;
    }



    public void setValorCuota(Float valorCuota) {
        this.valorCuota = valorCuota;
    }



    public String getGerenteCreador() {
        return gerenteCreador;
    }



    public void setGerenteCreador(String gerenteCreador) {
        this.gerenteCreador = gerenteCreador;
    }



    public Float getSaldoPendiente() {
        return saldoPendiente;
    }



    public void setSaldoPendiente(Float saldoPendiente) {
        this.saldoPendiente = saldoPendiente;
    }


}