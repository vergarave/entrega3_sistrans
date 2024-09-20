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

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;


@RestController
public class SucursalController {

@Autowired
    private SucursalRepository sucursalRepository;

    @GetMapping("/sucursales")
    public Collection<Sucursal> sucursales(){
        return sucursalRepository.darSucursales();
    }

     //Este no dicen como hacerlo xd
    @GetMapping("/sucursales/{id}")
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable Long id){

        // Tocó pasar de long a int
        int idInt = Math.toIntExact(id);
        
        Sucursal sucursal = sucursalRepository.darSucursal(idInt);

        //Devolver si existe :)
        if (sucursal != null) {
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/sucursales/new/save")
    public ResponseEntity<String> sucursalGuardar(@RequestBody Sucursal sucursal){
        
        try{
            sucursalRepository.insertarSucursal(sucursal.getNombre(), sucursal.getTamanio(), sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getCodigoCiudad().getCodigo());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
