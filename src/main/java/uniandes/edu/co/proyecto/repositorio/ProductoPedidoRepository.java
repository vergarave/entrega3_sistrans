package uniandes.edu.co.proyecto.repositorio;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import uniandes.edu.co.proyecto.modelo.ProductoPedido;
import uniandes.edu.co.proyecto.modelo.ProductoPedidoPK;

public interface ProductoPedidoRepository extends JpaRepository<ProductoPedido, ProductoPedidoPK> {

    //NEW NEW NEW 
    //Aquí vemos la tabla PRODUCTO_PEDIDO para obtener los productos y cantidades asociados a una orden de compra específica
    //Esto básicamente devuelve todas las filas de PRODUCTO_PEDIDO que coinciden con el número de la orden de compra proporcionado
    @Query(value = "SELECT * FROM PRODUCTO_PEDIDO WHERE NUMERO_ORDEN_DE_COMPRA = :numeroOrdenCompra", nativeQuery = true)
    Collection<ProductoPedido> obtenerProductosySuCantidadPorOrdenDeCompra(@Param("numeroOrdenCompra") Integer numeroOrdenCompra);
}