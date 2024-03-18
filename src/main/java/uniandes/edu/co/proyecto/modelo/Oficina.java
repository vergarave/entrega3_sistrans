package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "oficinas")
public class Oficina {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String nombre;

  private String direccion;

  private Integer numPuntosAtencion;

  private String ciudad;

  private Empleado gerente;

  public Oficina() {
    ;
  }

  public Oficina(String nombre, String direccion, Integer numPuntosAtencion, String ciudad, Empleado gerente) {
    this.nombre = nombre;
    this.direccion = direccion;
    this.numPuntosAtencion = numPuntosAtencion;
    this.ciudad = ciudad;
    this.gerente = gerente;
  }

}
