package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Universe {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonIgnoreProperties({"universe" ,"heroes"})

    @OneToMany(mappedBy = "universe",cascade = CascadeType.ALL)
    private Set<Villano> villanos = new HashSet<>();

    @JsonIgnoreProperties( "universe")
    @OneToMany(mappedBy = "universe",cascade = CascadeType.ALL)
    private Set<Heroe> heroes = new HashSet<>();

    public Universe() {
    }

    public Universe(String name) {
        this.name = name;
    }

}
