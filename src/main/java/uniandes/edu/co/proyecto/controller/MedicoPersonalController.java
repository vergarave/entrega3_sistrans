package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.MedicoPersonal;
import uniandes.edu.co.proyecto.repositorio.MedicoPersonalRepository;

@Controller
public class MedicoPersonalController {
    
    @Autowired
    private MedicoPersonalRepository medPersonalRepo;

    @GetMapping("/medicospersonal")
    public String medicospersonal(Model model){
        model.addAttribute("medicospersonal", medPersonalRepo.darMedicosPersonal());
        return "/medicospersonal";
    }

    @GetMapping("/medicospersonal/new")
    public String medicopersonalForm(Model model){
        model.addAttribute("medicopersonal", new MedicoPersonal());
        return "medicoPersonalNuevo";
    }

    @PostMapping("/medicospersonal/new/save")
    public String medicopersonalGuardar(@ModelAttribute MedicoPersonal medicoPersonal) {
        medPersonalRepo.insertarMedicoPersonal(medicoPersonal.getRegistroMedico(), medicoPersonal.getTipoDoc(), 
                                                medicoPersonal.getNumDoc(), medicoPersonal.getNombre());
        return "redirect:/medicospersonal";  
    }

    @GetMapping("/medicospersonal/{registroMedico}/edit")
    public String medicosPersonalEditarForm(@PathVariable("registroMedico") String registroMedico, Model model) {
        MedicoPersonal medicoPersonal = medPersonalRepo.darMedicoPersonal(registroMedico);
        if(medicoPersonal != null) {
            model.addAttribute("medicopersonal", medicoPersonal);
            return "medicoPersonalEditar";
        }
        else{
            return "redirect:/medicospersonal";
        }  
    }

    @PostMapping("/medicospersonal/{registroMedico}/edit/save")
    public String medicoPersonalEditarGuardar(@PathVariable("registroMedico") String registroMedico, @ModelAttribute MedicoPersonal medicoPersonal) {
        medPersonalRepo.actualizarMedicoPersonal(registroMedico, medicoPersonal.getTipoDoc(), 
                                                medicoPersonal.getNumDoc(), medicoPersonal.getNombre());
        return "redirect:/medicospersonal";
    }

    @GetMapping("/medicospersonal/{registroMedico}/delete")
    public String medicoPersonalEliminar(@PathVariable("registroMedico") String registroMedico) {
        medPersonalRepo.eliminarMedicoPersonal(registroMedico);
        return  "redirect:/medicospersonal";
    }
}
