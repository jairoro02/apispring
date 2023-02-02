package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

}
