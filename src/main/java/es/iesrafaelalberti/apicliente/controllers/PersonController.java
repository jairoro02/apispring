package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.dto.FavDTO;
import es.iesrafaelalberti.apicliente.dto.PersonDTO;
import es.iesrafaelalberti.apicliente.models.Person;
import es.iesrafaelalberti.apicliente.repositories.PersonRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PersonController {

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/users/")
    public ResponseEntity<Object> index(){return new ResponseEntity<>(personRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/users/{username}/")
    public ResponseEntity<Object> show(@PathVariable("username") String username) {
        Optional<Person> personOptional = Optional.ofNullable(personRepository.findByUsername(username));

        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            return new ResponseEntity<>(new PersonDTO(person), HttpStatus.OK);
        } else {
            // Manejar el caso en que no se encuentra un usuario con el nombre de usuario dado
            return new ResponseEntity<>("Usuario no encontrado", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/users/create/")
    public ResponseEntity<Object> create(@RequestBody Person person){
        String encodedPassword = new BCryptPasswordEncoder().encode(person.getPassword());
        person.setPassword(encodedPassword);
        personRepository.save(person);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<Person> user =personRepository.findById(id);
        user.ifPresent(value -> personRepository.delete(value));
        return new ResponseEntity<>(user.isPresent(),HttpStatus.OK);
    }

    @PutMapping("/users/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody Person newuser){
        Optional<Person> user = personRepository.findById(id);
        if(user.isPresent()){
            newuser.setId(id);
            personRepository.save(newuser);
            return new ResponseEntity<>(newuser,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
