package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.DetalleFactura;
import co.edu.unbosque.entity.DetalleFacturaId;

@Repository
public interface DetalleFacturaRepository extends CrudRepository<DetalleFactura, DetalleFacturaId> {
}