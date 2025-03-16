package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.AfiliadoPK;
import uniandes.edu.co.proyecto.modelo.AfiliadoRelacion;

public interface AfiliadoRelacionRepository extends JpaRepository<AfiliadoRelacion, AfiliadoPK> {

    @Query(value = "SELECT * FROM afiliadosrelaciones", nativeQuery = true)
    Collection<AfiliadoRelacion> darAfiliadoRelaciones();

    @Query(value = "SELECT * FROM afiliadosrelaciones WHERE tipoDoc = :tipoDoc AND numDoc = :numDoc", nativeQuery = true)
    Optional<AfiliadoRelacion> darAfiliadoRelacion(@Param("tipoDoc") String tipoDoc, @Param("numDoc") Integer numDoc);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO afiliadosrelaciones (tipoDoc, numDoc, tipoAfiliado, relacionParentesco, tipoDocAf, numDocAf) " +
               "VALUES (:tipoDoc, :numDoc, :tipoAfiliado, :relacionParentesco, :tipoDocAf, :numDocAf)", nativeQuery = true)
    void insertarAfiliadoRelacion(@Param("tipoDoc") String tipoDoc, 
                              @Param("numDoc") Integer numDoc, 
                              @Param("tipoAfiliado") String tipoAfiliado, 
                              @Param("relacionParentesco") String relacionParentesco, 
                              @Param("tipoDocAf") String tipoDocAf, 
                              @Param("numDocAf") Integer numDocAf);

    @Modifying
    @Transactional
    @Query(value = "UPDATE afiliadosrelaciones SET tipoAfiliado = :tipoAfiliado, relacionParentesco = :relacionParentesco " +
               "WHERE tipoDoc = :tipoDoc AND numDoc = :numDoc", nativeQuery = true)
    void actualizarAfiliadoRelacion(@Param("tipoDoc") String tipoDoc, 
                                @Param("numDoc") Integer numDoc, 
                                @Param("tipoAfiliado") String tipoAfiliado, 
                                @Param("relacionParentesco") String relacionParentesco);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM afiliadosrelaciones WHERE tipoDoc = :tipoDoc AND numDoc = :numDoc", 
       nativeQuery = true)
    void eliminarAfiliadoRelacion(@Param("tipoDoc") String tipoDoc, 
                              @Param("numDoc") Integer numDoc);
    
}
