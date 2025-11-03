package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Compra;
import co.edu.unbosque.service.api.CompraServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Compra")
public class CompraRestController {

    @Autowired
    private CompraServiceAPI CompraServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Compra> getAll() {
        return CompraServiceAPI.getAll();
    }

    @PostMapping(value = "/saveCompra")
    public ResponseEntity<Compra> save(@RequestBody Compra Compra) {
        Compra obj = CompraServiceAPI.save(Compra);
        return new ResponseEntity<Compra>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable Long id) throws ResourceNotFoundException {
        Compra Compra = CompraServiceAPI.get(id);
        if (Compra == null) {
            throw new ResourceNotFoundException("Record not found for <Compra>" + id);
        }
        return ResponseEntity.ok().body(Compra);
    }

    @DeleteMapping(value = "/deleteCompra/{id}")
    public ResponseEntity<Compra> delete(@PathVariable Long id) {
        Compra Compra = CompraServiceAPI.get(id);
        if (Compra != null) {
            CompraServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Compra>(Compra, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Compra>(Compra, HttpStatus.OK);
    }
}