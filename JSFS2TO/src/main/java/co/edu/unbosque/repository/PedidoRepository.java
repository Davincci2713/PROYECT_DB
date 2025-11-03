package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Pedido;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}