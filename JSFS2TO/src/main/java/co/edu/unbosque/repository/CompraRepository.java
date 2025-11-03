package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Compra;

@Repository
public interface CompraRepository extends CrudRepository<Compra, Long> {
}