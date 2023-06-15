package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
public class FavoritoDTO implements Serializable {

    private String person;
    private Heroe hero;

    public FavoritoDTO(Favorito favorito) {
        this.person = favorito.getPerson().getUsername();
        this.hero = favorito.getHeroe();
    }
}
