package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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

    @JsonBackReference
    @OneToMany(mappedBy = "universo",cascade = CascadeType.ALL)
       private Set<Villano> villanos = new HashSet<>();

    @OneToMany(mappedBy = "universo",cascade = CascadeType.ALL)
    private Set<Heroe> heroes = new HashSet<>();




}
