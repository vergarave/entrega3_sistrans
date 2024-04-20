package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;
import uniandes.edu.co.proyecto.repositorios.EmpleadoRepository;

@Controller
public class EmpleadosController {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @GetMapping("/empleados")
  public String empleados(Model model) {
    model.addAttribute("empleados", empleadoRepository.darEmpleados());
    return "administrador";
  }

  @GetMapping("/empleados/new")
  public String empleadosForm(Model model) {
    model.addAttribute("empleado", new Empleado());
    return "empleadoNew";
  }

  @PostMapping("/empleados/new/save")
  public String empleadossSave(@ModelAttribute Empleado empleado,Model model) {
    empleadoRepository.insertarEmpleado(empleado.getNumero_documento(),
        empleado.getCargo(), empleado.getTipo(), empleado.getTipo_documento(),
        empleado.getNombre(), empleado.getNacionalidad(),
        empleado.getDireccion_fisica(), empleado.getDireccion_electronica(),
        empleado.getTelefono(), empleado.getCodigo_postal(), empleado.getCiudad(),
        empleado.getDepartamento(), empleado.getId_oficina().getId());
    
      model.addAttribute("usuarioEmpleado", new UsuarioEmpleado());
      model.addAttribute("empleados", empleadoRepository.darEmpleados());

    return "usuarioEmpleadoNew";
  }

  @GetMapping("/empleados/{id}/edit")
  public String empleadoEditForm(@PathVariable("id") int id, Model model) {
    Empleado empleado = empleadoRepository.darEmpleado(id);
    if (empleado != null) {
      model.addAttribute("empleado", empleado);
      return "empleadoEdit";
    } else {
      return "redirect:/empleados";
    }
  }

  @PostMapping("/empleados/{id}/edit/save")
  public String empleadoEditSave(@PathVariable("id") long id, @ModelAttribute Empleado empleado) {
    empleadoRepository.actualizarEmpleado(id, empleado.getNumero_documento(), empleado.getTipo(), empleado.getCargo(),
        empleado.getTipo_documento(), empleado.getNombre(), empleado.getNacionalidad(), empleado.getDireccion_fisica(),
        empleado.getDireccion_electronica(),
        empleado.getTelefono(), empleado.getCodigo_postal(), empleado.getCiudad(), empleado.getDepartamento(),
        empleado.getId_oficina().getId());
    return "redirect:/empleados";
  }

  @GetMapping("/empleados/{id}/delete")
  public String empleadoBorrar(@PathVariable("id") long id) {
    empleadoRepository.eliminarEmpleado(id);
    return "redirect:/empleados";
  }
}
