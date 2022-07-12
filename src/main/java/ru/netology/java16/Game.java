package ru.netology.java16;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //список зарегистрированных игроков
    protected List<Player> players = new ArrayList<>();


     public void register(Player player) {   //регистрируем игрока, добавляя в список зарегистрированных
        players.add(player);
     }

//    round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
//   игроки передаются методу через имя - полную информацию об игроке нужно будет найти в коллекции
//   зарегистрированных игроков.  Выигрывает тот игрок, у которого больше strength (сила);

    public int round(String playerName1, String playerName2) {

            Player player1 = findByName(playerName1);
            Player player2 = findByName(playerName2);

//        исключение, если игроки не зарегистрированы
        if (!players.contains(player1)) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered"
            );
        } else if (!players.contains(player2)) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName2 + " not registered"
            );
        }

        if (player1.getStrength() == player2.getStrength()) {
            return 0;
        } else if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findByName(String name) {
        for (Player p : players) {
            if (p.getName() == name) {
                return p;  //если совпадает имя, то выводим игрока, иначе результат нулл
            }
        }
        return null;
    }

}
