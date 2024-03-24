package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "puntos_atencion")
public class PuntoAtencion {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String tipo;

  private String ciudad;

  private String horario_atencion;

  private String direccion;

  @ManyToOne
  @JoinColumn(name = "id_oficina", referencedColumnName = "id")
  private Oficina id_oficina;

  public PuntoAtencion() {
    ;
  }

  public PuntoAtencion(String tipo, String ciudad, String horario_atencion, String direccion, Oficina id_oficina) {
    this.tipo = tipo;
    this.ciudad = ciudad;
    this.horario_atencion = horario_atencion;
    this.direccion = direccion;
    this.id_oficina = id_oficina;
  }

  public Oficina getIdOficina() {
    return id_oficina;
  }

  public void setIdOficina(Oficina id_oficina) {
    this.id_oficina = id_oficina;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTipo() {
    return tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getCiudad() {
    return ciudad;
  }

  public void setCiudad(String ciudad) {
    this.ciudad = ciudad;
  }

  public String getHorarioAtencion() {
    return horario_atencion;
  }

  public void setHorarioAtencion(String horario_atencion) {
    this.horario_atencion = horario_atencion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

}
