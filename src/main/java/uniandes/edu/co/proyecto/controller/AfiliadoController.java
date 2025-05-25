package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;


@Controller
@RequestMapping("/api/afiliados")
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepo;

    @GetMapping
    public List<Afiliado> obtenerAfiliados() {
        return afiliadoRepo.findAll();
    }

    @GetMapping("/{id}")
    public Afiliado obtenerAfiliadoPorId(@PathVariable String id) {
        return afiliadoRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Afiliado crearAfiliado(@RequestBody Afiliado nuevoAfiliado) {
        return afiliadoRepo.save(nuevoAfiliado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Afiliado> actualizarAfiliado(@PathVariable String id,
                                                            @RequestBody Afiliado afiliadoActualizado) {
        
        Optional<Afiliado> afiliadoViejo = afiliadoRepo.findById(id);

        if (afiliadoViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            Afiliado afiliado = afiliadoViejo.get();
            afiliado.setNombre(afiliadoActualizado.getNombre());
            afiliado.setFechaNacimiento(afiliadoActualizado.getFechaNacimiento());
            afiliado.setDireccion(afiliadoActualizado.getDireccion());
            afiliado.setTelefono(afiliadoActualizado.getTelefono());
            afiliado.setTipoAfiliado(afiliadoActualizado.getTipoAfiliado());
            afiliado.setParentesco(afiliadoActualizado.getParentesco());
            afiliado.setIdContribuyente(afiliadoActualizado.getIdContribuyente());
            return ResponseEntity.ok(afiliadoRepo.save(afiliado));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAfiliado(@PathVariable String id) {
        Optional<Afiliado> afiliado = afiliadoRepo.findById(id);
        
        if (afiliado == null) {
            return ResponseEntity.notFound().build();
        } else {
            Afiliado afiliadoDel = afiliado.get();
            afiliadoRepo.delete(afiliadoDel);
            return ResponseEntity.noContent().build();
        }  
    }
    
}
