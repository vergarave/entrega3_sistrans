package uniandes.edu.co.proyecto.controller;

import java.util.Collection;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import uniandes.edu.co.proyecto.MS;
import uniandes.edu.co.proyecto.modelo.Contiene;
import uniandes.edu.co.proyecto.modelo.Orden_compra;
import uniandes.edu.co.proyecto.repositorio.ContieneRepository;
import uniandes.edu.co.proyecto.repositorio.DocumentoRepository;
import uniandes.edu.co.proyecto.repositorio.Orden_compraRepository;


@RestController
public class ContieneController {

    @Autowired
    private ContieneRepository contieneRepository;

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private Orden_compraRepository orden_compraRepository;

    private final TransactionTemplate transactionTemplate;

    public ContieneController(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
 
    }
    @PostMapping("/contiene/{id_bodega}/{id_orden_compra}/new/save")
    public ResponseEntity<?> registrarIngresoProductoEnBodegaDadaOrdenCompra(@PathVariable("id_bodega") Integer id_bodega, @PathVariable("id_orden_compra") Integer id_orden_compra) {
        Map<String, Object> response;

        try {
            transactionTemplate.execute(new TransactionCallbackWithoutResult() {
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    try {
                        // crea el documento con la orden de compra que está ingresando
                        documentoRepository.addDocumento(id_orden_compra);

                        //Obtiene los productos de la orden de compra
                        Collection<Integer> productos = orden_compraRepository.getProductos(id_orden_compra);

                        //Recorre todos los productos presentes en la orden de compra
                        for (Integer id_producto : productos){
                            Collection<Contiene> contiene_list = contieneRepository.getPorPK(id_bodega, id_producto);
                            if(contiene_list.isEmpty()){
                                //Si el producto aún no está en la bodega, se debe añadir
                                //por defecto, la cantidad máxima será de 3 veces la cantidad ingresada y la cantidad minima será de 1
                                contieneRepository.createFila(id_bodega, id_producto, id_orden_compra);
                            }else{
                                //Si el producto, ya está en la bodega, se actualizará la fila
                                contieneRepository.actualizarFila(id_bodega, id_producto, id_orden_compra);
                            }
                        //En este punto, ya se aniadieron los productos de la orden de compra a la bodega

                        //Actualizar orden de compra a entregada solo si está en vigente
                        Orden_compra orden = orden_compraRepository.darOrden_compra(id_orden_compra).iterator().next();
                        if(orden.getEstado().equals("vigente")){
                            orden_compraRepository.actualizarEstadoAEntregado(id_orden_compra);
                        }else{
                            if (orden.getEstado().equals("entregada"))
                                throw new Exception("La orden ya fue entregada");
                            if (orden.getEstado().equals("anulada"))
                                throw new Exception("La orden fue anulada");
                        }
                        
                        //Si se llega a este punto, todas las operaciones se hicieron correctamente
                        //Por lo que se hace commit

                        }
                    } catch (Exception e) {
                        status.setRollbackOnly(); // Hace rollback en caso de excepción
                        throw new RuntimeException("Error en la transacción: " + e.getMessage());
                    }
                }
            });

            response = MS.response("ok", "create", "ingreso de producto registrado correctamente");
            return ResponseEntity.ok(response);

        } catch (Exception e) {
            response = MS.response("not ok", "create", e.getMessage());
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
