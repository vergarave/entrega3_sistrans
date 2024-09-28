package uniandes.edu.co.proyecto.controller;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.modelo.OrdenDeCompra;
import uniandes.edu.co.proyecto.repositorio.OrdenDeCompraRepository;

@RestController
public class OrdenDeCompraController {

    @Autowired
    private OrdenDeCompraRepository ordenDeCompraRepository;

    // REVISAAAAR XD ESTE ES EL RF7
    @PostMapping("/ordenesDeCompra/new/save")
    public ResponseEntity<String> ordenDeCompraGuardar(@RequestBody OrdenDeCompra ordenDeCompra) {
        try {
            ordenDeCompraRepository.insertarOrdenDeCompra(
                ordenDeCompra.getFechaEntrega(),
                "VIGENTE",
                LocalDate.now(),
                ordenDeCompra.getIdSucursal().getId(),
                ordenDeCompra.getNitProveedor().getNit()
            );
            return new ResponseEntity<>("Orden de compra creada exitosamente", HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al crear la orden de compra", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // REVISAAAAR XD ESTE ES EL RF8
    @PostMapping("/ordenesDeCompra/{numero}/edit/save")
    public ResponseEntity<String> ordenDeCompraEditarGuardar(@PathVariable Integer numero) {
        OrdenDeCompra orden = ordenDeCompraRepository.darOrdenDeCompra(numero);
        if (orden != null && "VIGENTE".equals(orden.getEstado())) {
            ordenDeCompraRepository.actualizarEstadoOrdenDeCompra(numero, "ANULADA");
            return new ResponseEntity<>("Orden de compra anulada exitosamente", HttpStatus.OK);
        } else if (orden != null && "ENTREGADA".equals(orden.getEstado())) {
            return new ResponseEntity<>("No se puede anular una orden de compra entregada", HttpStatus.BAD_REQUEST);
        } else if (orden != null && "ANULADA".equals(orden.getEstado())) {
            return new ResponseEntity<>("La orden de compra ya se encuentra anulada", HttpStatus.BAD_REQUEST);
        }
        else {
            return new ResponseEntity<>("Orden de compra no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    // Este si debe estar bien pero no sé, revisen pliss, es el RF9
    @GetMapping("/ordenesDeCompra")
    public Collection<OrdenDeCompra> ordenesDeCompra() {
        return ordenDeCompraRepository.darOrdenesDeCompra();
    }
}
