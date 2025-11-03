package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Hogar;
import co.edu.unbosque.service.api.HogarServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Hogar")
public class HogarRestController {

    @Autowired
    private HogarServiceAPI HogarServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Hogar> getAll() {
        return HogarServiceAPI.getAll();
    }

    @PostMapping(value = "/saveHogar")
    public ResponseEntity<Hogar> save(@RequestBody Hogar Hogar) {
        Hogar obj = HogarServiceAPI.save(Hogar);
        return new ResponseEntity<Hogar>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Hogar> getHogarById(@PathVariable Long id) throws ResourceNotFoundException {
        Hogar Hogar = HogarServiceAPI.get(id);
        if (Hogar == null) {
            throw new ResourceNotFoundException("Record not found for <Hogar>" + id);
        }
        return ResponseEntity.ok().body(Hogar);
    }

    @DeleteMapping(value = "/deleteHogar/{id}")
    public ResponseEntity<Hogar> delete(@PathVariable Long id) {
        Hogar Hogar = HogarServiceAPI.get(id);
        if (Hogar != null) {
            HogarServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Hogar>(Hogar, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Hogar>(Hogar, HttpStatus.OK);
    }
}