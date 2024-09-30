package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Ciudad;
import uniandes.edu.co.proyecto.repositorio.CiudadRepository;

@RestController
public class CiudadesController 
{
    @Autowired
    private CiudadRepository ciudadReposiory;

    @PostMapping("/ciudades/new/save")
    public ResponseEntity<String> ciudadGuardar(@RequestBody Ciudad ciudad)
    {
        try
        {
            ciudadReposiory.insertarCiudad(ciudad.getNombre());
            return new ResponseEntity<>("Ciudad creada exitosamente.",HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Error al crear la ciudad.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
