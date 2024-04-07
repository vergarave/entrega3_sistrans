package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.Empleado;
import uniandes.edu.co.proyecto.repositorios.EmpleadoRepository;

@Controller
public class EmpleadosController {

  @Autowired
  private EmpleadoRepository empleadoRepository;

  @GetMapping("/empleados")
  public String empleados(Model model) {
    model.addAttribute("empleados", empleadoRepository.darEmpleados());
    return "empleados";
  }

  @GetMapping("/empleados/new")
  public String empleadosForm(Model model) {
    model.addAttribute("empleado", new Empleado());
    return "empleados";
  }

  @PostMapping("/empleados/new/save")
  public String empleadossSave(@ModelAttribute Empleado empleado) {
    empleadoRepository.insertarEmpleado(empleado.getNumero_documento(),
        empleado.getCargo(), empleado.getTipo(), empleado.getTipo_documento(),
        empleado.getNombre(), empleado.getNacionalidad(),
        empleado.getDireccion_fisica(), empleado.getDireccion_electronica(),
        empleado.getTelefono(), empleado.getCodigo_postal(), empleado.getCiudad(),
        empleado.getDepartamento(), empleado.getIdOficina().getId());
    return "redirect:/empleados";
  }

}
