package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Limpieza;
import co.edu.unbosque.service.api.LimpiezaServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Limpieza")
public class LimpiezaRestController {

    @Autowired
    private LimpiezaServiceAPI LimpiezaServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Limpieza> getAll() {
        return LimpiezaServiceAPI.getAll();
    }

    @PostMapping(value = "/saveLimpieza")
    public ResponseEntity<Limpieza> save(@RequestBody Limpieza Limpieza) {
        Limpieza obj = LimpiezaServiceAPI.save(Limpieza);
        return new ResponseEntity<Limpieza>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Limpieza> getLimpiezaById(@PathVariable Long id) throws ResourceNotFoundException {
        Limpieza Limpieza = LimpiezaServiceAPI.get(id);
        if (Limpieza == null) {
            throw new ResourceNotFoundException("Record not found for <Limpieza>" + id);
        }
        return ResponseEntity.ok().body(Limpieza);
    }

    @DeleteMapping(value = "/deleteLimpieza/{id}")
    public ResponseEntity<Limpieza> delete(@PathVariable Long id) {
        Limpieza Limpieza = LimpiezaServiceAPI.get(id);
        if (Limpieza != null) {
            LimpiezaServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Limpieza>(Limpieza, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Limpieza>(Limpieza, HttpStatus.OK);
    }
}