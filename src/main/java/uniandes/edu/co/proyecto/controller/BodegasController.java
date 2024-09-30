package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Bodega;
import uniandes.edu.co.proyecto.repositorio.BodegaRepository;

@RestController
public class BodegasController 
{
    @Autowired
    private BodegaRepository bodegaRepository;

    @PostMapping("/bodegas/new/save")
    public ResponseEntity<String> bodegaGuardar(@RequestBody Bodega bodega)
    {
        try
        {
            bodegaRepository.insertarBodega(bodega.getNombre(), bodega.getTamaño(),bodega.getSucursal_id().getId());
            return new ResponseEntity<>("Bodega creada exitosamente.", HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Error al crear la bodega.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/bodegas/{id}/delete")
    public ResponseEntity<String> bodegaEliminar(@PathVariable("id") Integer id)
    {
        try
        {
            bodegaRepository.eliminarBodega(id);
            return new ResponseEntity<>("Bodega eliminada exitosamente.",HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>("Error al eliminar la bodega.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
