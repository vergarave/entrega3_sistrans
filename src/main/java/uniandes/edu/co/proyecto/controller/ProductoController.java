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

import uniandes.edu.co.proyecto.modelo.Producto;
import uniandes.edu.co.proyecto.repositorio.ProductoRepository;

@RestController
public class ProductoController {

    @Autowired
    private ProductoRepository productoRepository;

    
    @GetMapping("/productos")
    public Collection<Producto> producto(){
        return productoRepository.darProductos();
    }

     //Este no dicen como hacerlo xd
    @GetMapping("/productos/{identificador}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable int identificador){
        Producto producto = productoRepository.darProducto(identificador);

        //Devolver si existe :)
        if (producto != null) {
            return new ResponseEntity<>(producto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/productos/new/save")
    public ResponseEntity<String> productoGuardar(@RequestBody Producto producto){
        
        try{
            productoRepository.insertarProducto(producto.getNombre(), producto.getCostoEnBodega(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getVolumenEmpaque(), producto.getPesoEmpaque(), producto.getFechaExpiracion(), producto.getCodigoDeBarras(), producto.getClasificacionCategoria());
            return new ResponseEntity<>("Producto creado exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear el producto", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/productos/{identificador}/edit/save")
    public ResponseEntity<String> productoEditarGuardar(@PathVariable("identificador") Integer identificador, @RequestBody Producto producto){
        try {
            productoRepository.actualizarProducto(producto.getIdentificador(), producto.getNombre(), producto.getCostoEnBodega(), producto.getPresentacion(), producto.getCantidadPresentacion(), producto.getUnidadMedida(), producto.getVolumenEmpaque(), producto.getPesoEmpaque(), producto.getFechaExpiracion(), producto.getCodigoDeBarras(), producto.getClasificacionCategoria().getCodigo());
            return new ResponseEntity<>("Producto actualizado exitosamente", HttpStatus.OK);
       }
       catch (Exception e){
        return new ResponseEntity<>("Error al actualizar el producto", HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

}
