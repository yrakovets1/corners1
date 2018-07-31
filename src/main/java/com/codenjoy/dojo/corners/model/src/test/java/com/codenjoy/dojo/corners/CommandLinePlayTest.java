package com.codenjoy.dojo.corners;

import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.players.ConsolePlayer;
import com.codenjoy.dojo.corners.model.players.Player;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

public class CommandLinePlayTest {
  public static void main(String... s ){
    Game game = new Game();
    Player player1 = new ConsolePlayer();
    Player player2 = new ConsolePlayer();
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.start();


    while (true){
      try {
        game.makeMove(game.getPlayer(game.getTurn()), game.getPlayer(game.getTurn()).makeTurn(game));
      } catch (WrongStepException e) {
        System.out.println(e.getMessage());
      }

    }
  }
}
