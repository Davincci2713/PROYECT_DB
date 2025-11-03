package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Limpieza;

@Repository
public interface LimpiezaRepository extends CrudRepository<Limpieza, Long> {
}