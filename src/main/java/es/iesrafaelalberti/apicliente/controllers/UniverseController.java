package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.dto.UniverseDTO;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Villano;
import es.iesrafaelalberti.apicliente.repositories.UniverseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import es.iesrafaelalberti.apicliente.models.Universe;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UniverseController {

    @Autowired
    UniverseRepository universeRepository;

    @GetMapping("/universes/")
    public ResponseEntity<Object> index(){
        List<UniverseDTO> resultado = new ArrayList<>();
        for(Universe universe:universeRepository.findAll()) {
            resultado.add(new UniverseDTO(universe));
        }
        return new ResponseEntity<>(resultado, HttpStatus.OK);}

    @GetMapping("/universes/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(new UniverseDTO(universeRepository.findById(id).get()),HttpStatus.OK);
    }

    @PostMapping("/universes/create/")
    public ResponseEntity<Object> create(@RequestBody Universe universe){
        universeRepository.save(universe);
        return new ResponseEntity<>(universe, HttpStatus.OK);
    }

    @DeleteMapping("/universes/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Universe> universe =universeRepository.findById(id);
        universe.ifPresent(value -> universeRepository.delete(value));
        return new ResponseEntity<>(universe.isPresent(),HttpStatus.OK);
    }

    @PutMapping("/universes/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Universe nuevouniverse){
        Optional<Universe> universe =universeRepository.findById(id);
        if(universe.isPresent()){
            nuevouniverse.setId(id);
            universeRepository.save(nuevouniverse);
            return new ResponseEntity<>(nuevouniverse,HttpStatus.OK);


        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
