package com.codenjoy.dojo.corners.model;

import com.codenjoy.dojo.corners.model.services.Colours;
import org.junit.Assert;
import org.junit.Test;

public class GameTest {

  @Test
  public void createGameTest()
  {
    Game game = new Game();
    Player player1 = new Player();
    Player player2 = new Player();

    Assert.assertTrue(game.addPlayer(player1, Colours.BLACK));
    Assert.assertTrue(game.addPlayer(player2));

    Assert.assertTrue(game.isReady());
  }

  @Test
  public void startGameTest()
  {
    Game game = new Game();
    Player player1 = new Player();
    Player player2 = new Player();

    game.addPlayer(player1, Colours.BLACK);
    game.addPlayer(player2);

    Assert.assertTrue(game.isReady());

    game.start();

    Assert.assertEquals(Colours.WHITE, game.getTurn());
  }

  @Test
  public void setSizeTest()
  {
    Game game = new Game();
    Player player1 = new Player();
    Player player2 = new Player();

    game.setSize(10,4,4);
    game.addPlayer(player1);
    game.addPlayer(player2);

    game.start();

    game.getField().getCheck(3,3).isInHouse(true);
  }

  @Test
  public void fewMovesTest()
  {
    Game game = new Game();
    Player player1 = new Player();
    Player player2 = new Player();
    game.addPlayer(player1);
    game.addPlayer(player2);
    game.start();

    game.makeMove(player1, 2, 2, 2, 3);
    game.makeMove(player2, 5, 5, 5, 4);
    Assert.assertEquals(Colours.WHITE, game.getField().getCheck(2,3).getColour());
    Assert.assertEquals(Colours.BLACK, game.getField().getCheck(5,4).getColour());

  }

}
