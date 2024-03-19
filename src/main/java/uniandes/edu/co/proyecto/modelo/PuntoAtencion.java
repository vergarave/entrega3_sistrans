package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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

  private String horarioAtencion;

  private String direccion;

  @OneToMany
  @JoinColumn(name = "id_oficina", referencedColumnName = "id")
  private Oficina idOficina;

  public PuntoAtencion() {
    ;
  }

  public PuntoAtencion(String tipo, String ciudad, String horarioAtencion, String direccion, Oficina idOficina) {
    this.tipo = tipo;
    this.ciudad = ciudad;
    this.horarioAtencion = horarioAtencion;
    this.direccion = direccion;
    this.idOficina = idOficina;
  }

  public Oficina getIdOficina() {
    return idOficina;
  }

  public void setIdOficina(Oficina idOficina) {
    this.idOficina = idOficina;
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
    return horarioAtencion;
  }

  public void setHorarioAtencion(String horarioAtencion) {
    this.horarioAtencion = horarioAtencion;
  }

  public String getDireccion() {
    return direccion;
  }

  public void setDireccion(String direccion) {
    this.direccion = direccion;
  }

}
