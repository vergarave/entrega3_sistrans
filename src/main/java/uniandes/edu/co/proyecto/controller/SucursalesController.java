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

    @GetMapping("/sucursales")
    public Collection<Sucursal> darSucursales() {
        return sucursalRepository.findAll();
    }

    @PostMapping("/sucursales/new/save")
    public ResponseEntity<Map<String,Object>> sucursalGuardar(@RequestBody Sucursal sucursal) {
        try {
            sucursalRepository.insertarSucursal(sucursal.getNombre(),
                                                sucursal.getTamanio(),
                                                sucursal.getDireccion(),
                                                sucursal.getDireccion(),
                                                sucursal.getId_ciudad().getId());
            Map<String,Object> response = MS.response("ok","create",sucursal);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        
    }
    
}
