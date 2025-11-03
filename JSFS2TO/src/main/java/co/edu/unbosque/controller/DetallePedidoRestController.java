package co.edu.unbosque.controller;

import co.edu.unbosque.entity.DetallePedido;
import co.edu.unbosque.entity.DetallePedidoId;
import co.edu.unbosque.service.api.DetallePedidoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detalle-pedido")
public class DetallePedidoRestController {

    @Autowired
    private DetallePedidoServiceAPI detallePedidoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<DetallePedido> getAll() {
        return detallePedidoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveDetallePedido")
    public ResponseEntity<DetallePedido> save(@RequestBody DetallePedido detallePedido) {
        DetallePedido obj = detallePedidoServiceAPI.save(detallePedido);
        return new ResponseEntity<DetallePedido>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{pedidoId}/{productoId}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(
            @PathVariable Long pedidoId, 
            @PathVariable Long productoId) throws ResourceNotFoundException {
        
        DetallePedidoId id = new DetallePedidoId(pedidoId, productoId);
        DetallePedido detallePedido = detallePedidoServiceAPI.get(id);
        if (detallePedido == null) {
            throw new ResourceNotFoundException("Record not found for <DetallePedido> with pedidoId: " + pedidoId + " and productoId: " + productoId);
        }
        return ResponseEntity.ok().body(detallePedido);
    }

    @DeleteMapping(value = "/deleteDetallePedido/{pedidoId}/{productoId}")
    public ResponseEntity<DetallePedido> delete(
            @PathVariable Long pedidoId, 
            @PathVariable Long productoId) {
        
        DetallePedidoId id = new DetallePedidoId(pedidoId, productoId);
        DetallePedido detallePedido = detallePedidoServiceAPI.get(id);
        if (detallePedido != null) {
            detallePedidoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<DetallePedido>(detallePedido, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DetallePedido>(detallePedido, HttpStatus.OK);
    }
}