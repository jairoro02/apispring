package es.iesrafaelalberti.apicliente.repositories;
import es.iesrafaelalberti.apicliente.models.Favorito;
import org.springframework.data.repository.CrudRepository;

public interface FavoritosRepository extends CrudRepository<Favorito,Long> {

}
