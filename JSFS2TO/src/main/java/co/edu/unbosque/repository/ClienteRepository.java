package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
	
}