package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;


@RestController
public class BodegaController {

    @Autowired
    private BodegaRepository bodegaRepository;

    @GetMapping("/bodegas")
    public Collection<Bodega> bodegas(){
        return bodegaRepository.darBodegas();
    }

    //Este no dicen como hacerlo xd
    @GetMapping("/bodegas/{id}")
    public ResponseEntity<Bodega> obtenerBodega(@PathVariable int id){

        Bodega bodega = bodegaRepository.darBodega(id);

        //Devolver si existe :)
        if (bodega != null) {
            return new ResponseEntity<>(bodega, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody Bodega bodega){
        
        try{
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamanio(), bodega.getPorcentajeOcupacion(), bodega.getCapacidad(), bodega.getIdSucursal().getId());
            return new ResponseEntity<>("Bodega creada exitosamente", HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>("Error al crear la bodega", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") int id) {

        bodegaRepository.eliminarBodega(id);
        return new ResponseEntity<>("Bodega eliminada exitosamente", HttpStatus.OK);
    }
    
}
