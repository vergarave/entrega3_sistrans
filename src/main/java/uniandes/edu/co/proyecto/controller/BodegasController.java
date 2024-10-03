package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@RestController
public class BodegasController {

    @Autowired
    private BodegaRepository bodegaRepository;

    /**
     * Extrae las bodegas de la tabla bodegas
     * @return collection de bodegas encontradas
     */
    @GetMapping("/bodegas")
    public Collection<Bodega> darBodegas() {
        return bodegaRepository.findAll();
    }

    /**
     * Aniade una bodega ala tabla bodegas dada su informacion
     * @param bodega bodega que se quiere crear
     * @return resultado de la transaccion
     */
    @PostMapping("/bodegas/new/save")
    public ResponseEntity<Map<String,Object>> bodegaGuardar(@RequestBody Bodega bodega) {
        try {
            bodegaRepository.insertarBodega(bodega.getNombre(),
                                            bodega.getTamanio(),
                                            bodega.getId_Sucursal().getId());
            bodega.setId(getLast().getId());
            Map<String,Object> response = MS.response("ok","create",bodega);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Elimina una bodega dado su id
     * @param id identificador unico de una bodega proxima a ser eliminada
     * @return resultado de la transaccion
     */
    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<Map<String,Object>> bodegaEliminar(@PathVariable("id") Integer id) {
        try {
            bodegaRepository.eliminarBodega(id);
            Map<String,Object> response = MS.response("ok","delete","Bodega eliminada correctamente");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not ok","delete","Bodega no eliminada correctamente");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Devuelve la ultima instancia creada
     * @return ultima fila aniadida
     */
    public Bodega getLast(){
        return bodegaRepository.getLast().iterator().next();
    }

}
