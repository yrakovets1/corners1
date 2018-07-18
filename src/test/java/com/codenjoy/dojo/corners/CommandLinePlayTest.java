package com.codenjoy.dojo.corners;

import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.Player;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CommandLinePlayTest {
  public static void main(String... s ){
    Game game = new Game();
    Player player1 = new Player();
    Player player2 = new Player();
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.start();
    int active  = 0;

    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    while (true){
      System.out.println(game.getField().toString());
      String line;
      try {
        line = reader.readLine();
      } catch (IOException e) {
        e.printStackTrace();
        line = "";
      }
      String[] arrr = line.split(" ");

      if (active == 0) {active = 1;}
      else active = 0;

      try {
        game.makeMove((active == 0)?player1:player2, Integer.valueOf(arrr[0]), Integer.valueOf(arrr[1]), Integer.valueOf(arrr[2]), Integer.valueOf(arrr[3]));
      } catch (WrongStepException e) {
        System.out.println(e.getMessage());

      }

    }


  }
}
