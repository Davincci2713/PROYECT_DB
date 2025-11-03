package co.edu.unbosque.controller;

import co.edu.unbosque.entity.Producto;
import co.edu.unbosque.service.api.ProductoServiceAPI;
import co.edu.unbosque.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/Producto")
public class ProductoRestController {

    @Autowired
    private ProductoServiceAPI ProductoServiceAPI;

    @GetMapping(value = "/getAll")
    public List<Producto> getAll() {
        return ProductoServiceAPI.getAll();
    }

    @PostMapping(value = "/saveProducto")
    public ResponseEntity<Producto> save(@RequestBody Producto Producto) {
        Producto obj = ProductoServiceAPI.save(Producto);
        return new ResponseEntity<Producto>(obj, HttpStatus.OK);
    }

    @GetMapping(value = "/findRecord/{id}")
    public ResponseEntity<Producto> getProductoById(@PathVariable Long id) throws ResourceNotFoundException {
        Producto Producto = ProductoServiceAPI.get(id);
        if (Producto == null) {
            throw new ResourceNotFoundException("Record not found for <Producto>" + id);
        }
        return ResponseEntity.ok().body(Producto);
    }

    @DeleteMapping(value = "/deleteProducto/{id}")
    public ResponseEntity<Producto> delete(@PathVariable Long id) {
        Producto Producto = ProductoServiceAPI.get(id);
        if (Producto != null) {
            ProductoServiceAPI.delete(id);
        } else {
            return new ResponseEntity<Producto>(Producto, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<Producto>(Producto, HttpStatus.OK);
    }
}