package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import uniandes.edu.co.proyecto.repositorio.MedicoRepository;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.Medico;


@RestController
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
        return medicoRepo.findByRegistroMedico(registroMedico).orElse(null);
    }

    @PostMapping
    public Medico crearMedico(@RequestBody Medico nuevoMedico) {
        return medicoRepo.save(nuevoMedico);
    }

    @PutMapping("/{registroMedico}")
    public ResponseEntity<Medico> actualizarMedico(@PathVariable String registroMedico,
                                                            @RequestBody Medico medicoActualizado) {
        
        Optional<Medico> medicoViejo = medicoRepo.findByRegistroMedico(registroMedico);

        if (medicoViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            Medico medico = medicoViejo.get();
            medico.setNombre(medicoActualizado.getNombre());
            medico.setEspecialidad(medicoActualizado.getEspecialidad());
            medico.setIps(medicoActualizado.getIps());
            medico.setServicios(medicoActualizado.getServicios());
            return ResponseEntity.ok(medicoRepo.save(medico));
        }
    }

    @DeleteMapping("/{registroMedico}")
    public ResponseEntity<Void> eliminarMedico(@PathVariable String registroMedico) {
        Optional<Medico> medico = medicoRepo.findByRegistroMedico(registroMedico);
        
        if (medico == null) {
            return ResponseEntity.notFound().build();
        } else {
            Medico medicoDel = medico.get();
            medicoRepo.delete(medicoDel);
            return ResponseEntity.noContent().build();
        }  
    }


    

}
