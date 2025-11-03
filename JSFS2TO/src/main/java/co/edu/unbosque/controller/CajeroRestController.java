package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Cajero;
import co.edu.unbosque.service.api.CajeroServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Cajero")
public class CajeroRestController {

    @Autowired
    private CajeroServiceAPI CajeroServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Cajero> getAll() {
        return CajeroServiceAPI.getAll();
    }

    @PostMapping(value = "/saveCajero")
    public ResponseEntity<Cajero> save(@RequestBody Cajero Cajero) {
        Cajero obj = CajeroServiceAPI.save(Cajero);
        return new ResponseEntity<Cajero>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Cajero> getCajeroById(@PathVariable Long id) throws ResourceNotFoundException {
        Cajero Cajero = CajeroServiceAPI.get(id);
        if (Cajero == null) {
            throw new ResourceNotFoundException("Record not found for <Cajero>" + id);
        }
        return ResponseEntity.ok().body(Cajero);
    }

    @DeleteMapping(value = "/deleteCajero/{id}")
    public ResponseEntity<Cajero> delete(@PathVariable Long id) {
        Cajero Cajero = CajeroServiceAPI.get(id);
        if (Cajero != null) {
            CajeroServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Cajero>(Cajero, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Cajero>(Cajero, HttpStatus.OK);
    }
}