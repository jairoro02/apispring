package es.iesrafaelalberti.apicliente.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Universe;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroeDTO implements Serializable {

    private Long id;


    private Universe universe;


    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;


    public HeroeDTO(Heroe heroe){
        this.id = heroe.getId();
        this.universe = heroe.getUniverse();
        this.name = heroe.getName();
        this.descripcion = heroe.getDescripcion();
        this.edad = heroe.getEdad();
        this.sexo = heroe.getSexo();
        this.image = heroe.getImage();
    }
}
