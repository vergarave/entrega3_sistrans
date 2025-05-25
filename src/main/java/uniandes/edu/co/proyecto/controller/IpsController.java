package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import uniandes.edu.co.proyecto.modelo.Ips;
import uniandes.edu.co.proyecto.repositorio.IpsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/api/ips")
public class IpsController {
    
    @Autowired
    private IpsRepository ipsRepo;

    @GetMapping("path")
    public List<Ips> obtenerIps() {
        return ipsRepo.findAll();
    }
    
    @GetMapping("/{nit}")
    public Ips obtenerIpsPorNit(@PathVariable String nit) {
        return ipsRepo.findByNit(nit).orElse(null);
    }

    @PostMapping
    public Ips crearIps(@RequestBody Ips nuevoIps) {
        return ipsRepo.save(nuevoIps);
    }

    @PutMapping("/{nit}")
    public ResponseEntity<Ips> actualizarIps(@PathVariable String nit) {
        Optional<Ips> ipsViejo = ipsRepo.findById(nit);

        if (ipsViejo == null) {
            return ResponseEntity.notFound().build();
        } else {
            Ips ips = ipsViejo.get();
            ips.setNombre(ips.getNombre());
            ips.setDireccion(ips.getDireccion());
            ips.setTelefono(ips.getTelefono());
            ips.setServicios(ips.getServicios());
            return ResponseEntity.ok(ipsRepo.save(ips));
        }
        
    }
    
    
}
