package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public abstract class Persona {

  @Id
  private Integer numeroDocumento;

  private String tipo;

  private String tipoDocumento;
  private String nombre;
  private String nacionalidad;
  private String direccionFisica;
  private String direccionElectronica;
  private String telefono;
  private String codigoPostal;
  private String ciudad;
  private String departamento;

  public Persona() {;}

}
