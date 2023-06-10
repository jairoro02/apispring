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

    @JsonIgnoreProperties({"heroes" ,"villanos"})
    @ManyToOne
    @JoinColumn()
    private Universe universe;

    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String image;

    @JsonIgnoreProperties("villanos")
    @ManyToOne
    @JoinColumn()
    private Heroe heroe;

    public Villano(){}

    public Villano(Universe universe,String name, String descripcion, Integer edad, String sexo, String image, Heroe heroe) {
        this.universe = universe;
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
        this.heroe = heroe;
    }

    //@ManyToOne
}
