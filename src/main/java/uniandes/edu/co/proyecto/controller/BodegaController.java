package uniandes.edu.co.proyecto.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamanio(), bodega.getCapacidad(), bodega.getIdSucursal().getId());
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

    @GetMapping("/bodegas/ocupacion")
    public Collection<Map<String, Object>> obtenerOcupacionBodegas(
            @RequestParam Integer idSucursalU,
            @RequestParam Collection<Integer> listaProductosU) {
        Collection<Object[]> resultado = bodegaRepository.obtenerOcupacionBodegas(idSucursalU, listaProductosU);
        
        // Convertir los resultados en una colección de Map<String, Object> para mayor claridad en el retorno.
        Collection<Map<String, Object>> ocupacionBodegas = new ArrayList<>();
        for (Object[] fila : resultado) {
            Map<String, Object> bodega = new HashMap<>();
            bodega.put("id", fila[0]);
            bodega.put("nombre", fila[1]);
            bodega.put("porcentajeOcupacion", fila[2]);
            ocupacionBodegas.add(bodega);
        }
        return ocupacionBodegas;
    }
    
}
