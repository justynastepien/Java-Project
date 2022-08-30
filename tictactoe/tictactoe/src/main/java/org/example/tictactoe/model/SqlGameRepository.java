package org.example.tictactoe.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SqlGameRepository extends GameRepository, JpaRepository<Game, Integer> {

}
