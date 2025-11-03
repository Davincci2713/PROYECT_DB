package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Gerente;

@Repository
public interface GerenteRepository extends CrudRepository<Gerente, Long> {
}