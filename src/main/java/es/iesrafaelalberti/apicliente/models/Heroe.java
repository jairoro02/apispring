package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Heroe {

    @GeneratedValue
    @Id
    private Long id;

    @JsonIgnoreProperties({"heroes" ,"villanos"})
    @ManyToOne
    @JoinColumn()
    private Universe universe;

    private Date fecha_creacion;

    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;

    @JsonIgnoreProperties("heroe")
    @OneToMany(mappedBy = "heroe",cascade = CascadeType.ALL)
    private Set<Villano> villanos = new HashSet<>();


    public Heroe(){

    }

    public Heroe(Universe universe,Date fecha_creacion, String name, String descripcion, Integer edad, String sexo, String image) {
        this.universe = universe;
        this.fecha_creacion = fecha_creacion;
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
    }

}
