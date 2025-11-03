package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.DetalleCompra;
import co.edu.unbosque.entity.DetalleCompraId;

@Repository
public interface DetalleCompraRepository extends CrudRepository<DetalleCompra, DetalleCompraId> {
}