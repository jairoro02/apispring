package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.Villano;
import es.iesrafaelalberti.apicliente.repositories.VillanosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/villanos/create/")
    public ResponseEntity<Object> create(@RequestBody Villano villano){
        villanosRepository.save(villano);
        return new ResponseEntity<>(villano, HttpStatus.OK);
    }

    @PutMapping("/villanos/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Villano villano){
        Optional<Villano> villano1 = villanosRepository.findById(id);
        if(villano1.isPresent()){
            villano.setId(id);
            villanosRepository.save(villano);
            return new ResponseEntity<>(villano,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/heroes/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Villano> villano =villanosRepository.findById(id);
        villano.ifPresent(value -> villanosRepository.delete(value));
        return new ResponseEntity<>(villano.isPresent(),HttpStatus.OK);
    }


}
