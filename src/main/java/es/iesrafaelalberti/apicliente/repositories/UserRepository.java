package es.iesrafaelalberti.apicliente.repositories;

import es.iesrafaelalberti.apicliente.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
