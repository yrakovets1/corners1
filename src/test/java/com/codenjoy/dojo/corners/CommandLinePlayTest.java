package com.codenjoy.dojo.corners;

import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.players.ConsolePalyer;
import com.codenjoy.dojo.corners.model.players.Player;
import com.codenjoy.dojo.corners.model.services.Colours;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

public class CommandLinePlayTest {
  public static void main(String... s ){
    Game game = new Game();
    Player player1 = new ConsolePalyer();
    Player player2 = new ConsolePalyer();
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.start();
    Colours active  = Colours.WHITE;



    while (true){
      try {
        //another change
        //fghgfhgfh
        game.makeMove(game.getPlayer(active), game.getPlayer(active).makeTurn(game));
        if(active == Colours.WHITE){
          active = Colours.BLACK;
        } else {
          active = Colours.WHITE;
        }
      } catch (WrongStepException e) {
        System.out.println(e.getMessage());
      }

    }
  }
}
