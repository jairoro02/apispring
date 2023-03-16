package es.iesrafaelalberti.apicliente.dto;


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
public class HeroeCreateDTO implements Serializable {

    private Date fecha_creacion;

    private String name;

    private String descripcion;

    private Integer edad;

    private String sexo;

    private String image;
}
