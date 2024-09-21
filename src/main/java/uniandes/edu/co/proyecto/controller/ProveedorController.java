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

import uniandes.edu.co.proyecto.modelo.Proveedor;
import uniandes.edu.co.proyecto.repositorio.ProveedorRepository;

@RestController
public class ProveedorController {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @GetMapping("/proveedores")
    public Collection<Proveedor> proveedores(){
        return proveedorRepository.darProveedores();
    }

    //Este no dicen como hacerlo xd
    @GetMapping("/proveedores/{NIT}")
    public ResponseEntity<Proveedor> obtenerProveedor(@PathVariable String nit){
        
        Proveedor proveedor = proveedorRepository.darProveedor(nit);

        //Devolver si existe :)
        if (proveedor != null) {
            return new ResponseEntity<>(proveedor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping("/proveedores/new/save")
    public ResponseEntity<String> proveedorGuardar(@RequestBody Proveedor proveedor){
        
        try{
            proveedorRepository.insertarProveedor(proveedor.getNit(), proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombrePersonaContacto(), proveedor.getTelefonoPersonaContacto());
            return new ResponseEntity<>("Proveedor creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/proveedores/{nit}/edit/save")
    public ResponseEntity<String> proveedorEditarGuardar(@PathVariable("nit") String nit, @RequestBody Proveedor proveedor){
        try {
        proveedorRepository.actualizarProveedor(nit, proveedor.getNombre(), proveedor.getDireccion(), proveedor.getNombrePersonaContacto(), proveedor.getTelefonoPersonaContacto());
        return new ResponseEntity<>("Proveedor actualizado exitosamente", HttpStatus.OK);
       }
       catch (Exception e){
        return new ResponseEntity<>("Error al actualizar el proveedor", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }
    
}
