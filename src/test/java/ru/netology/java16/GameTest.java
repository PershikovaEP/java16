package ru.netology.java16;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;

public class GameTest {

    Game game = new Game();


    Player player1 = new Player(1, "anya", 10);
    Player player2 = new Player(1, "olya", 5);
    Player player3 = new Player(1, "kolya", 5);
    Player player4 = new Player(1, "sveta", 15);
    Player player5 = new Player(1, "petya", 8);
    Player player6 = new Player(1, "sacha", 0);
    Player player7 = new Player(1, "katya", -5);


    @BeforeEach
    public void setup() {
        game.players.add(player1);
        game.players.add(player2);
        game.players.add(player3);
        game.players.add(player4);
        game.players.add(player7);
    }

    @Test
    public void shouldRegistered() {

        boolean expected = true;
        boolean actual = game.register(player1);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldNotRegistered() {

        boolean expected = false;
        boolean actual = game.register(player6);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldExceptionWhenPlayer1NotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("sacha", "anya");
        });
    }

    @Test
    public void shouldExceptionWhenPlayer2NotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("olya", "petya");
        });
    }

    @Test
    public void shouldExceptionWhenPlayer2AndPlayer1NotRegistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round("sacha", "petya");
        });
    }

    @Test
    public void shouldWinFirst() {

        int expected = 1;
        int actual = game.round("anya", "kolya");
    }

    @Test
    public void shouldWinSecond() {

        int expected = 2;
        int actual = game.round("anya", "sveta");
    }

    @Test
    public void shouldDraw() {

        int expected = 2;
        int actual = game.round("olya", "kolya");
    }

    @Test
    public void shouldWinFirstWhenNegativeStrength() {

        int expected = 1;
        int actual = game.round("olya", "katya");
    }


}
