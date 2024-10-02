package uniandes.edu.co.proyecto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;

public interface BodegaRepository extends JpaRepository<Bodega,Integer>{

    // RF3.1 : Crear una bodega
    @Modifying
    @Transactional
    @Query(value = "insert into bodegas (id,nombre,tamanio,id_sucursal) values (ids_bodega.nextval, :nombre, :tamanio, :id_sucursal)", nativeQuery = true)
    void insertarBodega(@Param("nombre") String nombre, @Param("tamanio") String tamanio, @Param("id_sucursal") Integer id_sucursal);

    // RF3.2 : Borrar una bodega
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM bodegas WHERE id = :id", nativeQuery = true)
    void eliminarBodega(@Param("id") Integer id);
}
