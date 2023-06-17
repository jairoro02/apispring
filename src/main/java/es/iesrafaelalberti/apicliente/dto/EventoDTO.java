package es.iesrafaelalberti.apicliente.dto;

import es.iesrafaelalberti.apicliente.models.Evento;
import es.iesrafaelalberti.apicliente.models.Person;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventoDTO implements Serializable {

    private String nombreEvento;
    private String creador;
    private List<String> participantes= new ArrayList<>();


    public EventoDTO(Evento evento){
        this.nombreEvento = evento.getNombreEvento();
        this.creador = evento.getCreador();
        this.participantes = evento.getParticipantes()
                .stream()
                .map(Person::getUsername)
                .collect(Collectors.toList());
    }
}
