package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Alimento;
import co.edu.unbosque.service.api.AlimentoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Alimento")
public class AlimentoRestController {

    @Autowired
    private AlimentoServiceAPI AlimentoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Alimento> getAll() {
        return AlimentoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveAlimento")
    public ResponseEntity<Alimento> save(@RequestBody Alimento Alimento) {
        Alimento obj = AlimentoServiceAPI.save(Alimento);
        return new ResponseEntity<Alimento>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Alimento> getAlimentoById(@PathVariable Long id) throws ResourceNotFoundException {
        Alimento alimento = AlimentoServiceAPI.get(id);
        if (alimento == null) {
            throw new ResourceNotFoundException("Record not found for <Alimento>" + id);
        }
        return ResponseEntity.ok().body(alimento);
    }

    @DeleteMapping(value = "/deleteAlimento/{id}")
    public ResponseEntity<Alimento> delete(@PathVariable Long id) {
        Alimento alimento = AlimentoServiceAPI.get(id);
        if (alimento != null) {
            AlimentoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Alimento>(alimento, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Alimento>(alimento, HttpStatus.OK);
    }
}