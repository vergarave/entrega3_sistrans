package uniandes.edu.co.proyecto.modelo;

import java.util.ArrayList;
import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import oracle.net.aso.l;

@Entity
@Table(name = "prestamos")
public class Prestamo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String estadoPrestamo;

  private String tipoPrestamo;

  private double monto;

  private double interes;

  private int numeroCuotas;
  // Las cuotas son int verdad?

  private Date fechaPagoCuota;

  private double valorCuota;

  private double saldoPendiente;

  private Empleado gerente;
  // NO ESTOY SEGURO SI ES MANY TO ONE O ONETOMANY
  @ManyToOne
  @JoinColumn(name = "cliente", referencedColumnName = "id")
  private Persona cliente;

  public Prestamo() {
    ;
  }

  public Prestamo(String estadoPrestamo, String tipoPrestamo, double monto, double interes,
      int numeroCuotas, Date fechaPagoCuota, double valorCuota, double saldoPendiente, Empleado gerente,
      Persona cliente) {
    this.estadoPrestamo = estadoPrestamo;
    this.tipoPrestamo = tipoPrestamo;
    this.monto = monto;
    this.interes = interes;
    this.numeroCuotas = numeroCuotas;
    this.fechaPagoCuota = fechaPagoCuota;
    this.valorCuota = valorCuota;
    this.saldoPendiente = saldoPendiente;
    this.gerente = gerente;
    this.cliente = cliente;
  }

  public Integer getId() {
    return id;
  }

  public String getEstadoPrestamo() {
    return estadoPrestamo;
  }

  public String getTipoPrestamo() {
    return tipoPrestamo;
  }

  public double getMonto() {
    return monto;
  }

  public double getInteres() {
    return interes;
  }

  public int getNumeroCuotas() {
    return numeroCuotas;
  }

  public Date getFechaPagoCuota() {
    return fechaPagoCuota;
  }

  public double getValorCuota() {
    return valorCuota;
  }

  public double getSaldoPendiente() {
    return saldoPendiente;
  }

  public Empleado getGerente() {
    return gerente;
  }

  public Persona getCliente() {
    return cliente;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setEstadoPrestamo(String estadoPrestamo) {
    this.estadoPrestamo = estadoPrestamo;
  }

  public void setTipoPrestamo(String tipoPrestamo) {
    this.tipoPrestamo = tipoPrestamo;
  }

  public void setMonto(double monto) {
    this.monto = monto;
  }

  public void setInteres(double interes) {
    this.interes = interes;
  }

  public void setNumeroCuotas(int numeroCuotas) {
    this.numeroCuotas = numeroCuotas;
  }

  public void setFechaPagoCuota(Date fechaPagoCuota) {
    this.fechaPagoCuota = fechaPagoCuota;
  }

  public void setValorCuota(double valorCuota) {
    this.valorCuota = valorCuota;
  }

  public void setSaldoPendiente(double saldoPendiente) {
    this.saldoPendiente = saldoPendiente;
  }

  public void setGerente(Empleado gerente) {
    this.gerente = gerente;
  }

  public void setCliente(Persona cliente) {
    this.cliente = cliente;
  }

}
