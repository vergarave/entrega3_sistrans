package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.ServicioSalud;

public interface ServicioSaludRepository extends JpaRepository<ServicioSalud, String>{

    @Query(value = "SELECT * FROM serviciosdesalud", nativeQuery = true)
    Collection<ServicioSalud> darServiciosSalud();

    @Query(value = "SELECT * FROM serviciosdesalud WHERE nombre = :nombre", nativeQuery = true)
    Optional<ServicioSalud> darServicioSalud(@Param("nombre") String nombre);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO serviciosdesalud (nombre, descripcion, tipo_servicio, ips_ofrecida) VALUES (:nombre, :descripcion, :tipoServicio, :ipsOfrecida)", nativeQuery = true)
    void insertarServicioSalud(@Param("nombre") String nombre, @Param("descripcion") String descripcion, 
                               @Param("tipoServicio") String tipoServicio, @Param("ipsOfrecida") String ipsOfrecida);

    @Modifying
    @Transactional
    @Query(value = "UPDATE serviciosdesalud SET descripcion = :descripcion, tipo_servicio = :tipoServicio, ips_ofrecida = :ipsOfrecida WHERE nombre = :nombre", nativeQuery = true)
    void actualizarServicioSalud(@Param("nombre") String nombre, @Param("descripcion") String descripcion, 
                                @Param("tipoServicio") String tipoServicio, @Param("ipsOfrecida") String ipsOfrecida);
    
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM serviciosdesalud WHERE nombre = :nombre", nativeQuery = true)
    void eliminarServicioSalud(@Param("nombre") String nombre);
}
