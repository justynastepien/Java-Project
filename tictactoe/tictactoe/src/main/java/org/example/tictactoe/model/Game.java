package org.example.tictactoe.model;

import javax.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @Getter(AccessLevel.PUBLIC)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter(AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    private String token;

    @Getter(AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    private int players = 0;

    @OneToMany(mappedBy = "game")
    private Set<User> users;

    @Embedded
    private BaseAuditableEntity audit = new BaseAuditableEntity();

    public Game(){

    }

}
