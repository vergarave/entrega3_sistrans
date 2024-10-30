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
        Map<String, Object> response = new HashMap<>();

        // Captura la fecha del día de ingreso
        LocalDate fechaIngreso = LocalDate.now();

        // Obtener la orden de compra
        OrdenDeCompra ordenDeCompra = ordenDeCompraRepository.darOrdenDeCompra(idOrdenCompra);

        if (ordenDeCompra == null || !"VIGENTE".equals(ordenDeCompra.getEstado())) {
            response.put("message", "La orden de compra no es válida para ingreso de productos.");
            return response;
        }

        // La bodega debe existir
        Bodega bodega = bodegaRepository.findById(idBodega).orElse(null);
        if (bodega == null) {
            response.put("message", "La bodega seleccionada no existe.");
            return response;
        }

        // Validar que la bodega pertenezca a la misma sucursal de la orden de compra
        if (!bodega.getIdSucursal().equals(ordenDeCompra.getIdSucursal())) {
            response.put("message", "La bodega seleccionada no pertenece a la sucursal de la orden de compra.");
            return response;
        }

        // Obtener el proveedor asociado a la orden de compra
        Proveedor proveedor = ordenDeCompra.getNitProveedor();

        // Crear un mapa para almacenar toda la información del ingreso
        response.put("fechaIngreso", fechaIngreso);
        response.put("sucursal", ordenDeCompra.getIdSucursal());
        response.put("bodega", bodega);
        response.put("proveedorNit", proveedor.getNit());
        response.put("proveedorNombre", proveedor.getNombre());

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

        // Preparar el mensaje de éxito
        response.put("message", "Ingreso de productos registrado exitosamente.");
        response.put("fechaIngreso", fechaIngreso);
        return response;
    }

    private Double calcularNuevoCostoPromedio(Double costoPromedioAnterior, Integer cantidadAnterior,
                                              Double precioUnitario, Integer cantidadIngresada) {
        return ((costoPromedioAnterior * cantidadAnterior) + (precioUnitario * cantidadIngresada))
                / (cantidadAnterior + cantidadIngresada);
    }
}
