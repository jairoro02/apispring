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
    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String username;


    @OneToMany(mappedBy = "user")
    private Set<Favorito> favoritos = new HashSet<>();


    public User() {
    }

    public User(String name, String username) {
        this.name = name;
        this.username = username;
    }
}
