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
public interface CitaRepository extends JpaRepository<Cita, Integer>{

    @Query(value = "SELECT * FROM citas", nativeQuery =true)
    Collection<Cita> darCitas();
    
    @Query(value = "SELECT * FROM citas WHERE id = :id", nativeQuery = true)
    Optional<Cita> darCita(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO citas (id, fecha, hora, ipsNit, tipoDocAfiliado, numDocAfiliado, ordenServicio) " +
               "VALUES (proyecto_sequence.nextval, :fecha, :hora, :ipsNit, :tipoDocAfiliado, :numDocAfiliado, :numOrden)", nativeQuery = true)
    void insertarCita(@Param("fecha") Date fecha, 
                    @Param("hora") Time hora, 
                    @Param("ipsNit") String ipsNit, 
                    @Param("tipoDocAfiliado") String tipoDocAfiliado, 
                    @Param("numDocAfiliado") Integer numDocAfiliado, 
                    @Param("numOrden") Integer numOrden);

    @Modifying
    @Transactional
    @Query(value = "UPDATE citas SET fecha = :fecha, hora = :hora, ips_nit = :ipsNit, orden_servicio = :numOrden WHERE id = :id",  nativeQuery = true)
    void actualizarCita(@Param("id") Integer id, 
                        @Param("fecha") Date fecha, 
                        @Param("hora") Time hora, 
                        @Param("ipsNit") String ipsNit, 
                        @Param("numOrden") Integer numOrden);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM citas WHERE id = :id", nativeQuery = true)
    void eliminarCita(@Param("id") Integer id);
    
}
