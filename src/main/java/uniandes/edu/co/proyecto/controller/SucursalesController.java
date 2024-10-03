package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
