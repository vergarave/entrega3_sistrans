package uniandes.edu.co.proyecto.controller;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.stereotype.Controller;

import uniandes.edu.co.proyecto.modelo.DocumentoIngreso;
import uniandes.edu.co.proyecto.repositorio.DocumentoIngresoRepository;

@Controller
public class DocumentoIngresoController {

    @Autowired
    private DocumentoIngresoRepository documentoIngresoRepository;

    // Método para obtener todos los documentos de ingreso
    @GetMapping("/documentosIngreso")
    public Collection<DocumentoIngreso> obtenerTodosLosDocumentos() {
        return documentoIngresoRepository.obtenerTodosLosDocumentos();
    }

    @GetMapping("/documentosIngreso/formulario")
    public String obtenerdocs() {
        return "consultardocs";
    }

    // Método para obtener un documento de ingreso específico por su ID
    @GetMapping("/documentosIngreso/{id}")
    public ResponseEntity<DocumentoIngreso> obtenerDocumentoPorId(@PathVariable Long id) {
        DocumentoIngreso documento = documentoIngresoRepository.obtenerDocumentoPorId(id);
        if (documento != null) {
            return new ResponseEntity<>(documento, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Método para consultar documentos de ingreso por sucursal y bodega
    @GetMapping("/consultaDocumentosIngreso/{idSucursal}/{idBodega}")
    public ResponseEntity<?> consultarDocumentosIngreso(@PathVariable Long idSucursal, @PathVariable Long idBodega) {
        // Calcula la fecha límite para la consulta (hace 30 días)
        LocalDate fechaLimite = LocalDate.now().minusDays(30);
        
        // Llama al repositorio para obtener los documentos de ingreso
        Collection<Map<String, Object>> documentos = documentoIngresoRepository.obtenerDocumentosIngreso(idSucursal, idBodega, fechaLimite);

        // Verifica si se encontraron documentos
        if (!documentos.isEmpty()) {
            // Retorna la información de sucursal y bodega junto con los documentos
            Map<String, Object> resultado = Map.of(
                "nombre_sucursal", documentos.iterator().next().get("nombre_sucursal"),
                "nombre_bodega", documentos.iterator().next().get("nombre_bodega"),
                "documentos", documentos
            );
            return new ResponseEntity<>(resultado, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontraron documentos de ingreso en los últimos 30 días.", HttpStatus.OK);
        }
    }
}
