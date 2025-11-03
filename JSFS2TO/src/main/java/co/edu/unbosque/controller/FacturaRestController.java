package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Factura;
import co.edu.unbosque.service.api.FacturaServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Factura")
public class FacturaRestController {

    @Autowired
    private FacturaServiceAPI FacturaServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Factura> getAll() {
        return FacturaServiceAPI.getAll();
    }

    @PostMapping(value = "/saveFactura")
    public ResponseEntity<Factura> save(@RequestBody Factura Factura) {
        Factura obj = FacturaServiceAPI.save(Factura);
        return new ResponseEntity<Factura>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Factura> getFacturaById(@PathVariable Long id) throws ResourceNotFoundException {
        Factura Factura = FacturaServiceAPI.get(id);
        if (Factura == null) {
            throw new ResourceNotFoundException("Record not found for <Factura>" + id);
        }
        return ResponseEntity.ok().body(Factura);
    }

    @DeleteMapping(value = "/deleteFactura/{id}")
    public ResponseEntity<Factura> delete(@PathVariable Long id) {
        Factura Factura = FacturaServiceAPI.get(id);
        if (Factura != null) {
            FacturaServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Factura>(Factura, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Factura>(Factura, HttpStatus.OK);
    }
}