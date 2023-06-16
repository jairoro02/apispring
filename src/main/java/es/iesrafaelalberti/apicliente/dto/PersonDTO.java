package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO {

    private Long id;

    private String username;

    private String email;

    private String password;

    private List<FavDTO> favoritos = new ArrayList<>();

    public PersonDTO(Person person){
        this.id = person.getId();
        this.username = person.getUsername();
        this.email = person.getEmail();
        this.password = person.getPassword();
        for(Favorito favorito: person.getFavoritos())
            favoritos.add(new FavDTO(favorito));
    }
}
