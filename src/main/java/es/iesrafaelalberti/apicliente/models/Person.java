package es.iesrafaelalberti.apicliente.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
public class Person {


    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany(mappedBy = "person")
    private Set<Favorito> favoritos = new HashSet<>();


    public Person() {
    }

    public Person(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
