package uniandes.edu.co.proyecto.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.zaxxer.hikari.util.IsolationLevel;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.Services.ConsultarDocumentosService;
import uniandes.edu.co.proyecto.repositorio.DocumentoRepository;


@RestController
public class DocumentoController {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private ConsultarDocumentosService consultarDocumentosService;

    @GetMapping("/documentos/SERIALIZABLE")
    public ResponseEntity<?> getDocumentos() {
        try {
            return consultarDocumentosService.consultarDocumentos(IsolationLevel.TRANSACTION_SERIALIZABLE);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not_ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/documentos/READ_COMMITED")
    public ResponseEntity<?> getDocumentos_rc() {
        try {
            return consultarDocumentosService.consultarDocumentos(IsolationLevel.TRANSACTION_READ_COMMITTED);
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not_ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/documentos/{isolation_level}")
    public ResponseEntity<?> getMethodName(@RequestParam String isolation_level) {
        try {
            if(isolation_level.equals("SERIALIZABLE")){
                return consultarDocumentosService.consultarDocumentos_serializable();
            }else if(isolation_level.equals("READ_COMMITED")){
                return consultarDocumentosService.consultarDocumentos_read_commited();
            }else{
                throw new Exception("isolation level incorrecto o no implementado");
            }
        } catch (Exception e) {
            Map<String,Object> response = MS.response("not_ok","create",e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
