package org.example.tictactoe.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User save(User entity);

    Optional<User> findById(int id);

    boolean existsById(int id);

    List<User> findAll();

    //Page<User> findAll(Pageable page);

    void deleteById(int id);


}
