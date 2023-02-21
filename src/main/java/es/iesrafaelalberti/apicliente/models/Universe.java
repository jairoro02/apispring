package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Universe {

    @Id
    @GeneratedValue
    private Long id;

    private String name;


    @JsonManagedReference
    @OneToMany(mappedBy = "universe",cascade = CascadeType.ALL)
    private Set<Villano> villanos = new HashSet<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "universe",cascade = CascadeType.ALL)
    private Set<Heroe> heroes = new HashSet<>();

    public Universe() {
    }

    public Universe(String name) {
        this.name = name;
    }

}
