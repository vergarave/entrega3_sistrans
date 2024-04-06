package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import uniandes.edu.co.proyecto.modelo.OperacionPrestamo;
import uniandes.edu.co.proyecto.modelo.Prestamo;
import uniandes.edu.co.proyecto.modelo.TransaccionPrestamo;
import uniandes.edu.co.proyecto.modelo.TransaccionPrestamoPK;
import uniandes.edu.co.proyecto.repositorios.OperacionPrestamoRepository;
import uniandes.edu.co.proyecto.repositorios.PrestamoRepository;
import uniandes.edu.co.proyecto.repositorios.TransaccionPrestamoRepository;

@Controller
public class TransaccionesPrestamosController {

    @Autowired
    private TransaccionPrestamoRepository transaccionPrestamoRepository;

    @Autowired
    private OperacionPrestamoRepository operacionPrestamoRepository;

    @Autowired
    private PrestamoRepository prestamoRepository;

    @GetMapping("/transaccionesPrestamos")
    public String transaccionesPrestamos(Model model) {
        model.addAttribute("transaccionesPrestamos", transaccionPrestamoRepository.darTransaccionesPrestamos());
        return "transaccionesPrestamos";
    }

    @GetMapping("/transaccionesPrestamos/new")
    public String transaccionPrestamoForm(Model model) {
        model.addAttribute("operacionPrestamo", new OperacionPrestamo());
        model.addAttribute("prestamo", new Prestamo());
        return "transaccionesPrestamosNew";
    }

    @PostMapping("/transaccionesPrestamos/new/save")
    public String transaccionPrestamoSave(@ModelAttribute("id_operacion") int id_operacion, @ModelAttribute("id_prestamo") int id_prestamo) {

        OperacionPrestamo operacionPrestamo= operacionPrestamoRepository.darOperacionPrestamo(id_operacion);

        Prestamo prestamo= prestamoRepository.darPrestamo(id_prestamo);

        TransaccionPrestamoPK pk= new TransaccionPrestamoPK(operacionPrestamo,prestamo);

        TransaccionPrestamo transaccionPrestamo=new TransaccionPrestamo();
        transaccionPrestamo.setPk(pk);


        transaccionPrestamoRepository.insertarTransaccionPrestamo(transaccionPrestamo.getPk().getId_operacion().getId(),
                                                                    transaccionPrestamo.getPk().getId_prestamo().getId());
        
        return "redirect:/prestamos";
    }


    
}
