package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "puntosatencion")
public class PuntoAtencion {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer idPuntosAtencion;

  private String tipo;

  private String ciudad;

  private String horarioAtencion; // NO ESTOY SEGURO SI ES STRING

  private String direccion;

  @ManyToMany
  @JoinColumn(name = "oficina", referencedColumnName = "id")
  private Oficina oficina;

  public PuntoAtencion() {
    ;
  }

  public PuntoAtencion(String tipo, String ciudad, String horarioAtencion, String direccion,
      Oficina oficina) {
    this.tipo = tipo;
    this.ciudad = ciudad;
    this.horarioAtencion = horarioAtencion;
    this.direccion = direccion;
    this.oficina = oficina;
  }

}
