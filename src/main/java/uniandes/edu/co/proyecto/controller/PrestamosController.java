package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.repositorios.PrestamoRepository;

@Controller
public class PrestamosController {
  @Autowired
  private PrestamoRepository prestamoRepository;

  @GetMapping("/prestamos")
  public String prestamos(Model model) {
    model.addAttribute("prestamos", prestamoRepository.darPrestamos());
    return "prestamos";
  }

  @GetMapping("/prestamos/new")
  public String prestamosForm(Model model) {
    model.addAttribute("prestamo", new Prestamo());
    return "prestamosNew";
  }

  @PostMapping("/prestamos/new/save")
  public String prestamosSave(@ModelAttribute Prestamo prestamo) {
    prestamoRepository.insertarPrestamo(prestamo.getEstado(), prestamo.getTipo(), prestamo.getMonto(),
        prestamo.getInteres(), prestamo.getNumero_cuotas(), prestamo.getDia_mes_pagar_cuota(),
        prestamo.getValor_cuota(), prestamo.getCliente().getId(),
        prestamo.getGerente_creador(), prestamo.getSaldo_pendiente());

    return "redirect:/prestamos";
  }

  @GetMapping("/prestamos/{id}/edit")
  public String prestamosEditForm(@PathVariable("id") int id, Model model) {
    Prestamo prestamo = prestamoRepository.darPrestamo(id);
    if (prestamo != null) {
      model.addAttribute("prestamo", prestamo);
      return "prestamoEdit";
    } else {
      return "redirect:/prestamos";
    }
  }

  @PostMapping("/prestamos/{id}/edit/save")
  public String prestamosditSave(@PathVariable("id") long id,
      @ModelAttribute Prestamo prestamo) {
        if(prestamo.getEstado().equals("Pagado")){
          if(prestamo.getSaldo_pendiente() == 0){
          prestamoRepository.actualizarPrestamo(id, prestamo.getEstado(), prestamo.getTipo(), prestamo.getMonto(),
          prestamo.getInteres(),
          prestamo.getNumero_cuotas(),
          prestamo.getDia_mes_pagar_cuota(), prestamo.getValor_cuota(), prestamo.getCliente().getId(),
          prestamo.getGerente_creador(), prestamo.getSaldo_pendiente());
          return "redirect:/prestamos";
          }else{
            return "noEliminarPrestamo";
          }
        }
        prestamoRepository.actualizarPrestamo(id, prestamo.getEstado(), prestamo.getTipo(), prestamo.getMonto(),
        prestamo.getInteres(),
        prestamo.getNumero_cuotas(),
        prestamo.getDia_mes_pagar_cuota(), prestamo.getValor_cuota(), prestamo.getCliente().getId(),
        prestamo.getGerente_creador(), prestamo.getSaldo_pendiente());
        return "redirect:/prestamos";
  }

  @GetMapping("/prestamos/{id}/delete")
  public String prestamosBorrar(@PathVariable("id") long id) {
    prestamoRepository.eliminarPrestamo(id);
    return "redirect:/prestamos";
  }
}
