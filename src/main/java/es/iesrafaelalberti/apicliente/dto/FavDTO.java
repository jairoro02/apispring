package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Favorito;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FavDTO implements Serializable {
    private Long id;
    private HeroeDTO heroe;


    public FavDTO(Favorito favorito){
        this.id = favorito.getId();
        this.heroe = new HeroeDTO(favorito.getHeroe());
    }

}
