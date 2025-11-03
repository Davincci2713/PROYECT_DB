package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Cajero;

@Repository
public interface CajeroRepository extends CrudRepository<Cajero, Long> {
}