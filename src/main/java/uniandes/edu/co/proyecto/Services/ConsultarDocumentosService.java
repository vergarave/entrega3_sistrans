package uniandes.edu.co.proyecto.Services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import uniandes.edu.co.proyecto.modelo.Documento;
import uniandes.edu.co.proyecto.repositorio.DocumentoRepository;

@Service
public class ConsultarDocumentosService {

    @Autowired
    private DocumentoRepository documentoRepository;

    /**
     * RFC6: Consultar los documentos (Serializable)
     *
     * @return ResponseEntity<?> Resultado de la transaccion
     * @throws Exception
     */
    @Transactional(isolation = Isolation.SERIALIZABLE, timeout = 30)
    public ResponseEntity<?> consultarDocumentos_serializable() throws Exception{
        Collection<Documento> response = documentoRepository.getAll();
        return ResponseEntity.ok(response);
    }

    /**
     * RFC7: Consultar los documentos (Read Commited)
     *
     * @return ResponseEntity<?> Resultado de la transaccion
     * @throws Exception
     */
    @Transactional(isolation = Isolation.READ_COMMITTED, timeout = 30)
    public ResponseEntity<?> consultarDocumentos_read_commited() throws Exception{
        Collection<Documento> response = documentoRepository.getAll();
        return ResponseEntity.ok(response);
    }

}
