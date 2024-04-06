package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.UsuarioEmpleado;
import uniandes.edu.co.proyecto.repositorios.UsuarioEmpleadoRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class UsuariosEmpleadosController {

    @Autowired
    private UsuarioEmpleadoRepository usuarioEmpleadoRepository;

    @GetMapping("/usuariosEmpleados")
    public String usuariosEmpleados(Model model) {
        model.addAttribute("usuariosEmpleados", usuarioEmpleadoRepository.darUsuariosEmpleados());
        return "usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/new")
    public String usuarioEmpleadoForm(Model model) {
        model.addAttribute("usuarioEmpleado", new UsuarioEmpleado());
        return "usuarioEmpleadoNew";
    }

    @PostMapping("/usuariosEmpleados/new/save")
    public String usuarioEmpleadoSave(@ModelAttribute UsuarioEmpleado usuarioEmpleado) {

        usuarioEmpleadoRepository.insertarUsuarioEmpleado(usuarioEmpleado.getLogin(), usuarioEmpleado.getPassword_empleados(), 
                                                        usuarioEmpleado.getId());
        
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/{id}/edit")
    public String usuarioEmpleadoEditForm(@PathVariable("id") int id, Model model) {
        UsuarioEmpleado usuarioEmpleado = usuarioEmpleadoRepository.darUsuarioEmpleado(id);
        if (usuarioEmpleado != null) {
            model.addAttribute("usuarioEmpleado", usuarioEmpleado);
            return "usuarioEmpleadoEdit";
        } else {
            return "redirect:/usuariosEmpleados";
        }
    }

    @PostMapping("/usuariosEmpleados/{id}/save")
    public String usuarioEmpleadoEditSave(@PathVariable("id") long id, @ModelAttribute UsuarioEmpleado usuarioEmpleado) {
        usuarioEmpleadoRepository.insertarUsuarioEmpleado(usuarioEmpleado.getLogin(), usuarioEmpleado.getPassword_empleados(),
                                                        usuarioEmpleado.getId());
        return "redirect:/usuariosEmpleados";
    }

    @GetMapping("/usuariosEmpleados/{id}/delete")
    public String usuarioEmpleadoDelete(@PathVariable("id") long id) {
        usuarioEmpleadoRepository.eliminarUsuarioEmpleado(id);
        return "redirect:/usuariosEmpleados";
    }
    
}
