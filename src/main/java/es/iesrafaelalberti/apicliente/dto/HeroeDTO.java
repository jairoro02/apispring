package es.iesrafaelalberti.apicliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import es.iesrafaelalberti.apicliente.models.Universe;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroeDTO implements Serializable {

    private Long id;

    private String universe;

    private String name;

    private String descripcion;

    private String sexo;

    private String image;

    private List<Favorito> favoritos = new ArrayList<>();

    public HeroeDTO(Heroe heroe){
        this.id = heroe.getId();
        this.universe = heroe.getUniverse().getName();
        this.name = heroe.getName();
        this.descripcion = heroe.getDescripcion();
        this.sexo = heroe.getSexo();
        this.image = heroe.getImage();
        favoritos.addAll(heroe.getFavoritos());
    }
}
