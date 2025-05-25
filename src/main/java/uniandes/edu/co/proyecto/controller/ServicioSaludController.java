package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import uniandes.edu.co.proyecto.repositorio.ServicioSaludRepository;
import uniandes.edu.co.proyecto.modelo.ServicioSalud;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;
import java.util.Optional;

@Controller
public class ServicioSaludController {
    
    @Autowired
    private ServicioSaludRepository servicioSaludRepo;

    @GetMapping
    public List<ServicioSalud> obtenerServicios() {
        return servicioSaludRepo.findAll();
    }

    @GetMapping("/{codigo}")
    public ServicioSalud obtenerServicioPorCodigo(@PathVariable String codigo) {
        return servicioSaludRepo.findByCodigo(codigo);
    }
    
    @PostMapping
    public ServicioSalud crearServicio(@RequestBody ServicioSalud nuevoServicio) {
        return servicioSaludRepo.save(nuevoServicio);
    }
 
    @PutMapping("/{codigo}")
    public ResponseEntity<ServicioSalud> actualizarServicio(@PathVariable String codigo,
                                                            @RequestBody ServicioSalud servicioActualizado) {
        
        ServicioSalud servicioViejo = servicioSaludRepo.findByCodigo(codigo);
        //si hay errores tipo crash del app cuando no se encuentra el servicio, implementar Optional<> en repositorio
        if (servicioViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            servicioViejo.setNombre(servicioActualizado.getNombre());
            servicioViejo.setTipo(servicioActualizado.getTipo());
            return ResponseEntity.ok(servicioSaludRepo.save(servicioViejo));
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable String codigo) {
        ServicioSalud servicio = servicioSaludRepo.findByCodigo(codigo);
        
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            servicioSaludRepo.delete(servicio);
            return ResponseEntity.noContent().build();
        }  
    }

}
