package es.iesrafaelalberti.apicliente.repositories;

import es.iesrafaelalberti.apicliente.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {
    Person findByUsername(String username);
}
