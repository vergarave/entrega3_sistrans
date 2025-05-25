package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import uniandes.edu.co.proyecto.repositorio.OrdenServicioRepository;
import uniandes.edu.co.proyecto.modelo.OrdenServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@Controller
@RequestMapping("/api/ordenes")
public class OrdenServicioController {
    
    @Autowired
    private OrdenServicioRepository ordenServicioRepo;

    @GetMapping
    public List<OrdenServicio> obtenerOrdenes() {
        return ordenServicioRepo.findAll();
    }

    @GetMapping("/{id}")
    public OrdenServicio obtenerOrdenPorId(@PathVariable String id) {
        return ordenServicioRepo.findById(id).orElse(null);
    }

    @PostMapping
    public OrdenServicio crearOrden(@RequestBody OrdenServicio nuevoOrden) {
        return ordenServicioRepo.save(nuevoOrden);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<OrdenServicio> actualizarOrden(@PathVariable String id, @RequestBody OrdenServicio ordenActualizado) {
        Optional<OrdenServicio> ordenViejo = ordenServicioRepo.findById(id);

        if(ordenViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            OrdenServicio orden = ordenViejo.get();
            orden.setFecha(ordenActualizado.getFecha());
            orden.setEstado(ordenActualizado.getEstado());
            orden.setAfiliado(ordenActualizado.getAfiliado());
            orden.setMedico(ordenActualizado.getMedico());
            orden.setServicio(ordenActualizado.getServicio());
            return ResponseEntity.ok(ordenServicioRepo.save(orden));
        } 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarOrden(@PathVariable String id) {
        Optional<OrdenServicio> orden = ordenServicioRepo.findById(id);
        if(orden == null) {
            return ResponseEntity.notFound().build();
        } else {
            OrdenServicio ordenDel = orden.get();
            ordenServicioRepo.delete(ordenDel);
            return ResponseEntity.noContent().build();
        }
    }
    
    
}
