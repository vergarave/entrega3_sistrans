package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Afiliado;

@Repository
public interface AfiliadoRepository extends JpaRepository<Afiliado, Integer> {

    @Query(value = "SELECT * FROM afiliados", nativeQuery =true)
    Collection<Afiliado> darAfiliados();

    @Query(value = "SELECT * FROM afiliados WHERE tipoDoc = :tipoDoc AND numDoc = :numDoc", nativeQuery = true)
    Optional<Afiliado> darAfiliado(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Integer numDoc);
    
    @Modifying
    @Transactional
    @Query(value = "INSERT INTO afiliados (tipoDoc, numDoc, nombre, fechaNac, ciudad, direccion, telefono, epsAsociada)" + 
            " VALUES(:tipoDoc, :numDoc, :nombre, :fechaNac, :ciudad, :direccion, :telefono, :nitEps)", nativeQuery = true )
    void insertarAfiliado(@Param("tipoDoc") String tipoDoc, 
                            @Param("numDoc") Integer numDoc, 
                            @Param("nombre") String nombre, 
                            @Param("fechaNac") Date fechaNac, 
                            @Param("ciudad") String ciudad, 
                            @Param("direccion") String direccion, 
                            @Param("telefono") Integer telefono, 
                            @Param("nitEps") String nitEps);

    @Modifying
    @Transactional
    @Query(value = "UPDATE afiliados SET nombre = :nombre, fecha_nac = :fechaNac, ciudad = :ciudad, direccion = :direccion, " +
                    "telefono = :telefono, nit_eps = :nitEps " +
                    "WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void actualizarAfiliado(@Param("tipoDoc") String tipoDoc, 
                            @Param("numDoc") Integer numDoc, 
                            @Param("nombre") String nombre, 
                            @Param("fechaNac") Date fechaNac, 
                            @Param("ciudad") String ciudad, 
                            @Param("direccion") String direccion, 
                            @Param("telefono") Integer telefono, 
                            @Param("nitEps") String nitEps);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM afiliados WHERE tipo_doc = :tipoDoc AND num_doc = :numDoc", nativeQuery = true)
    void eliminarAfiliado(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Integer numDoc);
}
