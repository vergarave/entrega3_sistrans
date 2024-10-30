package uniandes.edu.co.proyecto.servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.modelo.ProductoEnBodega;
import uniandes.edu.co.proyecto.modelo.ProductoPedido;
import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoEnBodegaRepository;
import uniandes.edu.co.proyecto.repositorio.ProductoPedidoRepository;

//NEW NEW NEW 
@Service
public class IngresoProductoService {

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;

    @Autowired
    private BodegaRepository bodegaRepository;

    @Autowired
    private ProductoEnBodegaRepository productoEnBodegaRepository;

    @Autowired
    private ProductoPedidoRepository productoPedidoRepository;

    @Transactional(rollbackFor = Exception.class)
    public Map<String, Object> registrarIngresoProductos(Integer idOrdenCompra, Integer idBodega) {
        Map<String, Object> response = new HashMap<>();

        //Capturando la fecha de ingreso de los productos, porque esto debe ser legal xd
        LocalDate fechaIngreso = LocalDate.now();

        try {
            //Vamos a buscar la orden de compra con el ID que nos pasaron
            OrdenDeCompra ordenDeCompra = ordenDeCompraRepository.darOrdenDeCompra(idOrdenCompra);
            if (ordenDeCompra == null || !"VIGENTE".equals(ordenDeCompra.getEstado())) {
                response.put("message", "La orden de compra no es valida para ingreso de productos.");
                return response;
            }

            //A ver, ¿la bodega existe o estamos inventando?
            Bodega bodega = bodegaRepository.findById(idBodega).orElse(null);
            if (bodega == null) {
                response.put("message", "La bodega seleccionada no existe.");
                return response;
            }

            //Vemos que la bodega esté en la misma sucursal que la orden de compra, porque no queremos sorpresas
            if (!bodega.getIdSucursal().equals(ordenDeCompra.getIdSucursal())) {
                response.put("message", "La bodega seleccionada no pertenece a la sucursal de la orden de compra.");
                return response;
            }

            //Ahora buscamos la info del proveedor que envió la orden de compra
            Proveedor proveedor = ordenDeCompra.getNitProveedor();

            //Guardamos los datos de la transacción en la respuesta (los que nos piden)
            response.put("fechaIngreso", fechaIngreso);
            response.put("sucursal", ordenDeCompra.getIdSucursal());
            response.put("bodega", bodega);
            response.put("proveedorNit", proveedor.getNit());
            response.put("proveedorNombre", proveedor.getNombre());

            //Conseguimos la lista de productos y las cantidades de la orden
            Collection<ProductoPedido> productosPedido = productoPedidoRepository.obtenerProductosYCantidadPorOrdenDeCompra(idOrdenCompra);

            //Esta lista guardará toda la info detallada de cada producto que se ingresará
            List<Map<String, Object>> productos = new ArrayList<>();

            //Ahora, iteramos por cada producto en la orden (literal nuestro ciclo for que resuelve)
            for (ProductoPedido productoPedido : productosPedido) {
                Producto producto = productoPedido.getPk().getIdentificadorProducto();
                int cantidadIngresada = productoPedido.getCantidadEnOrden();
                double precioUnitario = producto.getCostoEnBodega();

                //Revisamos si el producto ya está en la bodega
                ProductoEnBodega productoEnBodega = productoEnBodegaRepository.findByProductoYBodega(producto.getIdentificador(), idBodega);

                double nuevoCostoPromedio;
                int nuevaCantidadEnBodega;
                if (productoEnBodega != null) {
                    //VAMOOOS, el producto ya existe, vamos a recalcular el costo promedio
                    nuevoCostoPromedio = calcularNuevoCostoPromedio(
                        productoEnBodega.getCostoPromedio(),
                        productoEnBodega.getCantidadEnBodega(),
                        precioUnitario,
                        cantidadIngresada
                    );
                    nuevaCantidadEnBodega = productoEnBodega.getCantidadEnBodega() + cantidadIngresada;
                    productoEnBodega.setCantidadEnBodega(nuevaCantidadEnBodega);
                    productoEnBodega.setCostoPromedio(nuevoCostoPromedio);
                } else {
                    //Si el producto no estaba en la bodega, lo agregamos como nuevo
                    nuevoCostoPromedio = precioUnitario;
                    nuevaCantidadEnBodega = cantidadIngresada;
                    productoEnBodega = new ProductoEnBodega(producto, bodega, 1, nuevoCostoPromedio, 1, nuevaCantidadEnBodega);
                }

                //Guardamos el producto en la bodega
                productoEnBodegaRepository.save(productoEnBodega);

                //Preparamos la info del producto para mostrar en la respuesta
                Map<String, Object> productoData = new HashMap<>();
                productoData.put("identificador", producto.getIdentificador());
                productoData.put("nombre", producto.getNombre());
                productoData.put("precioUnitario", precioUnitario);
                productoData.put("cantidadIngresada", cantidadIngresada);
                productoData.put("nuevaCantidadEnBodega", nuevaCantidadEnBodega);
                productoData.put("costoPromedio", nuevoCostoPromedio);

                productos.add(productoData);
            }

            //Añadimos la lista de productos a la respuesta final (para que todo esté bonito y ordenado)
            response.put("productos", productos);

            //Cambiamos el estado de la orden a "ENTREGADA" 
            ordenDeCompra.setEstado("ENTREGADA");
            ordenDeCompraRepository.save(ordenDeCompra);

            //Se logróooo
            response.put("message", "Ingreso de productos exitoso.");

        } catch (Exception e) {
            //Algo salió mal, AHÍ se hace rollback automáticamente
            response.put("message", "Error durante el ingreso de productos: " + e.getMessage());
            throw new RuntimeException("Se produjo un error, por lo que se hizo un rollback.", e);
        }

        return response;
    }

    // Método para calcular el nuevo costo promedio (sí, hay que hacer matemáticas aquí también)
    private Double calcularNuevoCostoPromedio(Double costoPromedioAnterior, Integer cantidadAnterior,
                                              Double precioUnitario, Integer cantidadIngresada) {
        return ((costoPromedioAnterior * cantidadAnterior) + (precioUnitario * cantidadIngresada))
                / (cantidadAnterior + cantidadIngresada);
    }
}
