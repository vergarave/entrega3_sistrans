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

    /**
     * RF7 : Crear una orden de compra
     * SQL : Inserta un nuevo registro en la tabla 'ordenes_compra'
     *          con un ID generado automáticamente y valores específicos
     *          para fechas, estado, bodega y proveedor.
     * @param fecha_creacion fecha en la que se crea la orden, la asigna el sistema y se usa el formato YYYY-MM-DD
     * @param fecha_esperada fecha en la que se espera que llegue el pedido, la asigna el usuario y usa el fromato YYYY-M-DD
     * @param estado estado en el que se encuentra la orden, puede ser vigente, estregada o anualada
     * @param id_bodega identificador de la bodega que solicita la orden de compra
     * @param id_proveedor identificador del proveedor al que se le compran los productos
     */
    @Modifying
    @Transactional
    @Query(value = "insert into ordenes_compra (id, fecha_creacion, fecha_esperada, estado, id_bodega, id_proveedor) values (ids_orden_compra.nextval, :fecha_creacion, :fecha_esperada, :estado, :id_bodega, :id_proveedor)", nativeQuery = true)
    void insertarOrden_compra(@Param("fecha_creacion") Date fecha_creacion, @Param("fecha_esperada") Date fecha_esperada, @Param("estado") String estado,@Param("id_bodega") Integer id_bodega, @Param("id_proveedor") Integer id_proveedor);

    /**
     * RF8 : Actualizar una orden de compra cambiando el estado a anulada
     * SQL : Actualiza el estado de la orden de compra a 'anulada' para
     *          el registro con el ID especificado.

     * @param id identificador de la orden de compra que va a cambiar su estadp
     */
    @Modifying
    @Transactional
    @Query(value = "update ordenes_compra set estado = 'anulada' WHERE id = :id ", nativeQuery = true)
    void anularOrden_compra(@Param("id") Integer id);

    /**
     * SQL : Recupera todos los registros de la tabla 'ordenes_compra'.

     * @return collection de las ordenes de compra encontradas
     */
    @Query(value = "SELECT * FROM ordenes_compra", nativeQuery=true)
    Collection<Orden_compra> darOrden_compras();

    /**
     * SQL : Recupera el registro de la tabla 'ordenes_compra' cuyo ID coincide con el valor especificado.
     * @param id identificador de la orden de compra que se quiere encontrar
     * @return collection con la orden de compra encontrada
     */
    @Query(value = "SELECT * FROM ordenes_compra where id = :id", nativeQuery=true)
    Collection<Orden_compra> darOrden_compra(@Param("id")Integer id);

    /**
     * Obtener la ultima orden de compra creada
     * @return collection con un unico elemento que sera el ultimo id creado
     */
    @Query(value = "SELECT * FROM ordenes_compra WHERE id = (SELECT MAX(id) FROM ordenes_compra)", nativeQuery = true)
    Collection<Orden_compra> getLast();


}
