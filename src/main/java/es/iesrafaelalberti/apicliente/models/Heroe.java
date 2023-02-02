package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @ManyToOne
    @JoinColumn()
    private Universe universe;

    private Date fecha_creacion;

    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;

    @JsonBackReference
    @OneToMany(mappedBy = "enemigo",cascade = CascadeType.ALL)
    private Set<Villano> villanos = new HashSet<>();


    public Heroe(){

    }

    public Heroe(Date fecha_creacion, String name, String descripcion, Integer edad, String sexo, String image, Set<Villano> villanos) {
        this.fecha_creacion = fecha_creacion;
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
        this.villanos = villanos;
    }
}
