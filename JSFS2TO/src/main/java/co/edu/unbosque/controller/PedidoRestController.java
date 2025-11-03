package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Pedido;
import co.edu.unbosque.service.api.PedidoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Pedido")
public class PedidoRestController {

    @Autowired
    private PedidoServiceAPI PedidoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Pedido> getAll() {
        return PedidoServiceAPI.getAll();
    }

    @PostMapping(value = "/savePedido")
    public ResponseEntity<Pedido> save(@RequestBody Pedido Pedido) {
        Pedido obj = PedidoServiceAPI.save(Pedido);
        return new ResponseEntity<Pedido>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Pedido> getPedidoById(@PathVariable Long id) throws ResourceNotFoundException {
        Pedido Pedido = PedidoServiceAPI.get(id);
        if (Pedido == null) {
            throw new ResourceNotFoundException("Record not found for <Pedido>" + id);
        }
        return ResponseEntity.ok().body(Pedido);
    }

    @DeleteMapping(value = "/deletePedido/{id}")
    public ResponseEntity<Pedido> delete(@PathVariable Long id) {
        Pedido Pedido = PedidoServiceAPI.get(id);
        if (Pedido != null) {
            PedidoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Pedido>(Pedido, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Pedido>(Pedido, HttpStatus.OK);
    }
}