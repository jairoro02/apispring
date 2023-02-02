package es.iesrafaelalberti.apicliente.repositories;

import es.iesrafaelalberti.apicliente.models.Villano;
import org.springframework.data.repository.CrudRepository;

public interface VillanosRepository extends CrudRepository<Villano, Long> {
}
