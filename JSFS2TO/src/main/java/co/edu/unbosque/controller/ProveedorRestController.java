package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Proveedor;
import co.edu.unbosque.service.api.ProveedorServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Proveedor")
public class ProveedorRestController {

    @Autowired
    private ProveedorServiceAPI ProveedorServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Proveedor> getAll() {
        return ProveedorServiceAPI.getAll();
    }

    @PostMapping(value = "/saveProveedor")
    public ResponseEntity<Proveedor> save(@RequestBody Proveedor Proveedor) {
        Proveedor obj = ProveedorServiceAPI.save(Proveedor);
        return new ResponseEntity<Proveedor>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Proveedor> getProveedorById(@PathVariable Long id) throws ResourceNotFoundException {
        Proveedor Proveedor = ProveedorServiceAPI.get(id);
        if (Proveedor == null) {
            throw new ResourceNotFoundException("Record not found for <Proveedor>" + id);
        }
        return ResponseEntity.ok().body(Proveedor);
    }

    @DeleteMapping(value = "/deleteProveedor/{id}")
    public ResponseEntity<Proveedor> delete(@PathVariable Long id) {
        Proveedor Proveedor = ProveedorServiceAPI.get(id);
        if (Proveedor != null) {
            ProveedorServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Proveedor>(Proveedor, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Proveedor>(Proveedor, HttpStatus.OK);
    }
}