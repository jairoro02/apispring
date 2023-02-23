package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class HeroeController {

    @Autowired
    HeroesRepository heroesRepository;

    @GetMapping("/heroes/")
        public ResponseEntity<Object> index(){return new ResponseEntity<>(heroesRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/heroes/{id}/")
    public ResponseEntity<Object>show(@PathVariable("id") Long id){
        return new ResponseEntity<>(heroesRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/heroes/create/")
    public ResponseEntity<Object> create(@RequestBody Heroe heroe){
        heroesRepository.save(heroe);
        return new ResponseEntity<>(heroe, HttpStatus.OK);
    }

    @DeleteMapping("/heroes/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Heroe> heroe =heroesRepository.findById(id);
        heroe.ifPresent(value -> heroesRepository.delete(value));
        return new ResponseEntity<>(heroe.isPresent(),HttpStatus.OK);
    }

    @PutMapping("/heroes/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Heroe nuevoheroe){
        Optional<Heroe> heroe = heroesRepository.findById(id);
        if(heroe.isPresent()){
            nuevoheroe.setId(id);
            heroesRepository.save(nuevoheroe);
            return new ResponseEntity<>(nuevoheroe,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
