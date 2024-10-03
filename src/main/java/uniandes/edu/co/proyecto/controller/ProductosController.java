package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductosController {

    @Autowired
    private ProductoRepository productoRepository;

    /**
     * Extrae los productos de la tabla productos
     * @return collection de productos
     */
    @GetMapping("/productos")
    public Collection<Producto> darProductos() {
        return productoRepository.findAll();
    }

    /**
     * Extrae un producto dado su id o nombre
     * @param id identificador del producto que se quiere actulizar
     * @param nombre nombre del producto que se quiere actulizar
     * @return resultado de la transaccion
     */
    @GetMapping("/productos/consulta")
    public ResponseEntity<?> darProducto(@RequestParam (required = false)Integer id,
                                         @RequestParam (required = false)String nombre) {
        try {
            
            if(id == null && nombre == null) {
                throw new Exception("No se recibió ningun parametro");
            }else{
                Collection<Producto> tipos = productoRepository.darproductoPorIdONombre(id, 
                                                                                        nombre);
                if(tipos.isEmpty()){
                    throw new Exception("No se encontraron resultados");
                }
                Map<String,Object> response = new HashMap<>();
                response.put("tipos", tipos);
                return ResponseEntity.ok(response);
            }
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","get",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Anide un producto a la tabla productos dada su informacion
     * @param producto producto que se quiere crear
     * @return resultado de la transaccion
     */
    @PostMapping("/productos/new/save")
    public ResponseEntity<Map<String,Object>> productoGuardar(@RequestBody Producto producto) {
        try {
            productoRepository.insertarProducto(producto.getNombre(),
                                                producto.getFecha_expiracion(),
                                                producto.getCodigo_barras(),
                                                producto.getVolumen(),
                                                producto.getPeso(),
                                                producto.getId_tipo_categoria().getId());
            producto.setId(getLast().getId());
            Map<String,Object> response = MS.response("ok","create",producto);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Actuliza la informacion de un producto, este se úbica con su id y se actuliza con la informacion nueva
     * @param id identificador de el producto que se quiere actualizar
     * @param producto informacion actualizada del producto
     * @return resultado de la transaccion
     */
    @PostMapping("/productos/{id}/edit/save")
    public ResponseEntity<Map<String,Object>> productoEditarGuardar(@PathVariable("id") Integer id,
                                                                    @RequestBody Producto producto) {
        try {
            productoRepository.actualizarProducto(id,
                                                  producto.getNombre(),
                                                  producto.getFecha_expiracion(),
                                                  producto.getCodigo_barras(),
                                                  producto.getVolumen(),
                                                  producto.getPeso(),
                                                  producto.getId_tipo_categoria().getId());
            Map<String,Object> response = MS.response("ok","update",producto);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not_ok","update",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Devuelve la ultima instancia creada
     * @return ultima fila aniadida
     */
    public Producto getLast(){
        return productoRepository.getLast().iterator().next();
    }

}
