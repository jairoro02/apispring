package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Villano {

    @Id
    @GeneratedValue
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn()
    private Universe universe;

    private String enemigo;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;

    @ManyToOne
    @JoinColumn()
    private Heroe heroe;

    public Villano(){}

    public Villano(Universe universe,String enemigo, String descripcion, Integer edad, String sexo, String image, Heroe heroe) {
        this.universe = universe;
        this.enemigo = enemigo;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
        this.heroe = heroe;
    }

    //@ManyToOne
}
