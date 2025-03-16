package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioIps;
import uniandes.edu.co.proyecto.modelo.ServicioIpsPK;

@Repository
public interface ServicioIpsRepository extends JpaRepository<ServicioIps, ServicioIpsPK> {

    @Query(value = "SELECT * FROM serviciosips", nativeQuery =true)
    Collection<ServicioIps> darServiciosIps();

    @Query(value = "SELECT * FROM serviciosips WHERE nombre_servicio = :nombreServicio AND nit_ips = :nitIps", nativeQuery = true)
    Optional<ServicioIps> darServicioIps(@Param("nombreServicio") String nombreServicio, @Param("nitIps") String nitIps);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosips (nombre_servicio, nit_ips) VALUES (:nombreServicio, :nitIps)", nativeQuery = true)
    void insertarServicioIps(@Param("nombreServicio") String nombreServicio, @Param("nitIps") String nitIps);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosips WHERE nombre_servicio = :nombreServicio AND nit_ips = :nitIps", nativeQuery = true)
    void eliminarServicioIps(@Param("nombreServicio") String nombreServicio, @Param("nitIps") String nitIps);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosips SET nombre_servicio = :nuevoNombreServicio WHERE nombre_servicio = :nombreServicio AND nit_ips = :nitIps", nativeQuery = true)
    void actualizarServicioIps(@Param("nombreServicio") String nombreServicio, @Param("nitIps") String nitIps, @Param("nuevoNombreServicio") String nuevoNombreServicio);

}
