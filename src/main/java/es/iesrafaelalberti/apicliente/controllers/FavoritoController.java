package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.models.Favorito;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.repositories.FavoritosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class FavoritoController {

    @Autowired
    FavoritosRepository favoritosRepository;

    @GetMapping("/favorites/")
    public ResponseEntity<Object> index(){return new ResponseEntity<>(favoritosRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/favorites/{id}/")
    public ResponseEntity<Object>show(@PathVariable("id") Long id){
        return new ResponseEntity<>(favoritosRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/favorites/create/")
    public ResponseEntity<Object> create(@RequestBody Favorito favorite){
        favoritosRepository.save(favorite);
        return new ResponseEntity<>(favorite, HttpStatus.OK);
    }

    @DeleteMapping("/favorites/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Favorito> favorite =favoritosRepository.findById(id);
        favorite.ifPresent(value -> favoritosRepository.delete(value));
        return new ResponseEntity<>(favorite.isPresent(),HttpStatus.OK);
    }

}
