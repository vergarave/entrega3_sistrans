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
import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

@RestController
public class CiudadesController {

    @Autowired
    private CiudadRepository ciudadRepository;

    /**
     * Extrae las instancias de la tabla ciudades
     * @return collection de instacias de la clase Ciudad
     */
    @GetMapping("/ciudades")
    public Collection<Ciudad> darCiudades() {
        return ciudadRepository.findAll();
    }

    /**
     * Aniade una ciudad a la tabla ciudades dad su informacion
     * @param ciudad ciudad que se quiere crear
     * @return resultado de la transaccion
     */
    @PostMapping("/ciudades/new/save")
    public ResponseEntity<Map<String,Object>> ciudadGuardar(@RequestBody Ciudad ciudad) {
        ciudadRepository.insertarCiudad(ciudad.getNombre());
        Map<String,Object> response = MS.response("ok","create",ciudad);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
