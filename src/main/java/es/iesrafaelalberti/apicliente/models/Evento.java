package es.iesrafaelalberti.apicliente.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "evento")
public class Evento {
    @GeneratedValue
    @Id
    private Long id;

    @Column(nullable = false)
    private String nombreEvento;

    @Column(nullable = false)
    private String creador;

    @ManyToMany
    private Set<Person> participantes = new HashSet<>();
}
