package ru.netology.java16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Game {

    //список зарегистрированных игроков
    protected HashMap<String, Player> players = new HashMap<>();


    public void register(String name, Player player) {   //регистрируем игрока, добавляя в список зарегистрированных
        players.put(name, player);
    }

//    round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
//   игроки передаются методу через имя - полную информацию об игроке нужно будет найти в коллекции
//   зарегистрированных игроков.  Выигрывает тот игрок, у которого больше strength (сила);


        public int round(String playerName1, String playerName2){

//        исключение, если игроки не зарегистрированы
            if (!players.containsKey(playerName1)) {
                throw new NotRegisteredException(
                        "Player with name: " + playerName1 + " not registered"
                );
            } else if (!players.containsKey(playerName2)) {
                throw new NotRegisteredException(
                        "Player with name: " + playerName2 + " not registered"
                );
            }

            if (players.get(playerName1).getStrength() == players.get(playerName2).getStrength()) {
                return 0;
            } else if (players.get(playerName1).getStrength() > players.get(playerName2).getStrength()) {
                return 1;
            } else {
                return 2;
            }
        }

//    public Player findByName(String name) {
//        for (Player player : players) {
//            if (player.getName() == name) {
//                return player;  //если совпадает имя, то выводим игрока, иначе результат нулл
//            }
//        }
//        return null;
//    }


    }
