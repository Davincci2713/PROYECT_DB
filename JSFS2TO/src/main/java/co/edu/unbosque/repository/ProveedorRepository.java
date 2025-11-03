package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Proveedor;

@Repository
public interface ProveedorRepository extends CrudRepository<Proveedor, Long> {
}