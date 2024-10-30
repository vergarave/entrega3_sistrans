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

        // Captura la fecha del día de ingreso
        LocalDate fechaIngreso = LocalDate.now();

        try {
            // Simulación de una operación de larga duración (30 segundos)
            Thread.sleep(30000);

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

            // Lista para almacenar la información detallada de cada producto
            List<Map<String, Object>> productos = new ArrayList<>();

            // Procesar cada producto en la orden de compra
            for (ProductoPedido productoPedido : productosPedido) {
                Producto producto = productoPedido.getPk().getIdentificadorProducto();
                int cantidadIngresada = productoPedido.getCantidadEnOrden();
                double precioUnitario = producto.getCostoEnBodega();

                // Buscar el producto en la bodega específica
                ProductoEnBodega productoEnBodega = productoEnBodegaRepository.findByProductoYBodega(producto.getIdentificador(), idBodega);

                double nuevoCostoPromedio;
                int nuevaCantidadEnBodega;
                if (productoEnBodega != null) {
                    // Calcular el nuevo costo promedio
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
                    // Crear un nuevo registro si el producto no está en la bodega
                    nuevoCostoPromedio = precioUnitario;
                    nuevaCantidadEnBodega = cantidadIngresada;
                    productoEnBodega = new ProductoEnBodega(producto, bodega, 1, nuevoCostoPromedio, 1, nuevaCantidadEnBodega);
                }

                // Guardar el producto en la bodega
                productoEnBodegaRepository.save(productoEnBodega);

                // Agregar la información del producto al JSON de respuesta
                Map<String, Object> productoData = new HashMap<>();
                productoData.put("identificador", producto.getIdentificador());
                productoData.put("nombre", producto.getNombre());
                productoData.put("precioUnitario", precioUnitario);
                productoData.put("cantidadIngresada", cantidadIngresada);
                productoData.put("nuevaCantidadEnBodega", nuevaCantidadEnBodega);
                productoData.put("costoPromedio", nuevoCostoPromedio);

                productos.add(productoData);
            }

            // Añadir la lista de productos al JSON de respuesta
            response.put("productos", productos);

            // Cambiar el estado de la orden de compra a ENTREGADA
            ordenDeCompra.setEstado("ENTREGADA");
            ordenDeCompraRepository.save(ordenDeCompra);

            // Preparar el mensaje de éxito
            response.put("message", "Ingreso de productos registrado exitosamente.");

        } catch (Exception e) {
            // Si ocurre cualquier excepción, Spring realiza rollback automáticamente
            response.put("message", "Error durante el ingreso de productos: " + e.getMessage());
            throw new RuntimeException("Se produjo un error y se ha realizado un rollback.", e);
        }

        return response;
    }

    private Double calcularNuevoCostoPromedio(Double costoPromedioAnterior, Integer cantidadAnterior,
                                              Double precioUnitario, Integer cantidadIngresada) {
        return ((costoPromedioAnterior * cantidadAnterior) + (precioUnitario * cantidadIngresada))
                / (cantidadAnterior + cantidadIngresada);
    }
}
