package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Empleado;
import co.edu.unbosque.service.api.EmpleadoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Empleado")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoServiceAPI EmpleadoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Empleado> getAll() {
        return EmpleadoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveEmpleado")
    public ResponseEntity<Empleado> save(@RequestBody Empleado Empleado) {
        Empleado obj = EmpleadoServiceAPI.save(Empleado);
        return new ResponseEntity<Empleado>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Empleado> getEmpleadoById(@PathVariable Long id) throws ResourceNotFoundException {
        Empleado Empleado = EmpleadoServiceAPI.get(id);
        if (Empleado == null) {
            throw new ResourceNotFoundException("Record not found for <Empleado>" + id);
        }
        return ResponseEntity.ok().body(Empleado);
    }

    @DeleteMapping(value = "/deleteEmpleado/{id}")
    public ResponseEntity<Empleado> delete(@PathVariable Long id) {
        Empleado Empleado = EmpleadoServiceAPI.get(id);
        if (Empleado != null) {
            EmpleadoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Empleado>(Empleado, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Empleado>(Empleado, HttpStatus.OK);
    }
}