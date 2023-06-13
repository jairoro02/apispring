package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.iesrafaelalberti.apicliente.dto.HeroeCreateDTO;
import es.iesrafaelalberti.apicliente.dto.HeroeDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

import java.io.File;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
@NoArgsConstructor
public class Heroe {

    @GeneratedValue
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn()
    private Universe universe;


    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;


    @OneToMany(mappedBy = "heroe",cascade = CascadeType.ALL)
    private Set<Villano> villanos = new HashSet<>();


    @OneToMany(mappedBy = "heroe",cascade = CascadeType.ALL)
    private Set<Favorito> favoritos = new HashSet<>();


    public Heroe(Universe universe, String name, String descripcion, Integer edad, String sexo, String image) {
        this.universe = universe;
        this.name = name;
        this.descripcion = descripcion;
        this.edad = edad;
        this.sexo = sexo;
        this.image = image;
    }

    public Heroe(HeroeCreateDTO heroe){
        this.name = heroe.getName();
        this.descripcion = heroe.getDescripcion();
        this.edad = heroe.getEdad();
        this.sexo = heroe.getSexo();
        this.image = heroe.getImage();
    }
}
