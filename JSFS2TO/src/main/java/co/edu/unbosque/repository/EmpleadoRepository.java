package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Empleado;

@Repository
public interface EmpleadoRepository extends CrudRepository<Empleado, Long> {
}