package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter @NoArgsConstructor
public class FavoritoCreateDTO implements Serializable {

    private Long id;

    private Person person;

    private Heroe heroe;


    public FavoritoCreateDTO(Long id, Person person, Heroe heroe) {
        this.id = id;
        this.person = person;
        this.heroe = heroe;
    }
}
