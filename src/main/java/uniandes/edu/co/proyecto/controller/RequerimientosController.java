package uniandes.edu.co.proyecto.controller;

import java.util.List;
import java.util.Date;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.format.annotation.DateTimeFormat;

import uniandes.edu.co.proyecto.repositorio.RequerimientosRepository;

@RestController
@RequestMapping("/requerimientos")
public class RequerimientosController {

    @Autowired
    private RequerimientosRepository requerimientosRepository;

    @GetMapping("/rfc1/{codigoServicio}")
    public ResponseEntity<List<Document>> consultarAgendaRFC1(@PathVariable String codigoServicio) {
        List<Document> resultado = requerimientosRepository.consultarAgendaRFC1(codigoServicio);
        return ResponseEntity.ok(resultado);
    }

    @GetMapping("/rfc2")
    public ResponseEntity<List<Document>> consultarServiciosMasSolicitadosRFC2(
        @RequestParam("inicio") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date inicio,
        @RequestParam("fin") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date fin) {

        List<Document> resultado = requerimientosRepository.consultarServiciosMasSolicitadosRFC2(inicio, fin);
        return ResponseEntity.ok(resultado);
    }

}
