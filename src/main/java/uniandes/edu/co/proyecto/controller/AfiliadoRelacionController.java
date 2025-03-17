package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import uniandes.edu.co.proyecto.modelo.AfiliadoRelacion;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRelacionRepository;

@Controller
public class AfiliadoRelacionController {

    
    @Autowired
    AfiliadoRelacionRepository afiliadoRelacionRepository;

    @GetMapping("/afiliadosRelaciones")
    public String afiliadosRelaciones(Model model) {
        model.addAttribute("afiliadosRelaciones", afiliadoRelacionRepository.darAfiliadoRelaciones());
        return "afiliadosRelaciones";
    }

    @GetMapping("/afiliadosRelaciones/new")
    public String afiliadoRelacionForm(Model model) {
        model.addAttribute("afiliadoRelacion", new AfiliadoRelacion());
        return "afiliadoRelacionNuevo";
    }
    
    @PostMapping("/afiliadosRelaciones/new/save")
    public String afiliadoRelacionGuardar(@ModelAttribute AfiliadoRelacion arel) {
        afiliadoRelacionRepository.insertarAfiliadoRelacion(arel.getTipoDoc(), arel.getNumDoc(), 
                                            arel.getTipoAfiliado().toString(), arel.getRelacionParentesco());

        return "redirect:/afiliadosRelaciones";
    }

    @GetMapping("/afiliadosRelacione/{numDoc}/edit")
    public String afiliadoRelacionEditarForm(@PathVariable("numDoc") int numDoc, Model model) {
        Optional<AfiliadoRelacion> afiliadoRelacion = afiliadoRelacionRepository.darAfiliadoRelacion(numDoc);
        if (afiliadoRelacion.isPresent()) {
            model.addAttribute("afiliadoRelacion", afiliadoRelacion.get());
            return "afiliadoRelacionEditar";
        } else {
            return "redirect:/afiliadosRelaciones";
        }
    }

    @PostMapping("/afiliadosRelaciones/{numDoc}/edit/save")
    public String afiliadoRelacionEditarGuardar(@PathVariable("numDoc") int numDoc, @ModelAttribute AfiliadoRelacion afiliadoRelacion) {
          afiliadoRelacionRepository.actualizarAfiliadoRelacion(numDoc, afiliadoRelacion.getTipoAfiliado().toString(), 
                                    afiliadoRelacion.getRelacionParentesco());
        return "redirect:/afiliadosRelaciones"; 
    }

    @GetMapping("/afiliadosRelaciones/{numDoc}/delete")
    public String afiliadoEliminar(@PathVariable("numDoc") int numDoc) {
        afiliadoRelacionRepository.eliminarAfiliadoRelacion(numDoc);
        return "redirect:/afiliadosRelaciones";
    }
}
