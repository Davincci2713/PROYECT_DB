package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long> {
}