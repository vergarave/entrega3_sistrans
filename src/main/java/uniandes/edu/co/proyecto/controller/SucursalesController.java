package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;


@RestController
public class SucursalesController {

    @Autowired
    private SucursalRepository sucursalRepository;

    /**
     * Extrae las sucursales de la tabla sucursales
     * @return collection de las sucursales encontradas
     */
    @GetMapping("/sucursales")
    public Collection<Sucursal> darSucursales() {
        return sucursalRepository.findAll();
    }

    /**
     * Consulta las sucursaless que cumplen cierta combinacion de parametros
     * @param id_producto identificador del producto
     * @param nombre_producto nombre del producto
     * @return collection con el resultdo de la transaccion
     */
    @GetMapping("/sucursales/consulta")
    public ResponseEntity<?> darSucursales(@RequestParam(required = false) Integer id_producto,
                                           @RequestParam(required = false) String nombre_producto) {
        try {
            if (id_producto != null || nombre_producto != null){
                /*
                 * Caso en el que se quieren consultar las sucursales en la que esta un producto dado su id o nombre
                 */

                Collection<Object[]> resultado = sucursalRepository.darSucursalesConProducto(id_producto, nombre_producto);
                if (resultado.isEmpty()) throw new Exception("No se encontraron resultados");
                return ResponseEntity.ok(resultado);
                
            }else{
                throw new Exception("No se recibieron parametros");
            }
            
        } catch (Exception e) {
            return new ResponseEntity<>(MS.response("not ok", "get", e.getMessage()),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Aniade una sucursal a la tabla sucursales dada su informacion
     * @param sucursal sucursal que se quiere crear
     * @return resultado de la transaccion
     */
    @PostMapping("/sucursales/new/save")
    public ResponseEntity<Map<String,Object>> sucursalGuardar(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(sucursal.getNombre(),
                                                sucursal.getTamanio(),
                                                sucursal.getDireccion(),
                                                sucursal.getDireccion(),
                                                sucursal.getId_ciudad().getId());
            sucursal.setId(getLast().getId());
            Map<String,Object> response = MS.response("ok","create",sucursal);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    /**
     * Devuelve la ultima instancia creada
     * @return ultima fila aniadida
     */
    public Sucursal getLast(){
        return sucursalRepository.getLast().iterator().next();
    }

}
