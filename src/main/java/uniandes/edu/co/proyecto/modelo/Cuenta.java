package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private String numeroCuenta;

  private String estado;

  private double saldo;

  private String tipo;

  private Date ultimaTransaccion;

  private Date fechaCreacion;

  private Empleado gerente;

  public Cuenta() {
    ;
  }

  public Cuenta(String estado, double saldo, String tipo, Date ultimaTransaccion,
      Date fechaCreacion, Empleado gerente) {
    this.estado = estado;
    this.saldo = saldo;
    this.tipo = tipo;
    this.ultimaTransaccion = ultimaTransaccion;
    this.fechaCreacion = fechaCreacion;
    this.gerente = gerente;
  }

  public String getNumeroCuenta() {
    return numeroCuenta;
  }

  public void setNumeroCuenta(String numeroCuenta) {
    this.numeroCuenta = numeroCuenta;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public double getSaldo() {
    return saldo;
  }

  public void setSaldo(double saldo) {
    this.saldo = saldo;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public Date getUltimaTransaccion() {
    return ultimaTransaccion;
  }

  public void setUltimaTransaccion(Date ultimaTransaccion) {
    this.ultimaTransaccion = ultimaTransaccion;
  }

  public Date getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Date fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Empleado getGerente() {
    return gerente;
  }

  public void setGerente(Empleado gerente) {
    this.gerente = gerente;
  }

}
