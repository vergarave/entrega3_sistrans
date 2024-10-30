package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoPedido;
import uniandes.edu.co.proyecto.modelo.ProductoPedidoPK;

public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, ProductoPedidoPK> {

    //NEW NEW NEW 
    //Esta consulta es para obtener todos los productos relacionados con una orden de compra específica
    //Básicamente hace un join entre las tablas PRODUCTO y PRODUCTO_PEDIDO 
    //Luego filtra los resultados para que solo incluya productos de la orden de compra que se nos dio
    @Query(value = "SELECT * " +
                   "FROM PRODUCTO " +
                   "INNER JOIN PRODUCTO_PEDIDO ON PRODUCTO.IDENTIFICADOR = PRODUCTO_PEDIDO.IDENTIFICADOR_PRODUCTO " +
                   "WHERE PRODUCTO_PEDIDO.NUMERO_ORDEN_DE_COMPRA = :numeroOrdenCompra", 
           nativeQuery = true)
    Collection<Producto> obtenerProductosPorOrdenDeCompra(@Param("numeroOrdenCompra") Integer numeroOrdenCompra);

    //NEW NEW NEW 
    //Aquí vemos la tabla PRODUCTO_PEDIDO para obtener los productos y cantidades asociados a una orden de compra específica
    //Esto básicamente devuelve todas las filas de PRODUCTO_PEDIDO que coinciden con el número de la orden de compra proporcionado
    @Query(value = "SELECT * FROM PRODUCTO_PEDIDO WHERE NUMERO_ORDEN_DE_COMPRA = :numeroOrdenCompra", nativeQuery = true)
    Collection<ProductoPedido> obtenerProductosYCantidadPorOrdenDeCompra(@Param("numeroOrdenCompra") Integer numeroOrdenCompra);
}