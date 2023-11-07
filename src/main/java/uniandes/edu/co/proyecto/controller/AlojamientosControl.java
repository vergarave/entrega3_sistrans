package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Alojamiento;
import uniandes.edu.co.proyecto.repositorio.AlojamientoRepo;

@Controller
public class AlojamientosControl {
    
    @Autowired
    private AlojamientoRepo alojamientoRepo;

    @GetMapping("/alojamientos")
    public String alojamientos(Model model){
        model.addAttribute("alojamientos", alojamientoRepo.darAlojamientos());
        return "alojamientos";
    }

    @GetMapping("/bares/new")
    public String alojamientoForm(Model model){
        model.addAttribute("alojamiento", new Alojamiento());
        return "alojamientoNuevo";
    }

    @PostMapping("/alojamientos/new/save")
    public String alojamientoGuardar(@ModelAttribute Alojamiento alojamiento){
        alojamientoRepo.insertarAlojamiento(alojamiento.getActiva(), alojamiento.getCheckin(), alojamiento.getCheckout(), alojamiento.getAcompanantes(), alojamiento.getUsuario(), alojamiento.getPlan(), alojamiento.getCuenta(), alojamiento.getHabitacion());

    }
}