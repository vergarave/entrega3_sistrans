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

  @OneToMany
  @JoinColumn(name = "cliente", referencedColumnName = "id")
  private Persona cliente;

  @OneToMany
  @JoinColumn(name = "gerente", referencedColumnName = "id")
  private TieneCuentaEmpleado gerente;

  public Cuenta() {
    ;
  }

}
