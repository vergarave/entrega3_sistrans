package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Persona;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Integer> {

  @Query(value = "SELECT * FROM prestamos", nativeQuery = true)
  Collection<Prestamo> darPrestamos();

  @Query(value = "SELECT * FROM prestamos WHERE id = :id", nativeQuery = true)
  Prestamo darPrestamo(@Param("id") int id);
  /*
   * @Modifying
   * 
   * @Transactional
   * 
   * @Query(value = "INSERT INTO prestamos (id, estadoPrestamo, tipoPrestamo,
   * monto, interes,numeroCuotas,fechaPagoCuota,valorCuota,saldoPendiente,gerente,
   * cliente) VALUES
   * ( parranderos_sequence.nextval , :nombre, :ciudad, :presupuesto,
   * :cant_sedes)", nativeQuery = true)
   * void insertarPrestamo(@Param("id") Integer id, @Param("estadoPrestamo")
   * String estadoPrestamo,
   * 
   * @Param("tipoPrestamo") String tipoPrestamo, @Param("monto") double monto
   * , @Param("interes") double interes, @Param("numeroCuotas") Integer
   * numeroCuotas,
   * 
   * @Param("fechaPagoCuota") Date fechaPagoCuota,@Param("valorCuota") double
   * valorCuota,
   * 
   * @Param("saldoPendiente") double saldoPendiente,@Param("gerente") Empleado
   * gerente, @Param("cliente")Persona cliente
   * );
   * // ,,saldoPendiente,gerente
   */

  @Modifying
  @Transactional
  @Query(value = "DELETE FROM prestamos WHERE id = :id", nativeQuery = true)
  void eliminaPrestamo(@Param("id") long id);
}