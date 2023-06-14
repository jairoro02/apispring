package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Villano;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VillanoDTO implements Serializable {

    private Long id;

    private String universe;

    private String name;

    private String descripcion;

    private String sexo;

    private String image;

    public VillanoDTO(Villano villano) {
        this.id = villano.getId();
        this.universe = villano.getUniverse().getName();
        this.name = villano.getName();
        this.descripcion = villano.getDescripcion();
        this.sexo = villano.getSexo();
        this.image = villano.getImage();
    }
}
