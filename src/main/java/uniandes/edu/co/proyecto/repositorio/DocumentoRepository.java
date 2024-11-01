package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Documento;

public interface DocumentoRepository extends JpaRepository<Documento,Integer>{

    @Modifying
    @Transactional
    @Query(
        value="insert into documentos (id_orden_compra) values(:id_orden_compra)",
        nativeQuery=true
    )
    void addDocumento(@Param("id_orden_compra")Integer id_orden_compra);

    @Modifying
    @Transactional
    @Query(
        value = "set autocomit = 0",
        nativeQuery=true
    )
    void setAutocommit_0();

    @Modifying
    @Transactional
    @Query(
        value = "commit",
        nativeQuery=true
    )
    Object[] commit();

    @Modifying
    @Transactional
    @Query(
        value = "rollback",
        nativeQuery=true
    )
    Object[] rollback();
}
