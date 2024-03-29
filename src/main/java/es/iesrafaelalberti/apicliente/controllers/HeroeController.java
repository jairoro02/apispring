package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.dto.HeroeCreateDTO;
import es.iesrafaelalberti.apicliente.dto.HeroeDTO;
import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.repositories.HeroesRepository;
import es.iesrafaelalberti.apicliente.services.HeroeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HeroeController {

    @Autowired
    HeroesRepository heroesRepository;

    @Autowired
    HeroeService heroeService;

    @GetMapping("/heroes/")
        public ResponseEntity<Object> index(){
        List<HeroeDTO> resultado = new ArrayList<>();
        for (Heroe heroe: heroesRepository.findAll())
            resultado.add(new HeroeDTO(heroe));
        return new ResponseEntity<>(resultado, HttpStatus.OK);}

    @GetMapping("/heroes/{id}/")
    public ResponseEntity<Object>show(@PathVariable("id") Long id){
        return new ResponseEntity<>(new HeroeDTO(heroesRepository.findById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/heroes/create/")
    public ResponseEntity<Object> create(@RequestBody HeroeCreateDTO heroe){
        return new ResponseEntity<>(
                new HeroeDTO(heroeService.herocreate(heroe)), HttpStatus.OK
        );
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
