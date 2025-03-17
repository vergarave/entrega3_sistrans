package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Afiliado;
import uniandes.edu.co.proyecto.repositorio.AfiliadoRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AfiliadoController {

    @Autowired
    private AfiliadoRepository afiliadoRepository;

    @GetMapping("/afiliados")
    public String afiliados(Model model) {
        model.addAttribute("afiliados", afiliadoRepository.darAfiliados());
        return "afiliados";
    }

    @GetMapping("/afiliados/new")
    public String afiliadoForm(Model model) {
        model.addAttribute("afiliado", new Afiliado());
        return "afiliadoNuevo";
    }
    
    @PostMapping("/afiliados/new/save")
    public String afiliadoGuardar(@ModelAttribute Afiliado afiliado) {
        afiliadoRepository.insertarAfiliado(afiliado.getTipoDoc(), afiliado.getNumDoc(), afiliado.getNombre(), afiliado.getFechaNac(),
            afiliado.getCiudad(), afiliado.getDireccion(), afiliado.getTelefono(), afiliado.getEpsAsociada().getNit());
        
        return "redirect:/afiliados";
    }

    @GetMapping("/afiliados/{numDoc}/edit")
    public String afiliadoEditarForm(@PathVariable("numDoc") int numDoc, Model model) {
        Optional<Afiliado> afiliado = afiliadoRepository.darAfiliado(numDoc);
        if (afiliado.isPresent()) {
            model.addAttribute("afiliado", afiliado.get());
            return "afiliadoEditar";
        } else {
            return "redirect:/afiliados";
        }
    }

    @PostMapping("/afiliados/{numDoc}/edit/save")
    public String afiliadoEditarGuardar(@PathVariable("numDoc") int numDoc, @ModelAttribute Afiliado afiliado) {
          afiliadoRepository.actualizarAfiliado(afiliado.getTipoDoc(), numDoc, afiliado.getNombre(), afiliado.getFechaNac(),
          afiliado.getCiudad(), afiliado.getDireccion(), afiliado.getTelefono(), afiliado.getEpsAsociada().getNit());  
        return "redirect:/afiliados"; 
    }

    @GetMapping("/afiliados/{numDoc}/delete")
    public String afiliadoEliminar(@PathVariable("numDoc") int numDoc) {
        afiliadoRepository.eliminarAfiliado(numDoc);
        return "redirect:/afiliados";
    }
    
}
