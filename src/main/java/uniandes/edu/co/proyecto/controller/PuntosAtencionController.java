package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.PuntoAtencion;
import uniandes.edu.co.proyecto.repositorios.PuntoAtencionRepository;

@Controller
public class PuntosAtencionController {
  @Autowired
  private PuntoAtencionRepository puntoAtencionRepository;

  @GetMapping("/puntos_atencion")
  public String puntos_atencion(Model model) {
    model.addAttribute("puntos_atencion", puntoAtencionRepository.darPuntosAtencion());
    return "puntos_atencion";
  }

  @GetMapping("/puntos_atencion/new")
  public String prestamosForm(Model model) {
    model.addAttribute("punto_atencion", new PuntoAtencion());
    return "puntos_atencion";
  }

  @PostMapping("/puntos_atencion/new/save")
  public String prestamosSave(@ModelAttribute PuntoAtencion puntoAtencion) {
    puntoAtencionRepository.insertarPuntoAtencion(puntoAtencion.getTipo(),
        puntoAtencion.getCiudad(), puntoAtencion.getHorarioAtencion(), puntoAtencion.getDireccion(),
        puntoAtencion.getIdOficina().getId());
    return "redirect:/puntos_atencion";
  }

  @GetMapping("/puntos_atencion/{id}/edit")
  public String puntos_atencionEditForm(@PathVariable("id") int id, Model model) {
    PuntoAtencion puntoAtencion = puntoAtencionRepository.darPuntoAtencion(id);
    if (puntoAtencion != null) {
      model.addAttribute("punto_atencion", puntoAtencion);
      return "punto_atencionEdit";
    } else {
      return "redirect:/puntos_atencion";
    }
  }

  @PostMapping("/puntos_atencion/{id}/edit/save")
  public String prestamosditSave(@PathVariable("id") long id,
      @ModelAttribute PuntoAtencion puntoAtencion) {
    puntoAtencionRepository.actualizarPuntoAtencion(id, puntoAtencion.getTipo(),
        puntoAtencion.getCiudad(), puntoAtencion.getHorarioAtencion(), puntoAtencion.getDireccion(),
        puntoAtencion.getIdOficina().getId());
    return "redirect:/puntos_atencion";
  }

  @GetMapping("/puntos_atencion/{id}/delete")
  public String prestamosBorrar(@PathVariable("id") long id) {
    puntoAtencionRepository.eliminaPuntoAtencion(id);
    return "redirect:/puntos_atencion";
  }
}
