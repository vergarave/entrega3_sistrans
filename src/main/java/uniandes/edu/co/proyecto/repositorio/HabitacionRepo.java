package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Habitacion;


public interface HabitacionRepo extends JpaRepository <Habitacion, Integer> {

    // Creation
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO habitaciones (idhabitacion, numhabitacion, disponible, precionoche) VALUES (parranderos_sequence.nextval, :numhabitacion, :disponible, :precionoche)", nativeQuery = true)
    void insertarHabitacion(@Param("numhabitacion") Integer numhabitacion, @Param("disponible") String disponible, @Param("precionoche") Integer precionoche);


    // Read
    @Query(value = "SELECT * FROM habitaciones", nativeQuery = true)
    Collection<Habitacion> darHabitaciones();

    @Query(value = "SELECT * FROM habitaciones WHERE idhabitacion = :idhabitacion", nativeQuery = true)
    Habitacion darHabitacion(@Param("idhabitacion") int idhabitacion);


    // Update
    @Modifying
    @Transactional
    @Query(value = "UPDATE habitacones SET numhabitacion=:numhabitacion, disponible=:disponible, precionoche=:precionoche WHERE idhabitacion=:idhabitacion", nativeQuery = true)
    void actualizarHabitacion(@Param("idhabitacion") int idhabitacion, @Param("numhabitacion") Integer numhabitacion, @Param("disponible") String disponible, @Param("precionoche") Integer precionoche);


    // Delete
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM habitaciones WHERE idhabitacion =: idhabitacion", nativeQuery = true)
    void eliminarHabitacion(@Param("idhabitacion") int idhabitacion);

}