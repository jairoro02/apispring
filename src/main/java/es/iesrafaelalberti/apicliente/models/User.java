package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity @Getter @Setter
public class User {
    @GeneratedValue
    @Id
    private Long id;

    private String name;

    private String username;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private Set<Favorito> favoritos = new HashSet<>();
}
