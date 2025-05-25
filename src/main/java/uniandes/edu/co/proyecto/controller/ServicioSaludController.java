package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

import uniandes.edu.co.proyecto.repositorio.ServicioSaludRepository;
import uniandes.edu.co.proyecto.modelo.ServicioSalud;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.ResponseEntity;

@Controller
@RequestMapping("/api/servicios")
public class ServicioSaludController {
    
    @Autowired
    private ServicioSaludRepository servicioSaludRepo;

    @GetMapping
    public List<ServicioSalud> obtenerServicios() {
        return servicioSaludRepo.findAll();
    }

    @GetMapping("/{codigo}")
    public ServicioSalud obtenerServicioPorCodigo(@PathVariable String codigo) {
        return servicioSaludRepo.findByCodigo(codigo).orElse(null);
    }
    
    @PostMapping
    public ServicioSalud crearServicio(@RequestBody ServicioSalud nuevoServicio) {
        return servicioSaludRepo.save(nuevoServicio);
    }
 
    @PutMapping("/{codigo}")
    public ResponseEntity<ServicioSalud> actualizarServicio(@PathVariable String codigo,
                                                            @RequestBody ServicioSalud servicioActualizado) {
        
        Optional<ServicioSalud> servicioViejo = servicioSaludRepo.findByCodigo(codigo);
        
        if (servicioViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            ServicioSalud servicio = servicioViejo.get();
            servicio.setNombre(servicioActualizado.getNombre());
            servicio.setTipo(servicioActualizado.getTipo());
            return ResponseEntity.ok(servicioSaludRepo.save(servicio));
        }
    }

    @DeleteMapping("/{codigo}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable String codigo) {
        Optional<ServicioSalud> servicio = servicioSaludRepo.findByCodigo(codigo);
        
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        } else {
            ServicioSalud servicioDel = servicio.get();
            servicioSaludRepo.delete(servicioDel);
            return ResponseEntity.noContent().build();
        }  
    }

}
