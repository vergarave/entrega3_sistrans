package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.repositorio.IpsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class IpsController {
    
    @Autowired
    private IpsRepository ipsRepo;

    @GetMapping("/ipses")
    public String ipses(Model model) {
        model.addAttribute("ipses", ipsRepo.darIpses());
        return "ipses";
    }

    @GetMapping("/ipses/new")
    public String ipsForm(Model model) {
        model.addAttribute("ips", new Ips());
        return "ipsNuevo";
    }

    @PostMapping("/ipses/new/save")
    public String ipsGuardar(@ModelAttribute Ips ips) {
        ipsRepo.insertarIps(ips.getNit(), ips.getNombre(), ips.getCiudad(), ips.getDireccion(), ips.getTelefono(), ips.getEpsNit());
        return "redirect:/ipses"; 
    }

    @GetMapping("/ipses/{NIT}/edit")
    public String ipsEditarForm(@PathVariable("NIT") String nit, Model model) {
        Ips ips = ipsRepo.darIps(nit);
        if(ips != null) {
            model.addAttribute("ips", ips);
            return "ipsEditar";
        }
        else{
            return "redirect:/ipses";
        }  
    }

    @PostMapping("/ipses/{NIT}/edit/save")
    public String ipsEditarGuardar(@PathVariable("NIT") String nit, @ModelAttribute Ips ips) {
        ipsRepo.actualizarIps(nit, ips.getNombre(), ips.getCiudad(), ips.getDireccion(), ips.getTelefono(), ips.getEpsNit());
        
        return "redirect:/ipses";
    }

    @GetMapping("/ipses/{NIT}/delete")
    public String epsEliminar(@PathVariable("NIT") String nit) {
        ipsRepo.eliminarIps(nit);
        return  "redirect:/ipses";
    }
    
}
