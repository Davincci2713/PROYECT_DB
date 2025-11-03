package co.edu.unbosque.controller;

import co.edu.unbosque.entity.DetalleFactura;
import co.edu.unbosque.entity.DetalleFacturaId;
import co.edu.unbosque.service.api.DetalleFacturaServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/detalle-factura")
public class DetalleFacturaRestController {

    @Autowired
    private DetalleFacturaServiceAPI detalleFacturaServiceAPI;

    @GetMapping(value = "/getAll")
    public List<DetalleFactura> getAll() {
        return detalleFacturaServiceAPI.getAll();
    }

    @PostMapping(value = "/saveDetalleFactura")
    public ResponseEntity<DetalleFactura> save(@RequestBody DetalleFactura detalleFactura) {
        DetalleFactura obj = detalleFacturaServiceAPI.save(detalleFactura);
        return new ResponseEntity<DetalleFactura>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{facturaId}/{productoId}")
    public ResponseEntity<DetalleFactura> getDetalleFacturaById(
            @PathVariable Long facturaId, 
            @PathVariable Long productoId) throws ResourceNotFoundException {
        
        DetalleFacturaId id = new DetalleFacturaId(facturaId, productoId);
        DetalleFactura detalleFactura = detalleFacturaServiceAPI.get(id);
        if (detalleFactura == null) {
            throw new ResourceNotFoundException("Record not found for <DetalleFactura> with facturaId: " + facturaId + " and productoId: " + productoId);
        }
        return ResponseEntity.ok().body(detalleFactura);
    }

    @DeleteMapping(value = "/deleteDetalleFactura/{facturaId}/{productoId}")
    public ResponseEntity<DetalleFactura> delete(
            @PathVariable Long facturaId, 
            @PathVariable Long productoId) {
        
        DetalleFacturaId id = new DetalleFacturaId(facturaId, productoId);
        DetalleFactura detalleFactura = detalleFacturaServiceAPI.get(id);
        if (detalleFactura != null) {
            detalleFacturaServiceAPI.delete(id);
        } else {
            return new ResponseEntity<DetalleFactura>(detalleFactura, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<DetalleFactura>(detalleFactura, HttpStatus.OK);
    }
}