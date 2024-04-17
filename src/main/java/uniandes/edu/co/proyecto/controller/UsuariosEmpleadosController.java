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

    @GetMapping("/usuariosEmpleados/{login}/{password_empleado}")
    public String usuariosEmpleadosCargo(@PathVariable("login") String login, @PathVariable("password_empleado") String password_empleado, Model model) {
        
        String paginaDestino = "index";
        
        if(login != null && !login.equals("") && password_empleado != null && !password_empleado.equals(""))
        { 
            System.out.println("entró");
            System.out.println(login);
            System.out.println(password_empleado);
            String cargo= usuarioEmpleadoRepository.verificarUsuarioEmpleadoYObtenerCargo(login, password_empleado);
            System.out.println(cargo);
            
            if (cargo.equals("Gerente oficina")) {
                paginaDestino = "gerenteOficina";
            } else if (cargo.equals("Gerente general")) {
                paginaDestino = "gerenteGeneral";
            } else if (cargo.equals("Cajero")) {
                paginaDestino = "cajero";
            }else if (cargo.equals("Administrador")) {
                paginaDestino = "administrador";
            }

        } else {
            
            paginaDestino = "loginIncorrecto";
        }

        return paginaDestino;
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
