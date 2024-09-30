package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Sucursal;
import uniandes.edu.co.proyecto.repositorio.SucursalRepository;

//Controlador de la entidad Sucursal que se encarga de realizar las peticiones HTTP
@RestController
public class SucursalController {

    //Inyeccion de dependencias
    @Autowired //Inyecta el bean que se encarga de la logica de la aplicacion
    private SucursalRepository sucursalRepository; //Bean de la interfaz SucursalRepository

    //Metodo que se encarga de devolver todas las sucursales
    @GetMapping("/sucursales") //Indica que el metodo se activa cuando se hace una peticion GET a la URL /sucursales
    public Collection<Sucursal> sucursales(){
        return sucursalRepository.darSucursales();
    }

     //Metodo que se encarga de devolver una sucursal por su ID
    @GetMapping("/sucursales/{id}") //Indica que el metodo se activa cuando se hace una peticion GET a la URL /sucursales/{id}
    public ResponseEntity<Sucursal> obtenerSucursal(@PathVariable int id){
        
        Sucursal sucursal = sucursalRepository.darSucursal(id);

        //Devolver si existe
        if (sucursal != null) {
            return new ResponseEntity<>(sucursal, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //Metodo que se encarga de crear una sucursal
    @PostMapping("/sucursales/new/save") //Indica que el metodo se activa cuando se hace una peticion POST a la URL /sucursales/new/save
    public ResponseEntity<String> sucursalGuardar(@RequestBody Sucursal sucursal){
        
        try{
            sucursalRepository.insertarSucursal(sucursal.getNombre(), sucursal.getTamanio(), sucursal.getDireccion(), sucursal.getTelefono(), sucursal.getCodigoCiudad().getCodigo());
            return new ResponseEntity<>("Sucursal creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la sucursal", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    //Metodo que se encarga de devolver las sucursales que tienen un producto en especifico
    @GetMapping("/sucursales/productosDisponibles")
    public Collection<Sucursal> sucursalesConProducto(
            @RequestParam(required = false) Integer idProductoU,
            @RequestParam(required = false) String nombreProductoU) {
        
        // Verificar si se ingreso un idProducto y un nombreProducto
        if (idProductoU != null && nombreProductoU != null) {
            return sucursalRepository.darSucursalesConProducto(idProductoU, nombreProductoU);
        } else if (idProductoU != null) {  // Verificar si se ingreso solo un idProducto
            return sucursalRepository.darSucursalesConProductoIdentificador(idProductoU); 
        } else if (nombreProductoU != null) { // Verificar si se ingreso solo un nombreProducto
            return sucursalRepository.darSucursalesConProductoNombre(nombreProductoU); 
        } else { // Si no se ingreso ningun parametro
            return Collections.emptyList();
        }
    }


}
