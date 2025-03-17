package uniandes.edu.co.proyecto.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.ServicioSalud;
import uniandes.edu.co.proyecto.repositorio.ServicioSaludRepository;

@Controller
public class ServicioSaludController {

    @Autowired
    private ServicioSaludRepository servicioSaludRepository;

    @GetMapping("/serviciosSalud")
    public String serviciosSalud(Model model) {
        model.addAttribute("serviciosSalud", servicioSaludRepository.darServiciosSalud());
        return "serviciosSalud";
    }

    @GetMapping("/serviciosSalud/new")
    public String servicioSaludForm(Model model) {
        model.addAttribute("servicioSalud", new ServicioSalud());
        return "servicioSaludNuevo";
    }
    
    @PostMapping("/serviciosSalud/new/save")
    public String servicioSaludGuardar(@ModelAttribute ServicioSalud servicioSalud) {
        servicioSaludRepository.insertarServicioSalud(servicioSalud.getNombre(), servicioSalud.getDescripcion(), 
                                servicioSalud.getTipoServicio().toString(), servicioSalud.getIpsOfrecida().getNit());
        
        return "redirect:/serviciosSalud";
    }

    @GetMapping("/serviciosSalud/{nombre}/edit")
    public String servicioSaludEditarForm(@PathVariable("nombre") String nombre, Model model) {
        Optional<ServicioSalud> servicioSalud = servicioSaludRepository.darServicioSalud(nombre);
        if (servicioSalud.isPresent()) {
            model.addAttribute("servicioSalud", servicioSalud.get());
            return "servicioSaludEditar";
        } else {
            return "redirect:/serviciosSalud";
        }
    }

    @PostMapping("/serviciosSalud/{nombre}/edit/save")
    public String servicioSaludEditarGuardar(@PathVariable("nombre") String nombre, @ModelAttribute ServicioSalud servicioSalud) {
       servicioSaludRepository.actualizarServicioSalud(nombre, servicioSalud.getDescripcion(), 
                                servicioSalud.getTipoServicio().toString(), servicioSalud.getIpsOfrecida().getNit());
        
        return "redirect:/serviciosSalud"; 
    }

    @GetMapping("/serviciosSalud/{nombre}/delete")
    public String servicioSaludEliminar(@PathVariable("nombre") String nombre) {
        servicioSaludRepository.eliminarServicioSalud(nombre);;
        return "redirect:/serviciosSalud";
    }
    
}
