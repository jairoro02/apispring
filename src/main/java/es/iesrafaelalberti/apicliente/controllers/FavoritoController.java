package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.dto.FavoritoCreateDTO;
import es.iesrafaelalberti.apicliente.dto.FavoritoDTO;
import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Person;
import es.iesrafaelalberti.apicliente.repositories.FavoritosRepository;
import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import es.iesrafaelalberti.apicliente.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FavoritoController {

    @Autowired
    FavoritosRepository favoritosRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    HeroesRepository heroesRepository;

    @GetMapping("/favorites/")
    public ResponseEntity<Object> index(){return new ResponseEntity<>(favoritosRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/favorites/{id}/")
    public ResponseEntity<Object>show(@PathVariable("id") Long id){
        return new ResponseEntity<>(favoritosRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/favorites/create/")
    public ResponseEntity<Object> create(@RequestBody FavoritoDTO favoritoDTO) throws ChangeSetPersister.NotFoundException {
        // Obtener los IDs del Person y el Heroe desde el DTO
        Long personId = favoritoDTO.getPersonId();
        Long heroeId = favoritoDTO.getHeroeId();

        // Buscar el Person y el Heroe en el repositorio (o realizar cualquier lógica adicional según tus necesidades)
        Person person = personRepository.findById(personId).orElseThrow(ChangeSetPersister.NotFoundException::new);
        Heroe heroe = heroesRepository.findById(heroeId).orElseThrow(ChangeSetPersister.NotFoundException::new);

        // Crear una nueva instancia de Favorito utilizando el Person y el Heroe encontrados
        Favorito favorito = new Favorito(person, heroe);

        // Guardar el Favorito en el repositorio
        favoritosRepository.save(favorito);

        return new ResponseEntity<>(favorito, HttpStatus.OK);
    }

    @DeleteMapping("/favorites/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Favorito> favorite =favoritosRepository.findById(id);
        favorite.ifPresent(value -> favoritosRepository.delete(value));
        return new ResponseEntity<>(favorite.isPresent(),HttpStatus.OK);
    }

}
