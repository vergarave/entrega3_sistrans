package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.sql.Time;
import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Cita;

@Repository
public interface CitaRepository extends JpaRepository<Cita, Integer> {

    @Query(value = "SELECT * FROM CITAS", nativeQuery = true)
    Collection<Cita> darCitas();
    
    @Query(value = "SELECT * FROM CITAS WHERE ID = :id", nativeQuery = true)
    Optional<Cita> darCita(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO CITAS (ID, FECHA, HORA, ATENDIDA_EN, NUMDOCAFILIADO, ORDENSERVICIO) " +
                   "VALUES (CITAS_SEQ.nextval, :fecha, :hora, :ipsNit, :numDocAfiliado, :numOrden)", nativeQuery = true)
    void insertarCita(@Param("fecha") Date fecha, 
                      @Param("hora") Time hora, 
                      @Param("ipsNit") String ipsNit,  
                      @Param("numDocAfiliado") Integer numDocAfiliado, 
                      @Param("numOrden") Integer numOrden);

    @Modifying
    @Transactional
    @Query(value = "UPDATE CITAS SET FECHA = :fecha, HORA = :hora, ATENDIDA_EN = :ipsNit, ORDENSERVICIO = :numOrden " +
                   "WHERE ID = :id", nativeQuery = true)
    void actualizarCita(@Param("id") Integer id, 
                        @Param("fecha") Date fecha, 
                        @Param("hora") Time hora, 
                        @Param("ipsNit") String ipsNit, 
                        @Param("numOrden") Integer numOrden);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM CITAS WHERE ID = :id", nativeQuery = true)
    void eliminarCita(@Param("id") Integer id);
}