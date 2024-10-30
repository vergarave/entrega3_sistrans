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
   // Consulta para obtener los productos asociados a una orden de compra específica
   @Query(value = "SELECT * \r\n" +
   "FROM PRODUCTO \r\n" + 
   "INNER JOIN PRODUCTO_PEDIDO ON PRODUCTO.IDENTIFICADOR = PRODUCTO_PEDIDO.IDENTIFICADOR_PRODUCTO \r\n" +
   "WHERE PRODUCTO_PEDIDO.NUMERO_ORDEN_DE_COMPRA = :numeroOrdenCompra", nativeQuery = true)
    Collection<Producto> obtenerProductosPorOrdenDeCompra(@Param("numeroOrdenCompra") Integer numeroOrdenCompra);


   // Consulta para obtener los productos y sus cantidades asociados a una orden de compra en SQL nativo
   @Query(value = "SELECT * FROM PRODUCTO_PEDIDO WHERE NUMERO_ORDEN_DE_COMPRA = :numeroOrdenCompra", nativeQuery = true)
   Collection<ProductoPedido> obtenerProductosYCantidadPorOrdenDeCompra(@Param("numeroOrdenCompra") Integer numeroOrdenCompra);
}
