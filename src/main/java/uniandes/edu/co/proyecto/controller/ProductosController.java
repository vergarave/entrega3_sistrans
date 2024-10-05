package uniandes.edu.co.proyecto.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
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

    //javadoc ---
    @GetMapping("/productos/consulta")
    public ResponseEntity<?> darProducto(@RequestParam (required = false)Integer id,
                                         @RequestParam (required = false)String nombre,
                                         @RequestParam (required = false) List<Integer> ids,
                                         @RequestParam (required = false) Float minPrice,
                                         @RequestParam (required = false) Float maxPrice,
                                         @RequestParam (required = false) String fechaPosteriorA,
                                         @RequestParam (required = false) String fechaInferiorA,
                                         @RequestParam (required = false) Integer id_sucursal,
                                         @RequestParam (required = false) Integer id_tipo_categoria){

        try {
            if(id != null || nombre != null){
                /*
                 * Caso en el que se quiere consultar un producto por id o nombre
                 */
                if (ids != null)throw new Exception("demasidas entradas");
                if (minPrice != null && maxPrice != null)throw new Exception("demasidas entradas");
                if (fechaInferiorA != null || fechaPosteriorA != null) throw new Exception("demasiadas entradas");
                if (id_sucursal != null) throw new Exception("demasiadas entradas");
                if (id_tipo_categoria != null) throw new Exception("demasiadas entradas");

                Collection<Producto> tipos = productoRepository.darproductoPorIdONombre(id, nombre);
                if(tipos.isEmpty())throw new Exception("No se encontraron resultados");
                Map<String,Object> response = new HashMap<>();
                response.put("tipos", tipos);
                return ResponseEntity.ok(response);

            }else if (ids != null){
                /*
                 * Caso en el que se quiere obtener el indice de ocupacion de una bodega dada una lista de ids de productos
                 */
                if (minPrice != null && maxPrice != null)throw new Exception("demasidas entradas");
                if (fechaInferiorA != null || fechaPosteriorA != null) throw new Exception("demasiadas entradas");
                if (id_sucursal != null) throw new Exception("demasiadas entradas");
                if (id_tipo_categoria != null) throw new Exception("demasiadas entradas");

                if (ids.isEmpty()) throw new Exception("Se dió una lista vacia :(");
                Collection<Object[]> resultado = productoRepository.darPorcentajeOcupacion(ids);
                if (fechaInferiorA != null || fechaPosteriorA != null) throw new Exception("demasiadas entradas");
                if(resultado == null || resultado.isEmpty()) throw new Exception("No se encontraron resultados");
                return ResponseEntity.ok(resultado);

            }else if(minPrice != null && maxPrice != null){
                /*
                 * Caso en el que se quiere consultar los productos por un rango de precios
                 */
                if (fechaInferiorA != null || fechaPosteriorA != null) throw new Exception("deasiadas entradas");
                if (id_sucursal != null) throw new Exception("demasiadas entradas");
                if (id_tipo_categoria != null) throw new Exception("demasiadas entradas");

                Collection<Object[]> resultado = productoRepository.darProductosEnRangoDePrecios(minPrice,maxPrice);
                if(resultado == null || resultado.isEmpty()) throw new Exception("No se encontraron resultados");
                return ResponseEntity.ok(resultado);

            }else if(fechaInferiorA != null || fechaPosteriorA != null){
                /*
                 * Caso en el que se quiere consultar productos con fecha de venciminto posterior o inferior a una fecha dada
                 */
                if (id_sucursal != null) throw new Exception("demasiadas entradas");
                if (id_tipo_categoria != null) throw new Exception("demasiadas entradas");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                LocalDate maximaLocalDate = LocalDate.parse("4000-01-01", formatter);
                Date maximaSqlDate = Date.valueOf(maximaLocalDate);
                LocalDate minimaLocalDate = LocalDate.parse("0001-01-01", formatter);
                Date minimaSqlDate = Date.valueOf(minimaLocalDate);
                if ( fechaPosteriorA == null){
                    /*
                     * Cuando se da solo la fecha maxima
                     */
                    LocalDate inferiorLocaldate = LocalDate.parse(fechaInferiorA, formatter);
                    Date inferiorSqlDate = Date.valueOf(inferiorLocaldate);
                    Collection<Producto> respuesta = productoRepository.darProductosEnRangoDeFechaDeVencimiento(minimaSqlDate,inferiorSqlDate);
                    if (respuesta.isEmpty()) throw new Exception("No se encontraron resultados");
                    return ResponseEntity.ok(respuesta);

                }else if (fechaInferiorA == null) {
                    /*
                     * Cuando se da solo la fecha minima
                     */
                    LocalDate posteriorLocalDate = LocalDate.parse(fechaPosteriorA, formatter);
                    Date posteriorSqlDate = Date.valueOf(posteriorLocalDate);
                    Collection<Producto> respuesta = productoRepository.darProductosEnRangoDeFechaDeVencimiento(posteriorSqlDate,maximaSqlDate);
                    if (respuesta.isEmpty()) throw new Exception("No se encontraron resultados");
                    return ResponseEntity.ok(respuesta);

                }else{
                    /*
                     * Cuando se dan ambas fechas
                     */

                    LocalDate inferiorLocaldate = LocalDate.parse(fechaInferiorA, formatter);
                    Date inferiorSqlDate = Date.valueOf(inferiorLocaldate);
                    LocalDate posteriorLocalDate = LocalDate.parse(fechaPosteriorA, formatter);
                    Date posteriorSqlDate = Date.valueOf(posteriorLocalDate);
                    Collection<Producto> respuesta = productoRepository.darProductosEnRangoDeFechaDeVencimiento(posteriorSqlDate,inferiorSqlDate);
                    if (respuesta.isEmpty()) throw new Exception("No se encontraron resultados");
                    return ResponseEntity.ok(respuesta);

                }
            }else if(id_sucursal != null){
                /*
                 * Caso en el que se quieren consultar los productos disponibles en una sucursal dado su id
                 */
                if (id_tipo_categoria != null) throw new Exception("demasiadas entradas");

                Collection<Object[]> respuesta = productoRepository.darProductosPertenecientesASucursal(id_sucursal);
                if (respuesta.isEmpty()) throw new Exception("No se encontraron resultados");
                return ResponseEntity.ok(respuesta);

            }else if(id_tipo_categoria != null){
                /*
                 * Caso en el que se quiere consultar los productos pertenecientes a una categoria dado su id
                 */

                Collection<Producto> respuesta = productoRepository.darProductosPertenecientesATipoCategoria(id_tipo_categoria);
                if (respuesta.isEmpty()) throw new Exception("No se encontraron resultados");
                return ResponseEntity.ok(respuesta);

            }
            else{
                /*
                 * Caso en el que no se recibio ningun parametro para consultar
                 */

                throw new Exception("No se recibió ningun parametro");
            }
            
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","get",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
            
        }

/*
        try {
            List<Integer> lista_ids;
            try {
                lista_ids = mapa_json.get("ids_productos");
            } catch (Exception e) {
                lista_ids = null;
            }
            if(id == null && nombre == null && (lista_ids == null || lista_ids.isEmpty())) {
                throw new Exception("No se recibió ningun parametro");
            }else{
                if(id == null && nombre == null){
                    Collection<Object[]> resultado = productoRepository.darPorcentajeOcupacion(lista_ids);
                    if(resultado == null || resultado.isEmpty()) throw new Exception("No se encontraron resultados");
                    return ResponseEntity.ok(resultado);
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
            }
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","get",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
*/
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
    /**
     * Devuelve la ultima instancia creada
     * @return ultima fila aniadida
     */
    public Producto getLast(){
        return productoRepository.getLast().iterator().next();
    }
    
}
