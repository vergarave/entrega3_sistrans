package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import uniandes.edu.co.proyecto.modelo.UsuarioCliente;
import uniandes.edu.co.proyecto.repositorios.UsuarioClienteRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class UsuariosClientesController {

    @Autowired
    private UsuarioClienteRepository usuarioClienteRepository;

    @GetMapping("/usuariosClientes")
    public String usuariosClientes(Model model) {
        model.addAttribute("usuariosClientes", usuarioClienteRepository.darUsuariosClientes());
        return "usuariosClientes";
    }

    @GetMapping("/usuariosClientes/new")
    public String usuarioClienteForm(Model model) {
        model.addAttribute("usuarioCliente", new UsuarioCliente());
        return "usuarioClienteNew";
    }

    @PostMapping("/usuariosClientes/new/save")
    public String usuarioClienteSave(@ModelAttribute UsuarioCliente usuarioCliente) {

        usuarioClienteRepository.insertarUsuarioCliente(usuarioCliente.getLogin(), usuarioCliente.getPassword_cliente(), 
                                                        usuarioCliente.getId());
        
        return "redirect:/usuariosClientes";
    }

    @GetMapping("/usuariosClientes/{id}/edit")
    public String usuarioClienteEditForm(@PathVariable("id") int id, Model model) {
        UsuarioCliente usuarioCliente = usuarioClienteRepository.darUsuarioCliente(id);
        if (usuarioCliente != null) {
            model.addAttribute("usuarioCliente", usuarioCliente);
            return "usuarioClienteEdit";
        } else {
            return "redirect:/usuariosClientes";
        }
    }

    @PostMapping("/usuariosClientes/{id}/save")
    public String usuarioClienteEditSave(@PathVariable("id") long id, @ModelAttribute UsuarioCliente usuarioCliente) {
        usuarioClienteRepository.insertarUsuarioCliente(usuarioCliente.getLogin(), usuarioCliente.getPassword_cliente(),
                                                        usuarioCliente.getId());
        return "redirect:/usuariosClientes";
    }

    @GetMapping("/usuariosClientes/{id}/delete")
    public String usuarioClienteDelete(@PathVariable("id") long id) {
        usuarioClienteRepository.eliminarUsuarioCliente(id);
        return "redirect:/usuariosClientes";
    }
    
    
    

     
    
}
