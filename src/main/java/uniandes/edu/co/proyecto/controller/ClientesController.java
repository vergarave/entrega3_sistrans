package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.Cliente;
import uniandes.edu.co.proyecto.modelo.UsuarioCliente;
import uniandes.edu.co.proyecto.repositorios.ClienteRepository;

@Controller
public class ClientesController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteRepository.darClientes());
        return "clientes";
    }

    @GetMapping("/clientes/new")
    public String clientesForm(Model model) {

        model.addAttribute("cliente", new Cliente());
        return "clienteNew";
    }

    @PostMapping("/clientes/new/save")
    public String clientesSave(@ModelAttribute Cliente cliente,Model model) {

        clienteRepository.insertarCliente(cliente.getNumero_documento(), cliente.getTipo(),
                cliente.getTipo_documento(), cliente.getNombre(),
                cliente.getNacionalidad(), cliente.getDireccion_fisica(),
                cliente.getDireccion_electronica(), cliente.getTelefono(),
                cliente.getCodigo_postal(), cliente.getCiudad(), cliente.getDepartamento());

        model.addAttribute("usuarioCliente", new UsuarioCliente());

        return "usuarioClienteNew";
    }

    @GetMapping("/clientes/{id}/edit")
    public String clienteEditForm(@PathVariable("id") int id, Model model) {
        Cliente cliente = clienteRepository.darCliente(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "clienteEdit";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/{id}/edit/save")
    public String clienteEditSave(@PathVariable("id") long id, @ModelAttribute Cliente cliente) {
        clienteRepository.actualizarCliente(((long) id), cliente.getNumero_documento(), cliente.getTipo(),
                cliente.getTipo_documento(), cliente.getNombre(),
                cliente.getNacionalidad(), cliente.getDireccion_fisica(),
                cliente.getDireccion_electronica(), cliente.getTelefono(),
                cliente.getCodigo_postal(), cliente.getCiudad(), cliente.getDepartamento());
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/{id}/delete")
    public String clienteBorrar(@PathVariable("id") long id) {
        clienteRepository.eliminarCliente(id);
        return "redirect:/clientes";
    }

}
