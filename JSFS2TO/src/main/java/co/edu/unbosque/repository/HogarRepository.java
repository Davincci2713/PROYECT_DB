package co.edu.unbosque.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.unbosque.entity.Hogar;

@Repository
public interface HogarRepository extends CrudRepository<Hogar, Long> {
}