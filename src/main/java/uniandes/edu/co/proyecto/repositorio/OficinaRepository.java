package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.Oficina;
import uniandes.edu.co.proyecto.modelo.OperacionCuenta;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface OficinaRepository extends JpaRepository<Oficina, Integer> {

  @Query(value = "SELECT * FROM oficinas", nativeQuery = true)
  Collection<Oficina> darOficinas();

  @Query(value = "SELECT * FROM oficinas WHERE id = :id", nativeQuery = true)
  Oficina darOficina(@Param("id") int id);

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM oficinas WHERE id = :id", nativeQuery = true)
  void eliminarOficina(@Param("id") long id);

  @Modifying
  @Transactional
  @Query(value = "INSERT INTO oficinas (id_Oficina, nombre, direccion, numPuntosAtencion, ciudad, gerente) VALUES(proyecto_sequence.nextval) ", nativeQuery = true)
  OperacionCuenta insertarOficina(@Param("nombre") String nombre,
      @Param("direccion") String direccion,
      @Param("numPuntosAtencion") Integer numPuntosAtencion,
      @Param("ciudad") String ciudad,
      @Param("gerente") Empleado gerente);

}