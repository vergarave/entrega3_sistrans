package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

//Controlador de la entidad Ciudad que se encarga de realizar las peticiones HTTP
@RestController
public class CiudadController {

    //Inyeccion de dependencias
    @Autowired //Inyecta el bean que se encarga de la logica de la aplicacion
    private CiudadRepository ciudadRepository; //Bean de la interfaz CiudadRepository

    //Metodo que se encarga de devolver todas las ciudades
    @GetMapping("/ciudades") //Indica que el metodo se activa cuando se hace una peticion GET a la URL /ciudades
    public Collection<Ciudad> ciudades(){
        return ciudadRepository.darCiudades();
    }

    //Metodo que se encarga de devolver una ciudad por su codigo
    @GetMapping("/ciudades/{codigo}") //Indica que el metodo se activa cuando se hace una peticion GET a la URL /ciudades/{codigo}
    public ResponseEntity<Ciudad> obtenerCiudad(@PathVariable int codigo){
        
        Ciudad ciudad = ciudadRepository.darCiudad(codigo);

        //Devolver si existe
        if (ciudad != null) {
            return new ResponseEntity<>(ciudad, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Metodo que se encarga de crear una ciudad
    @PostMapping("/ciudades/new/save") //Indica que el metodo se activa cuando se hace una peticion POST a la URL /ciudades/new/save
    public ResponseEntity<String> ciudadGuardar(@RequestBody Ciudad ciudad){
        
        try{
            //Insertar la ciudad en la base de datos
            ciudadRepository.insertarCiudad(ciudad.getNombre());
            return new ResponseEntity<>("Ciudad creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la ciudad", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    
    
    
}
