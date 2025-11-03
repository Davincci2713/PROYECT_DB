package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Factura;

@Repository
public interface FacturaRepository extends CrudRepository<Factura, Long> {
}