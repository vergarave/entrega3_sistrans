package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.PuntoAtencion;

public interface PuntoAtencionRepository extends JpaRepository<PuntoAtencion, Integer> {

  @Query(value = "SELECT * FROM puntosatencion", nativeQuery = true)
  Collection<PuntoAtencion> darPuntosAtencion();

  @Query(value = "SELECT * FROM puntosatencion WHERE id = :id", nativeQuery = true)
  PuntoAtencion darPuntoAtencion(@Param("id") int id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM puntosatencion WHERE id = :id", nativeQuery = true)
  void eliminarPuntoAtencion(@Param("id") long id);

  @Query(value = "INSERT INTO puntosatencion (numeroCuenta, estado, saldo, tipo, ultimaTransaccion, fechaCreacion, gerente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  OperacionCuenta insertarCuenta(@Param("estado") String estado,
      @Param("saldo") double saldo,
      @Param("tipo") String tipo,
      @Param("ultimaTransaccion") Date ultimaTransaccion,
      @Param("fechaCreacion") Date fechaCreacion,
      @Param("gerente") Empleado gerente);

}