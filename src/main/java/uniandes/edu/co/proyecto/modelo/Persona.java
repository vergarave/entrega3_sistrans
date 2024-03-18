package uniandes.edu.co.proyecto.modelo;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public abstract class Persona {

  @Id
  private String numeroDocumento;

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

  public Persona() {
    ;
  }

  public Persona(String numeroDocumento, String tipo, String tipoDocumento, String nombre, String nacionalidad,
      String direccionFisica, String direccionElectronica, String telefono, String codigoPostal, String ciudad,
      String departamento) {
    this.numeroDocumento = numeroDocumento;
    this.tipo = tipo;
    this.tipoDocumento = tipoDocumento;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.direccionFisica = direccionFisica;
    this.direccionElectronica = direccionElectronica;
    this.telefono = telefono;
    this.codigoPostal = codigoPostal;
    this.ciudad = ciudad;
    this.departamento = departamento;
  }

}
