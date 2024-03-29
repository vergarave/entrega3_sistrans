package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficinas")
public class Oficina {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nombre;

  private String direccion;

  private int numero_puntos_atencion;

  private int gerente;

  private String ciudad;


  public Oficina() {
    ;
  }

  public Oficina(String nombre, String direccion, Integer numero_puntos_atencion, String ciudad, Integer gerente) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.numero_puntos_atencion = numero_puntos_atencion;
    this.ciudad = ciudad;
    this.gerente = gerente;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

  public Integer getNumero_puntos_atencion() {
    return numero_puntos_atencion;
  }

  public void setNumero_puntos_atencion(Integer numero_puntos_atencion) {
    this.numero_puntos_atencion = numero_puntos_atencion;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public Integer getGerente() {
    return gerente;
  }

  public void setGerente(Integer gerente) {
    this.gerente = gerente;
  }

}
