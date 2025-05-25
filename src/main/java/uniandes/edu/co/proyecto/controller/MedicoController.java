package uniandes.edu.co.proyecto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.repositorio.MedicoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import uniandes.edu.co.proyecto.modelo.Medico;
import uniandes.edu.co.proyecto.modelo.ServicioSalud;


@Controller
@RequestMapping("/api/medicos")
public class MedicoController {
    
    @Autowired
    private MedicoRepository medicoRepo;
    
    @GetMapping
    public List<Medico> obtenerMedicos() {
        return medicoRepo.findAll();
    }

    @GetMapping("/{registroMedico}")
    public Medico obtenerMedicoPorRM(@PathVariable String registroMedico) {
        return medicoRepo.findByRegistroMedico(registroMedico);
    }

    @PostMapping
    public Medico crearMedico(@RequestBody Medico nuevoMedico) {
        return medicoRepo.save(nuevoMedico);
    }

    @PutMapping("/{registroMedico}")
    public ResponseEntity<Medico> actualizarServicio(@PathVariable String registroMedico,
                                                            @RequestBody Medico medicoActualizado) {
        
        Medico medicoViejo = medicoRepo.findByRegistroMedico(registroMedico);
        //si hay errores tipo crash del app cuando no se encuentra el servicio, implementar Optional<> en repositorio
        if (medicoViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            medicoViejo.setNombre(medicoActualizado.getNombre());
            medicoViejo.setEspecialidad(medicoActualizado.getEspecialidad());
            medicoViejo.setIps(medicoActualizado.getIps());
            medicoViejo.setServicios(medicoActualizado.getServicios());
            return ResponseEntity.ok(medicoRepo.save(medicoViejo));
        }
    }

    @DeleteMapping("/{registroMedico}")
    public ResponseEntity<Void> eliminarServicio(@PathVariable String registroMedico) {
        Medico medico = medicoRepo.findByRegistroMedico(registroMedico);
        
        if (medico == null) {
            return ResponseEntity.notFound().build();
        } else {
            medicoRepo.delete(medico);
            return ResponseEntity.noContent().build();
        }  
    }


    

}
