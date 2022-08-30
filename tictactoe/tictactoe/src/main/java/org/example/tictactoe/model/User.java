package org.example.tictactoe.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @Getter(value = AccessLevel.PUBLIC)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    @NotBlank(message = "Nick space must not be empty")
    private String nick;

    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    @NotBlank(message = "Mail space must not be empty")
    private String mail;

    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    @NotBlank(message = "Password space must not be empty")
    private String password;

    @Getter(value = AccessLevel.PUBLIC)
    @Setter(value = AccessLevel.PUBLIC)
    private String token;

    @Embedded
    private BaseAuditableEntity audit = new BaseAuditableEntity();

    @ManyToOne()
    @JoinColumn(name="game_id")
    private Game game;

    public User(){

    }

    //@OneToOne()


}
