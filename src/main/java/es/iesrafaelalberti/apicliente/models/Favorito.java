package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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
}
