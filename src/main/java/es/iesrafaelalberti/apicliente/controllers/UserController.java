package es.iesrafaelalberti.apicliente.controllers;

import es.iesrafaelalberti.apicliente.models.Heroe;
import es.iesrafaelalberti.apicliente.models.User;
import es.iesrafaelalberti.apicliente.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping("/users/")
    public ResponseEntity<Object> index(){return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);}

    @GetMapping("/users/{id}/")
    public ResponseEntity<Object>show(@PathVariable("id") Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users/create/")
    public ResponseEntity<Object> create(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}/")
    public ResponseEntity<Object> delete(@PathVariable("id") Long id){
        Optional<User> user =userRepository.findById(id);
        user.ifPresent(value -> userRepository.delete(value));
        return new ResponseEntity<>(user.isPresent(),HttpStatus.OK);
    }

    @PatchMapping("/heroes/{id}/")
    public ResponseEntity<Object> update(@PathVariable("id") Long id, @RequestBody User newuser){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            newuser.setId(id);
            userRepository.save(newuser);
            return new ResponseEntity<>(newuser,HttpStatus.OK);
        }
        return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
    }
}
