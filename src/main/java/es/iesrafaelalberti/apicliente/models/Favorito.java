package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.iesrafaelalberti.apicliente.dto.FavoritoCreateDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;

@Entity @Getter @Setter
public class Favorito {
    @GeneratedValue
    @Id

    private Long id;

    @JsonIgnoreProperties("favoritos")
    @ManyToOne
    @JoinColumn()
    private Person person;

    @JsonIgnoreProperties({"favoritos","villanos"})
    @ManyToOne
    @JoinColumn()
    private Heroe heroe;


    public Favorito() {
    }

    public Favorito(Person person, Heroe heroe) {
        this.person = person;
        this.heroe = heroe;
    }

    public Favorito(FavoritoCreateDTO favorito){
        this.person = favorito.getPerson();
        this.heroe = favorito.getHeroe();
    }
}
