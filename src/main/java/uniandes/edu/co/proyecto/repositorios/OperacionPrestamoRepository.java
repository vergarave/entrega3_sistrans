package uniandes.edu.co.proyecto.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;

import java.sql.Date;
import java.util.Collection;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface OperacionPrestamoRepository extends JpaRepository<OperacionPrestamo, Integer>{

    @Query(value = "SELECT * FROM operaciones_prestamos", nativeQuery = true)
    Collection<OperacionPrestamo> darOperacionesPrestamos();

    @Query(value = "SELECT * FROM operaciones_prestamos WHERE id = :id", nativeQuery = true)
    OperacionPrestamo darOperacionPrestamo(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM operaciones_prestamos WHERE id = :id", nativeQuery = true)
    void eliminaOperacionPrestamo(@Param("id") long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO operaciones_prestamos (id, tipo_operacion, fecha, cuenta_prestamo,monto_operacion,cliente,punto_atencion) VALUES (proyecto_sequence.nextval, :tipo_operacion,TO_DATE(:fecha, 'DD/MM/YYYY'), :cuenta_prestamo, :monto_operacion, :cliente, :punto_atencion) ", nativeQuery = true)
    void insertarOperacionPrestamo(@Param("tipo_operacion") String tipo_operacion,
        @Param("fecha") Date fecha,
        @Param("cuenta_prestamo") Integer cuenta_prestamo,
        @Param("monto_operacion") Float monto_operacion,
        @Param("cliente") Integer cliente,
        @Param("punto_atencion") Integer punto_atencion);

    @Modifying
    @Transactional
    @Query(value = "UPDATE operaciones_prestamos SET tipo_operacion = :tipo_operacion, fecha= :fecha, cuenta_prestamo= :cuenta_prestamo, monto_operacion= :monto_operacion, cliente= :cliente,punto_atencion = :punto_atencion WHERE id = :id", nativeQuery = true)
    void actualizarOperacionPrestamo(@Param("id") long id,
        @Param("tipo_operacion") String tipo_operacion,
        @Param("fecha") Date fecha,
        @Param("cuenta_prestamo") Integer cuenta_prestamo,
        @Param("monto_operacion") Float monto_operacion,
        @Param("cliente") Integer cliente,
        @Param("punto_atencion") Integer punto_atencion);


    @Query(value = "SELECT id FROM operaciones_prestamos WHERE tipo_operacion = :tipo_operacion and cuenta_prestamo= :cuenta_prestamo and monto_operacion= :monto_operacion and cliente= :cliente and punto_atencion = :punto_atencion", nativeQuery = true)
    Integer darIdOperacionPrestamo(@Param("tipo_operacion") String tipo_operacion,
        @Param("cuenta_prestamo") Integer cuenta_prestamo,
        @Param("monto_operacion") Float monto_operacion,
        @Param("cliente") Integer cliente,
        @Param("punto_atencion") Integer punto_atencion);

}
