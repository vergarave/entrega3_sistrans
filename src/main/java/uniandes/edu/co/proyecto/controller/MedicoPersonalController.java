package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.MedicoPersonal;
import uniandes.edu.co.proyecto.repositorio.MedicoPersonalRepository;

@RestController
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

    @GetMapping("/medicospersonal/{REGISTRO_MEDICO}/edit")
    public String medicosPersonalEditarForm(@PathVariable("REGISTRO_MEDICO") String registroMedico, Model model) {
        MedicoPersonal medicoPersonal = medPersonalRepo.darMedicoPersonal(registroMedico);
        if(medicoPersonal != null) {
            model.addAttribute("medicopersonal", medicoPersonal);
            return "medicoPersonalEditar";
        }
        else{
            return "redirect:/medicospersonal";
        }  
    }

    @PostMapping("/medicospersonal/{REGISTRO_MEDICO}/edit/save")
    public String medicoPersonalEditarGuardar(@PathVariable("REGISTRO_MEDICO") String registroMedico, @ModelAttribute MedicoPersonal medicoPersonal) {
        medPersonalRepo.actualizarMedicoPersonal(registroMedico, medicoPersonal.getTipoDoc(), 
                                                medicoPersonal.getNumDoc(), medicoPersonal.getNombre());
        return "redirect:/medicospersonal";
    }

    @GetMapping("/medicospersonal/{REGISTRO_MEDICO}/delete")
    public String medicoPersonalEliminar(@PathVariable("REGISTRO_MEDICO") String registroMedico) {
        medPersonalRepo.eliminarMedicoPersonal(registroMedico);
        return  "redirect:/medicospersonal";
    }
}
