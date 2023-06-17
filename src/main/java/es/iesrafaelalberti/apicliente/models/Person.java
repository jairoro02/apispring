package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@Entity @Getter @Setter
@Table(name = "usercustom")
public class Person {


    @Column(nullable = false, unique = true)
    private String username;

    private String email;

    private String password;
    @JsonIgnoreProperties("participantes")
    @ManyToMany
    private Set<Evento> eventos = new HashSet<>();

    @Id
    @GeneratedValue
    private Long id;

    @JsonIgnoreProperties("person")
    @OneToMany(mappedBy = "person")
    private Set<Favorito> favoritos = new HashSet<>();


    public Person() {
    }

    public Person(String username,String email, String password) {
        this.username = username;
        this.email = email;
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
