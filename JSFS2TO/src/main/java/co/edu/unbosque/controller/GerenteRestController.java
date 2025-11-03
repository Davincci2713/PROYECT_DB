package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Gerente;
import co.edu.unbosque.service.api.GerenteServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Gerente")
public class GerenteRestController {

    @Autowired
    private GerenteServiceAPI GerenteServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Gerente> getAll() {
        return GerenteServiceAPI.getAll();
    }

    @PostMapping(value = "/saveGerente")
    public ResponseEntity<Gerente> save(@RequestBody Gerente Gerente) {
        Gerente obj = GerenteServiceAPI.save(Gerente);
        return new ResponseEntity<Gerente>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Gerente> getGerenteById(@PathVariable Long id) throws ResourceNotFoundException {
        Gerente Gerente = GerenteServiceAPI.get(id);
        if (Gerente == null) {
            throw new ResourceNotFoundException("Record not found for <Gerente>" + id);
        }
        return ResponseEntity.ok().body(Gerente);
    }

    @DeleteMapping(value = "/deleteGerente/{id}")
    public ResponseEntity<Gerente> delete(@PathVariable Long id) {
        Gerente Gerente = GerenteServiceAPI.get(id);
        if (Gerente != null) {
            GerenteServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Gerente>(Gerente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Gerente>(Gerente, HttpStatus.OK);
    }
}