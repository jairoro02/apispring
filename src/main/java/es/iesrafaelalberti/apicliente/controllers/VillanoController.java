package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.models.Villano;
import es.iesrafaelalberti.apicliente.repositories.VillanosRepository;
import jakarta.persistence.ManyToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class VillanoController {

    @Autowired
    VillanosRepository villanosRepository;

    @GetMapping("/")
    public ResponseEntity<Object> index(){return new ResponseEntity<>(villanosRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/villanos/{id}/")
    public ResponseEntity<Object> show(@PathVariable("id") Long id){
        return new ResponseEntity<>(villanosRepository.findById(id),HttpStatus.OK);
    }

    @GetMapping("/villanos/create/")
    public ResponseEntity<Object> create(@RequestBody Villano villano){
        villanosRepository.save(villano);
        return new ResponseEntity<>(villano, HttpStatus.OK);
    }

    @PutMapping("/villanos/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id")  @RequestBody Villano villano){
        Optional<Villano> villano1 = villanosRepository.findById(id);

    }



}
