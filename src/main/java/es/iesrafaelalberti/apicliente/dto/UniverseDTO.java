package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import es.iesrafaelalberti.apicliente.models.Villano;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class UniverseDTO implements Serializable {

    private Long id;

    private String name;

    private List<VillanoDTO> villanos = new ArrayList<>();

    private List<HeroeDTO> heroes = new ArrayList<>();

    public UniverseDTO(Universe universe) {
        this.id = universe.getId();
        this.name = universe.getName();
        for(Villano villano: universe.getVillanos())
            villanos.add(new VillanoDTO(villano));
        for(Heroe heroe: universe.getHeroes())
            heroes.add(new HeroeDTO(heroe));
    }
}
