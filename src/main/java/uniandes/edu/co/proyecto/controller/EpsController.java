package uniandes.edu.co.proyecto.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import uniandes.edu.co.proyecto.modelo.Eps;
import uniandes.edu.co.proyecto.repositorio.EpsRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class EpsController {
    
    @Autowired
    private EpsRepository epsRepo;

    @GetMapping("/epses")
    public Collection<Eps> epses(Model model){
        model.addAttribute("epses", epsRepo.darEpses());
        return epsRepo.darEpses();
        //return "epses";
        //return model.toString();
    }

    @GetMapping("/epses/new")
    public String epsForm(Model model){
        model.addAttribute("eps", new Eps());
        return "epsNuevo";
    }

    @PostMapping("/epses/new/save")
    public String epsGuardar(@ModelAttribute Eps eps) {
        epsRepo.insertarEps(eps.getNit(), eps.getNombre());
        return "redirect:/epses";
        
    }

    @GetMapping("/epses/{NIT}/edit")
    public String epsEditarForm(@PathVariable("NIT") String nit, Model model) {
        Eps eps = epsRepo.darEps(nit);
        if(eps != null) {
            model.addAttribute("eps", eps);
            return "epsEditar";
        }
        else{
            return "redirect:/epses";
        }  
    }

    @PostMapping("/epses/{NIT}/edit/save")
    public String epsEditarGuardar(@PathVariable("NIT") String nit, @ModelAttribute Eps eps) {
        epsRepo.actualizarEps(nit, eps.getNombre());
        
        return "redirect:/epses";
    }

    @GetMapping("/epses/{NIT}/delete")
    public String epsEliminar(@PathVariable("NIT") String nit) {
        epsRepo.eliminarEps(nit);
        return  "redirect:/epses";
    }
    
}
