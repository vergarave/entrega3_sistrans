package uniandes.edu.co.proyecto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.servicios.ConsultaDocumentosService;

@RestController
public class ConsultaDocumentosController {

    @Autowired
    private ConsultaDocumentosService consultaDocumentosService;

    //Cntrolador para RFC6 - Consulta con aislamiento SERIALIZABLE
    @GetMapping("/documentosIngresoSerializable/{idSucursal}/{idBodega}")
    public ResponseEntity<?> obtenerDocumentosIngresoSerializable(@PathVariable Long idSucursal,  @PathVariable Long idBodega) {
        return consultaDocumentosService.obtenerDocumentosIngresoSerializable(idSucursal, idBodega);
    }

    //Controlador para RFC7 - Consulta con aislamiento READ COMMITTED
    @GetMapping("/documentosIngresoReadCommitted/{idSucursal}/{idBodega}")
    public ResponseEntity<?> obtenerDocumentosIngresoReadCommitted(@PathVariable Long idSucursal, @PathVariable Long idBodega) {
        return consultaDocumentosService.obtenerDocumentosIngresoReadCommitted(idSucursal, idBodega);
    }
}
