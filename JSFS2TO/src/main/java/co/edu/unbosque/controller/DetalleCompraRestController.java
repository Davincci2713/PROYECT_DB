package co.edu.unbosque.controller;

import co.edu.unbosque.entity.DetalleCompra;
import co.edu.unbosque.entity.DetalleCompraId;
import co.edu.unbosque.service.api.DetalleCompraServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detalle-compra")
public class DetalleCompraRestController {

    @Autowired
    private DetalleCompraServiceAPI detalleCompraServiceAPI;

    @GetMapping(value = "/getAll")
    public List<DetalleCompra> getAll() {
        return detalleCompraServiceAPI.getAll();
    }

    @PostMapping(value = "/saveDetalleCompra")
    public ResponseEntity<DetalleCompra> save(@RequestBody DetalleCompra detalleCompra) {
        DetalleCompra obj = detalleCompraServiceAPI.save(detalleCompra);
        return new ResponseEntity<DetalleCompra>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{compraId}/{productoId}")
    public ResponseEntity<DetalleCompra> getDetalleCompraById(
            @PathVariable Long compraId, 
            @PathVariable Long productoId) throws ResourceNotFoundException {
        
        DetalleCompraId id = new DetalleCompraId(compraId, productoId);
        DetalleCompra detalleCompra = detalleCompraServiceAPI.get(id);
        if (detalleCompra == null) {
            throw new ResourceNotFoundException("Record not found for <DetalleCompra> with compraId: " + compraId + " and productoId: " + productoId);
        }
        return ResponseEntity.ok().body(detalleCompra);
    }

    @DeleteMapping(value = "/deleteDetalleCompra/{compraId}/{productoId}")
    public ResponseEntity<DetalleCompra> delete(
            @PathVariable Long compraId, 
            @PathVariable Long productoId) {
        
        DetalleCompraId id = new DetalleCompraId(compraId, productoId);
        DetalleCompra detalleCompra = detalleCompraServiceAPI.get(id);
        if (detalleCompra != null) {
            detalleCompraServiceAPI.delete(id);
        } else {
            return new ResponseEntity<DetalleCompra>(detalleCompra, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DetalleCompra>(detalleCompra, HttpStatus.OK);
    }
}