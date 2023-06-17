package es.iesrafaelalberti.apicliente.repositories;

import es.iesrafaelalberti.apicliente.models.Evento;
import es.iesrafaelalberti.apicliente.models.Favorito;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository<Evento, Long> {
}
