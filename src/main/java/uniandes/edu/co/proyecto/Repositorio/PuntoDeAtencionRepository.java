package uniandes.edu.co.proyecto.Repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;
import uniandes.edu.co.proyecto.modelo.PuntoDeAtencion;

public interface PuntoDeAtencionRepository extends JpaRepository<PuntoDeAtencion,String> {
    @Query(value = "SELECT * FROM puntos_de_atencion")
    Collection<PuntoDeAtencion> getPuntoDeAtencion();

    @Query(value = "SELECT * FROM puntos_de_atencion WHERE id= :id", nativeQuery = true )
    PuntoDeAtencion getPuntoDeAtencion(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO puntos_de_atencion (id, tipo, localizacion, oficina) VALUES(bancandes_sequence.nextval, :tipo, :localizacion, :oficina", nativeQuery = true )
    void insertarPuntoDeAtencion(@Param("tipo") String tipo, @Param("localizacion") String localizacion, @Param("oficina") Oficina oficina);


    @Modifying
    @Transactional
    @Query(value = "UPDATE puntos_de_atencion SET tipo = :tipo, localizacion =: localizacion, oficina =: oficina WHERE id =:id", nativeQuery = true)
    void actualizarPuntoDeAtencion(@Param("tipo") String tipo, @Param("localizacion") String localizacion, @Param("oficina") Oficina oficina);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM puntos_de_atencion WHERE id =:id", nativeQuery = true)
    void eliminarPuntoDeAtencion(@Param("tipo") String tipo, @Param("localizacion") String localizacion, @Param("oficina") Oficina oficina);
  
}
