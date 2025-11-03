package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.DetallePedido;
import co.edu.unbosque.entity.DetallePedidoId;

@Repository
public interface DetallePedidoRepository extends CrudRepository<DetallePedido, DetallePedidoId> {
}