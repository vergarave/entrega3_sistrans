package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private Integer numero_documento;
  private String tipo;
  private String tipoDocumento;
  private String nombre;
  private String nacionalidad;
  private String direccion_fisica;
  private String direccion_electronica;
  private String telefono;
  private String codigo_postal;
  private String ciudad;
  private String departamento;

  public Cliente() {
    ;
  }

  public Cliente(Integer numero_documento, String tipo, String tipoDocumento, String nombre, String nacionalidad,
      String direccion_fisica, String direccion_electronica, String telefono, String codigo_postal, String ciudad,
      String departamento) {
    this.numero_documento = numero_documento;
    this.tipo = tipo;
    this.tipoDocumento = tipoDocumento;
    this.nombre = nombre;
    this.nacionalidad = nacionalidad;
    this.direccion_fisica = direccion_fisica;
    this.direccion_electronica = direccion_electronica;
    this.telefono = telefono;
    this.codigo_postal = codigo_postal;
    this.ciudad = ciudad;
    this.departamento = departamento;

  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getNumero_documento() {
    return numero_documento;
  }

  public void setNumero_documento(Integer numero_documento) {
    this.numero_documento = numero_documento;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getTipoDocumento() {
    return tipoDocumento;
  }

  public void setTipoDocumento(String tipoDocumento) {
    this.tipoDocumento = tipoDocumento;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getNacionalidad() {
    return nacionalidad;
  }

  public void setNacionalidad(String nacionalidad) {
    this.nacionalidad = nacionalidad;
  }

  public String getDireccion_fisica() {
    return direccion_fisica;
  }

  public void setDireccion_fisica(String direccion_fisica) {
    this.direccion_fisica = direccion_fisica;
  }

  public String getDireccion_electronica() {
    return direccion_electronica;
  }

  public void setDireccion_electronica(String direccion_electronica) {
    this.direccion_electronica = direccion_electronica;
  }

  public String getTelefono() {
    return telefono;
  }

  public void setTelefono(String telefono) {
    this.telefono = telefono;
  }

  public String getCodigoPostal() {
    return codigo_postal;
  }

  public void setCodigoPostal(String codigoPostal) {
    this.codigo_postal = codigoPostal;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getDepartamento() {
    return departamento;
  }

  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }

}
