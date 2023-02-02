package es.iesrafaelalberti.apicliente.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter
public class Villano {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Universe universe;

    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;

    @ManyToOne
    @JoinColumn()
    private Heroe heroe;

    public Villano(){}

    public Villano(String name, String descripcion, Integer edad, String sexo, String image, Heroe heroe) {
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
        this.heroe = heroe;
    }

    //@ManyToOne
}
