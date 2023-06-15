package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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

    @Column(length = 1500)
    private String image;

    @Column(length = 1500)
    private String background_image;

    @ManyToOne
    @JoinColumn()
    private Heroe heroe;

    public Villano(){}

    public Villano(Universe universe,String name, String descripcion, Integer edad, String sexo, String image, String background_image, Heroe heroe) {
        this.universe = universe;
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
        this.background_image = background_image;
        this.heroe = heroe;
    }



    //@ManyToOne
}
