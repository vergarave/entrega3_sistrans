package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.repositorios.OperacionPrestamoRepository;

@Controller
public class OperacionesPrestamosController {
  @Autowired
  private OperacionPrestamoRepository operacionPrestamoRepository;

  @GetMapping("/operaciones_prestamos")
  public String operaciones_cuentas(Model model) {
    model.addAttribute("operaciones_prestamos", operacionPrestamoRepository.darOperacionesPrestamos());
    return "operaciones_prestamos";
  }

  @GetMapping("/operaciones_prestamos/new")
  public String operaciones_cuentasForm(Model model) {
    model.addAttribute("operacion_prestamo", new OperacionPrestamo());
    return "operaciones_prestamos";
  }

  @PostMapping("/operaciones_prestamos/new/save")
  public String operaciones_prestamosSave(@ModelAttribute OperacionPrestamo operacionPrestamo) {
    operacionPrestamoRepository.insertarOperacionPrestamo(operacionPrestamo.getTipo_operacion(),
        operacionPrestamo.getFecha(), operacionPrestamo.getCuenta_prestamo(), operacionPrestamo.getMonto_operacion(),
        operacionPrestamo.getCliente(), operacionPrestamo.getPunto_atencion().getId());
    return "redirect:/operaciones_prestamos";
  }

  @GetMapping("/operaciones_prestamos/{id}/edit")
  public String operaciones_prestamosEditForm(@PathVariable("id") int id, Model model) {
    OperacionPrestamo operacionPrestamo = operacionPrestamoRepository.darOperacionPrestamo(id);
    if (operacionPrestamo != null) {
      model.addAttribute("operacion_prestamo", operacionPrestamo);
      return "operacion_prestamoEdit";
    } else {
      return "redirect:/operaciones_prestamos";
    }
  }

  @PostMapping("/operaciones_prestamos/{id}/edit/save")
  public String operaciones_prestamosEditSave(@PathVariable("id") long id,
      @ModelAttribute OperacionPrestamo operacionPrestamo) {
    operacionPrestamoRepository.actualizarOperacionPrestamo(id, operacionPrestamo.getTipo_operacion(),
        operacionPrestamo.getFecha(), operacionPrestamo.getCuenta_prestamo(), operacionPrestamo.getMonto_operacion(),
        operacionPrestamo.getCliente(), operacionPrestamo.getCliente());
    return "redirect:/operaciones_prestamos";
  }

  @GetMapping("/operaciones_prestamos/{id}/delete")
  public String operaciones_prestamosBorrar(@PathVariable("id") long id) {
    operacionPrestamoRepository.eliminaOperacionPrestamo(id);
    return "redirect:/operaciones_cuentas";
  }

}
