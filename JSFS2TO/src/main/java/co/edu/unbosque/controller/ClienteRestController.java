package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Cliente;
import co.edu.unbosque.service.api.ClienteServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Cliente")
public class ClienteRestController {

    @Autowired
    private ClienteServiceAPI ClienteServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Cliente> getAll() {
        return ClienteServiceAPI.getAll();
    }

    @PostMapping(value = "/saveCliente")
    public ResponseEntity<Cliente> save(@RequestBody Cliente Cliente) {
        Cliente obj = ClienteServiceAPI.save(Cliente);
        return new ResponseEntity<Cliente>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Long id) throws ResourceNotFoundException {
        Cliente Cliente = ClienteServiceAPI.get(id);
        if (Cliente == null) {
            throw new ResourceNotFoundException("Record not found for <Cliente>" + id);
        }
        return ResponseEntity.ok().body(Cliente);
    }

    @DeleteMapping(value = "/deleteCliente/{id}")
    public ResponseEntity<Cliente> delete(@PathVariable Long id) {
        Cliente Cliente = ClienteServiceAPI.get(id);
        if (Cliente != null) {
            ClienteServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Cliente>(Cliente, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Cliente>(Cliente, HttpStatus.OK);
    }
}