package es.iesrafaelalberti.apicliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import jakarta.persistence.CascadeType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter @Setter
@NoArgsConstructor
public class UniverseDTO implements Serializable {

    private Long id;

    private String name;

    private List<Long> villanos = new ArrayList<>();

    private List<HeroeDTO> heroes = new ArrayList<>();

    public UniverseDTO(Universe universe) {
        this.id = universe.getId();
        this.name = universe.getName();
        for(Villano villano: universe.getVillanos())
            villanos.add(villano.getId());
        for(Heroe heroe: universe.getHeroes())
            heroes.add(new HeroeDTO(heroe));
    }
}
