package org.example.tictactoe.controller;

import org.example.tictactoe.model.User;
import org.example.tictactoe.model.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    private final UserRepository repository;

    public UserController(UserRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/users")
    ResponseEntity<List<User>> readAllUsers(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(value="/users")
    ResponseEntity<User> createUser(@RequestBody @Valid User toCreate){
        User result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @DeleteMapping(value="/users/{id}")
    ResponseEntity<?> deleteTask(@PathVariable int id){

        repository.deleteById(id);

        if(repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }
}
