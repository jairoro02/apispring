package es.iesrafaelalberti.apicliente.controllers;


import es.iesrafaelalberti.apicliente.dto.EventoDTO;
import es.iesrafaelalberti.apicliente.models.Evento;
import es.iesrafaelalberti.apicliente.models.Person;
import es.iesrafaelalberti.apicliente.repositories.EventoRepository;
import es.iesrafaelalberti.apicliente.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class EventoController {

    @Autowired
    EventoRepository eventoRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/eventos/")
    public ResponseEntity<Object> index() {
        List<Evento> eventos = (List<Evento>) eventoRepository.findAll();
        return new ResponseEntity<>(eventos, HttpStatus.OK);
    }

    @GetMapping("/eventos/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        return evento.<ResponseEntity<Object>>map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>("Evento no encontrado", HttpStatus.NOT_FOUND));
    }


    @PostMapping("/eventos/create/")
    public ResponseEntity<Object> create(@RequestBody EventoDTO eventoDTO) {
        String nombreEvento = eventoDTO.getNombreEvento();
        String creador = eventoDTO.getCreador();

        Evento evento = new Evento();
        evento.setNombreEvento(nombreEvento);
        evento.setCreador(creador);

        eventoRepository.save(evento);

        return new ResponseEntity<>(evento, HttpStatus.OK);
    }
    @DeleteMapping("/eventos/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
        Optional<Evento> evento = eventoRepository.findById(id);
        if (evento.isPresent()) {
            eventoRepository.delete(evento.get());
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/eventos/{id}/add-participant/")
    public ResponseEntity<Object> addParticipant(@PathVariable("id") Long id, @RequestBody Map<String, String> requestBody) {
        Optional<Evento> evento = eventoRepository.findById(id);
        String personUsername = requestBody.get("personUsername");
        Optional<Person> person = Optional.ofNullable(personRepository.findByUsername(personUsername));

        if (evento.isPresent() && person.isPresent()) {
            evento.get().getParticipantes().add(person.get());
            eventoRepository.save(evento.get());
            return new ResponseEntity<>(evento.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Evento o persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/eventos/{id}/remove-participant/")
    public ResponseEntity<Object> removeParticipant(@PathVariable("id") Long id, @RequestBody Long personId) {
        Optional<Evento> evento = eventoRepository.findById(id);
        Optional<Person> person = personRepository.findById(personId);

        if (evento.isPresent() && person.isPresent()) {
            evento.get().getParticipantes().remove(person.get());
            eventoRepository.save(evento.get());
            return new ResponseEntity<>(evento.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Evento o persona no encontrada", HttpStatus.NOT_FOUND);
        }
    }
}
