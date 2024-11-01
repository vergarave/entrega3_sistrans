package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Contiene;

public interface ContieneRepository extends JpaRepository<Contiene,Integer>{

    /**
     * RF10 : Agrega productos a una bodega dado su orden de compra
     
    @Modifying
    @Transactional
    @Query(
        value="",
        nativeQuery=true
    )
    void addProductoOrdenCompraABodega(  @Param("id_bodega")Integer id_bodega,
                                                @Param("id_producto")Integer id_producto,
                                                @Param("id_orden_compra") Integer id_orden_compra);

    */
    @Modifying
    @Transactional
    @Query(
        value="select * from contiene where id_bodega = :id_bodega AND id_producto = :id_producto",
        nativeQuery=true
    )
    Collection<Contiene> getPorPK(  @Param("id_bodega")Integer id_bodega, 
                                    @Param("id_producto")Integer id_producto);

    @Modifying
    @Transactional
    @Query(
    value = "insert into contiene (id_bodega, id_producto, cantidad, capacidad, costo_promedio, cantidad_minima)" +
                "    values (:id_bodega, " + //
                "            :id_producto, " + //
                "            (select cantidad from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)," + //
                "            3*(select cantidad from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)," + //
                "            (select precio_unitario from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)," + //
                "            1)",
    nativeQuery=true
    )
    void createFila(@Param("id_bodega")Integer id_bodega,
                    @Param("id_producto")Integer id_producto,
                    @Param("id_orden_compra")Integer id_orden_compra);

    @Modifying
    @Transactional
    @Query(
        value="update contiene " + //
                        "set costo_promedio = ((costo_promedio*cantidad) +" + //
                        "                        ((select precio_unitario from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)*" + //
                        "                            (select cantidad from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)))" + //
                        "                            /(cantidad + (select cantidad from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto))," + //
                        "                    cantidad = cantidad + " + //
                        "                        (select cantidad from compra where id_orden_compra = :id_orden_compra AND id_producto = :id_producto)" + //
                        "where id_bodega = :id_bodega AND id_producto = :id_producto",
        nativeQuery=true
    )
    void actualizarFila(Integer id_bodega, Integer id_producto, Integer id_orden_compra);
    
}
