package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Persona;
import co.edu.unbosque.service.api.PersonaServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/persona")
public class PersonaRestController {

    @Autowired
    private PersonaServiceAPI personaServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Persona> getAll() {
        return personaServiceAPI.getAll();
    }

    @PostMapping(value = "/savePersona")
    public ResponseEntity<Persona> save(@RequestBody Persona persona) {
        Persona obj = personaServiceAPI.save(persona);
        return new ResponseEntity<Persona>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Persona> getPersonaById(@PathVariable Long id) throws ResourceNotFoundException {
        Persona persona = personaServiceAPI.get(id);
        if (persona == null) {
            throw new ResourceNotFoundException("Record not found for <Persona>" + id);
        }
        return ResponseEntity.ok().body(persona);
    }

    @DeleteMapping(value = "/deletePersona/{id}")
    public ResponseEntity<Persona> delete(@PathVariable Long id) {
        Persona persona = personaServiceAPI.get(id);
        if (persona != null) {
            personaServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Persona>(persona, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Persona>(persona, HttpStatus.OK);
    }
}