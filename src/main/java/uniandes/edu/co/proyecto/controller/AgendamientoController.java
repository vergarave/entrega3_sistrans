package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.Agendamiento;
import uniandes.edu.co.proyecto.repositorio.AgendamientoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api/agendamientos")
public class AgendamientoController {
    
    @Autowired
    private AgendamientoRepository agendamientoRepo;
    
    @GetMapping
    public List<Agendamiento> obtenerAgendamientos() {
        return agendamientoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Agendamiento obtenerAgendamientoPorId(@PathVariable String id) {
        return agendamientoRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Agendamiento crearAgendamiento(@RequestBody Agendamiento nuevoAgendamiento) {
        return agendamientoRepo.save(nuevoAgendamiento);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamiento> actualizarAgendamiento(@PathVariable String id,
                                                @RequestBody Agendamiento agendamientoActualizado) {
        Optional<Agendamiento> agendamientoViejo = agendamientoRepo.findById(id);
        
        if (agendamientoViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            Agendamiento agendamiento = agendamientoViejo.get();
            agendamiento.setFecha(agendamientoActualizado.getFecha());
            agendamiento.setHora(agendamientoActualizado.getHora());
            agendamiento.setAfiliado(agendamientoActualizado.getAfiliado());
            agendamiento.setMedico(agendamientoActualizado.getMedico());
            agendamiento.setIps(agendamientoActualizado.getIps());
            agendamiento.setServicio(agendamientoActualizado.getServicio());
            agendamiento.setOrden(agendamientoActualizado.getOrden());
            return ResponseEntity.ok(agendamientoRepo.save(agendamiento));
        }  
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAgendamiento(@PathVariable String id) {
        Optional<Agendamiento> agendamiento = agendamientoRepo.findById(id);
        
        if (agendamiento == null) {
            return ResponseEntity.notFound().build();
        } else {
            Agendamiento agendamientoDel = agendamiento.get();
            agendamientoRepo.delete(agendamientoDel);
            return ResponseEntity.noContent().build();
        }
    }
    

    
}
