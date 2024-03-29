package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;


import uniandes.edu.co.proyecto.modelo.TransaccionPrestamo;
import uniandes.edu.co.proyecto.modelo.TransaccionPrestamoPK;

import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface TransaccionPrestamoRepository extends JpaRepository<TransaccionPrestamo, TransaccionPrestamoPK>{

    @Query(value = "SELECT * FROM transacciones_prestamos", nativeQuery = true)
    Collection<TransaccionPrestamo> darTransaccionesPrestamos();

    @Query(value = "SELECT * FROM transacciones_prestamos WHERE id_operacion = :id_operacion AND id_prestamo = :id_prestamo", nativeQuery = true)
    TransaccionPrestamo darTransaccionPrestamo(@Param("id_operacion") Integer id_operacion, @Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM transacciones_prestamos WHERE id_operacion = :id_operacion AND id_prestamo = :id_prestamo", nativeQuery = true)
    void eliminarTransaccionPrestamo(@Param("id_operacion") Integer id_operacion, @Param("id_prestamo") Integer id_prestamo);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO transacciones_prestamos (id_operacion, id_prestamo)  \r\n" + //
                    "VALUES(:id_operacion, :id_prestamo) ", nativeQuery = true)
    void  insertarTransaccionPrestamo(@Param("id_operacion") Integer id_operacion, @Param("id_prestamo") Integer id_prestamo);


    @Modifying
    @Transactional
    @Query(value = "UPDATE transacciones_prestamos SET id_operacion = :id_operacion, id_prestamo = :id_prestamo WHERE id_operacion = :id_operacion AND id_prestamo = :id_prestamo", nativeQuery = true)
    void  actualizarTransaccionPrestamo(@Param("id_operacion") Integer id_operacion, @Param("id_prestamo") Integer id_prestamo);

}
