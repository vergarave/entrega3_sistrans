package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.AfiliadoRelacion;
import uniandes.edu.co.proyecto.modelo.AfiliadosRelacionadosPK;

@Repository
public interface AfiliadoRelacionRepository extends JpaRepository<AfiliadoRelacion, AfiliadosRelacionadosPK> {

    @Query(value = "SELECT * FROM AFILIADOSRELACIONADOS", nativeQuery = true)
    Collection<AfiliadoRelacion> darAfiliadoRelaciones();

    @Query(value = "SELECT * FROM AFILIADOSRELACIONADOS WHERE NUMERO_DOCUMENTO = :numDoc AND AFILIADO_RELACIONADO_NUM = :relacionadoNum", nativeQuery = true)
    Optional<AfiliadoRelacion> darAfiliadoRelacion(@Param("numDoc") Integer numDoc, @Param("relacionadoNum") Integer relacionadoNum);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO AFILIADOSRELACIONADOS (NUMERO_DOCUMENTO, AFILIADO_RELACIONADO_NUM, TIPO, RELACION_PARENTESCO) " +
               "VALUES (:numDoc, :relacionadoNum, :tipoAfiliado, :relacionParentesco)", nativeQuery = true)
    void insertarAfiliadoRelacion(@Param("numDoc") Integer numDoc, @Param("relacionadoNum") Integer relacionadoNum,
               @Param("tipoAfiliado") String tipoAfiliado, @Param("relacionParentesco") String relacionParentesco);

    @Modifying
    @Transactional
    @Query(value = "UPDATE AFILIADOSRELACIONADOS SET TIPO = :tipoAfiliado, RELACION_PARENTESCO = :relacionParentesco " +
    "WHERE NUMERO_DOCUMENTO = :numDoc AND AFILIADO_RELACIONADO_NUM = :relacionadoNum", nativeQuery = true)
    void actualizarAfiliadoRelacion(@Param("numDoc") Integer numDoc, @Param("relacionadoNum") Integer relacionadoNum,
                      @Param("tipoAfiliado") String tipoAfiliado, @Param("relacionParentesco") String relacionParentesco);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM AFILIADOSRELACIONADOS WHERE NUMERO_DOCUMENTO = :numDoc AND AFILIADO_RELACIONADO_NUM = :relacionadoNum", nativeQuery = true)
    void eliminarAfiliadoRelacion(@Param("numDoc") Integer numDoc, @Param("relacionadoNum") Integer relacionadoNum);
    
}
