package uniandes.edu.co.proyecto.servicios;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
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

    @Transactional
    public Map<String, Object> registrarIngresoProductos(Integer idOrdenCompra, Integer idBodega) {
        // Captura la fecha del día de ingreso
        LocalDate fechaIngreso = LocalDate.now();

        // Obtener la orden de compra
        OrdenDeCompra ordenDeCompra = ordenDeCompraRepository.darOrdenDeCompra(idOrdenCompra);
        
        if (ordenDeCompra == null || !"VIGENTE".equals(ordenDeCompra.getEstado())) {
            throw new RuntimeException("La orden de compra no es válida para ingreso de productos.");
        }

        // La bodega debe existir; si no, lanzará una excepción NoSuchElementException
        Bodega bodega = bodegaRepository.findById(idBodega).get();


        // Validar que la bodega pertenezca a la misma sucursal de la orden de compra
        if (!bodega.getIdSucursal().equals(ordenDeCompra.getIdSucursal())) {
            throw new RuntimeException("La bodega seleccionada no pertenece a la sucursal de la orden de compra.");
        }

        // Obtener el proveedor asociado a la orden de compra
        Proveedor proveedor = ordenDeCompra.getNitProveedor();

        // Crear un mapa para almacenar toda la información del ingreso
        Map<String, Object> infoIngresoProductos = new HashMap<>();
        infoIngresoProductos.put("fechaIngreso", fechaIngreso);
        infoIngresoProductos.put("sucursal", ordenDeCompra.getIdSucursal());
        infoIngresoProductos.put("bodega", bodega);
        infoIngresoProductos.put("proveedorNit", proveedor.getNit());
        infoIngresoProductos.put("proveedorNombre", proveedor.getNombre());

        // Obtener los productos y cantidades de la orden de compra
        Collection<ProductoPedido> productosPedido = productoPedidoRepository.obtenerProductosYCantidadPorOrdenDeCompra(idOrdenCompra);

        // Procesar cada producto en la orden de compra
        for (ProductoPedido productoPedido : productosPedido) {
            Producto producto = productoPedido.getPk().getIdentificadorProducto();
            int cantidadIngresada = productoPedido.getCantidadEnOrden();

            // Buscar el producto en la bodega específica
            ProductoEnBodega productoEnBodega = productoEnBodegaRepository.findByProductoYBodega(producto.getIdentificador(), idBodega);

            if (productoEnBodega != null) {
                // Actualizar la cantidad y el costo promedio
                double nuevoCostoPromedio = calcularNuevoCostoPromedio(
                    productoEnBodega.getCostoPromedio(),
                    productoEnBodega.getCantidadEnBodega(),
                    producto.getCostoEnBodega(),
                    cantidadIngresada
                );
                productoEnBodega.setCantidadEnBodega(productoEnBodega.getCantidadEnBodega() + cantidadIngresada);
                productoEnBodega.setCostoPromedio(nuevoCostoPromedio);
            } else {
                // Crear un nuevo registro si el producto no está en la bodega
                productoEnBodega = new ProductoEnBodega(producto, bodega, 0, producto.getCostoEnBodega(), 0, cantidadIngresada);
            }

            // Guardar el producto en la bodega
            productoEnBodegaRepository.save(productoEnBodega);
        }

        // Cambiar el estado de la orden de compra a ENTREGADA
        ordenDeCompra.setEstado("ENTREGADA");
        ordenDeCompraRepository.save(ordenDeCompra);

        // Información detallada de los productos y cantidades para devolver en el resumen
        infoIngresoProductos.put("productos pedido", productosPedido);
        
        return infoIngresoProductos;
    }

    private Double calcularNuevoCostoPromedio(Double costoPromedioAnterior, Integer cantidadAnterior,
                                              Double precioUnitario, Integer cantidadIngresada) {
        return ((costoPromedioAnterior * cantidadAnterior) + (precioUnitario * cantidadIngresada))
                / (cantidadAnterior + cantidadIngresada);
    }

}