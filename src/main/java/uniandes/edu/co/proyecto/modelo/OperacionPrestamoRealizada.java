package uniandes.edu.co.proyecto.modelo;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "operaciones_prestamo_realizada")
public class OperacionPrestamoRealizada {
  @EmbeddedId
  private OperacionPrestamoRealizadaPK pk;

  public OperacionPrestamoRealizada() {
    ;
  }

  public OperacionPrestamoRealizada(OperacionPrestamo id_operacion_prestamo, PtoAtencion id_punto_atencion) {
    this.pk = new OperacionPrestamoRealizadaPK(id_operacion_prestamo, id_punto_atencion);
  }

  public OperacionPrestamoRealizadaPK getPk() {
    return pk;
  }

  public void setPk(OperacionPrestamoRealizadaPK pk) {
    this.pk = pk;
  }

}
