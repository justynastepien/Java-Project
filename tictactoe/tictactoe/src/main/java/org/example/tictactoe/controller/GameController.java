package org.example.tictactoe.controller;

import org.example.tictactoe.model.Game;
import org.example.tictactoe.model.GameRepository;
import org.example.tictactoe.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
public class GameController {

    private final GameRepository repository;

    public GameController(GameRepository repository){
        this.repository = repository;
    }

    @GetMapping(value="/games")
    ResponseEntity<List<Game>> readAllGames(){
        return ResponseEntity.ok(repository.findAll());
    }

    @PostMapping(value="/games")
    ResponseEntity<Game> createUser(@RequestBody @Valid Game toCreate){
        Game result = repository.save(toCreate);
        return ResponseEntity.created(URI.create("/"+result.getId())).body(result);
    }

    @DeleteMapping(value="/games/{id}")
    ResponseEntity<?> deleteTask(@PathVariable int id){

        repository.deleteById(id);

        if(repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok().build();
    }

}
