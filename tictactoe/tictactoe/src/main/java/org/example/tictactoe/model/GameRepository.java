package org.example.tictactoe.model;

import java.util.List;
import java.util.Optional;

public interface GameRepository {

    Game save(Game entity);

    Optional<Game> findById(int id);

    boolean existsById(int id);

    List<Game> findAll();

    //Page<User> findAll(Pageable page);

    void deleteById(int id);
}
