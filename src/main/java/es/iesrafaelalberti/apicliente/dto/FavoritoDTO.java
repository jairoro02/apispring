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

    private Long personId;
    private Long heroeId;


    public FavoritoDTO(Long personId, Long heroeId) {
        this.personId = personId;
        this.heroeId = heroeId;
    }
}
