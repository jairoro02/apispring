package es.iesrafaelalberti.apicliente.repositories;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface HeroesRepository extends CrudRepository<Heroe, Long> {
    Heroe findById(long id);
}
