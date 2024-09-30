package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.Ciudad;

public interface BodegaRepository extends JpaRepository<Bodega, Integer>
{
    @Query(value = "SELET * FROM bodegas",nativeQuery = true)
    Collection<Ciudad> darBodegas();

    @Query(value = "SELECT * FROM bodegas WHERE id= :id",nativeQuery = true)
    Ciudad darBodega(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO bodegas (nombre,tamaño) VALUES(:nombre,:tamaño)",nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre,@Param("tamaño") Integer tamaño);

    @Modifying
    @Transactional
    @Query(value="UPDATE bodegas SET nombre = :nombre, tamaño= :tamaño WHERE id = :id",nativeQuery = true)
    void actualizarBodega(@Param("id") Integer id,@Param("nombre") String nombre,@Param("tamaño") Integer tamaño);

    @Query(value="DELETE FROM bodegas WHERE id= :id",nativeQuery = true)
    void eliminarBodega(@Param("id") Integer id);
}
