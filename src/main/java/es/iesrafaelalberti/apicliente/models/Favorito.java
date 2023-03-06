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
    private User user;

    @ManyToOne
    @JoinColumn()
    private Heroe heroe;

}
