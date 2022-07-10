package ru.netology.java16;

import java.util.ArrayList;
import java.util.List;

public class Game {

    //Вам нужно хранить всех зарегистрированных игроков в поле класса Game в виде списка.
    List<Player> players = new ArrayList<>();


    //    register(Player player) - метод регистрации игрока; если игрок не зарегистрирован,
//    то он не сможет играть в турнире.
    public boolean register(Player player) {   //если игрок находится в списке, то он зарегистрирован???
        return players.contains(player);

    }

//    round(String playerName1, String playerName2) - метод соревнования между двумя игроками.
//   игроки передаются методу через имя - полную информацию об игроке нужно будет найти в коллекции
//   зарегистрированных игроков.  Выигрывает тот игрок, у которого больше strength (сила);


    public int round(String playerName1, String playerName2) {
// исключение, если игроки не зарегистрированы
        if (register(findByName(playerName1)) == false) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered"
            );
        } else if (register(findByName(playerName2)) == false) {
            throw new NotRegisteredException(
                    "Player with name: " + playerName1 + " not registered"
            );
        }

        if (findByName(playerName1).getStrength() == findByName(playerName2).getStrength()) {
            return 0;
        } else if (findByName(playerName1).getStrength() > findByName(playerName2).getStrength()) {
            return 1;
        } else {
            return 2;
        }
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName() == name) {
                return player;  //если совпадает имя, то выводим игрока, иначе результат нулл
            }
        }
        return null;
    }


}
