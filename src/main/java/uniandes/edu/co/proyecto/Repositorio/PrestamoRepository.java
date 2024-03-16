package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo,Integer> {
    @Query(value = "SELECT * FROM prestamos")
    Collection<Prestamo> getPrestamo();

    @Query(value = "SELECT * FROM prestamos WHERE id= :id", nativeQuery = true )
    Prestamo getPrestamo(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO prestamos (id, interes, cuotas, valorCuenta, monto, diaCorte) VALUES(bancandes_sequence.nextval, :interes, :cuotas, :valorCuenta, :monto, :diaCorte", nativeQuery = true )
    void insertarPrestamo(@Param("interes") Integer interes, @Param("cuotas") Integer cuotas, @Param("valorCuenta") Integer valorCuenta, @Param("monto") Integer monto, @Param("diaCorte") String diaCorte);


    @Modifying
    @Transactional
    @Query(value = "UPDATE prestamos SET interes = :interes, cuotas =: cuotas, valorCuenta =: valorCuenta WHERE id =:id", nativeQuery = true)
    void actualizarPrestamo(@Param("interes") Integer interes, @Param("cuotas") Integer cuotas, @Param("valorCuenta") Integer valorCuenta, @Param("monto") Integer monto, @Param("diaCorte") String diaCorte);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM prestamos WHERE id =:id", nativeQuery = true)
    void eliminarPrestamo(@Param("interes") Integer interes, @Param("cuotas") Integer cuotas, @Param("valorCuenta") Integer valorCuenta, @Param("monto") Integer monto, @Param("diaCorte") String diaCorte);
  
}