package uniandes.edu.co.proyecto.repositorio;

import java.sql.Date;
import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Orden_compra;

public interface Orden_compraRepository extends JpaRepository<Orden_compra,Integer>{

    // RF7 : Crear una orden de compra
    @Modifying
    @Transactional
    @Query(value = "insert into ordenes_compra (id, fecha_creacion, fecha_esperada, estado, id_bodega, id_proveedor) values (ids_orden_compra.nextval, :fecha_creacion, :fecha_esperada, :estado, :id_bodega, :id_proveedor)", nativeQuery = true)
    void insertarOrden_compra(@Param("fecha_creacion") Date fecha_creacion, @Param("fecha_esperada") Date fecha_esperada, @Param("estado") String estado,@Param("id_bodega") Integer id_bodega, @Param("id_proveedor") Integer id_proveedor);

    // RF8 : Actualizar una orden de compra cambiando el estado a anulada
    @Modifying
    @Transactional
    @Query(value = "update ordenes_compra set estado = 'anulada' WHERE id = :id ", nativeQuery = true)
    void actualizarOrden_compra(@Param("id") Integer id);

    @Query(value = "SELECT * FROM ordenes_compra", nativeQuery=true)
    Collection<Orden_compra> darOrden_compras();

    @Query(value = "SELECT * FROM ordenes_compra where id = :id", nativeQuery=true)
    Collection<Orden_compra> darOrden_compra(@Param("id")Integer id);
}
