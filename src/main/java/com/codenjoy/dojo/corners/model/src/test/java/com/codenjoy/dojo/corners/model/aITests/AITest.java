package com.codenjoy.dojo.corners.model.aITests;

import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.players.AIPlayer;
import com.codenjoy.dojo.corners.model.players.ConsolePlayer;
import com.codenjoy.dojo.corners.model.players.Player;
import com.codenjoy.dojo.corners.model.services.Colours;
import org.junit.Assert;
import org.junit.Test;

public class AITest {

    @Test
    public void estimateTest(){
        Game game = new Game();
        game.setSize(8,3,3);

        AIPlayer ai = new AIPlayer();
        Player player = new ConsolePlayer();
        game.addPlayer(player);
        game.addPlayer(ai);
        game.start();

        Assert.assertEquals(0, ai.estimate(game.getField(), Colours.WHITE));

        game.makeMove(player, 1,1,1,3);

        Assert.assertEquals(-2, ai.estimate(game.getField(), Colours.BLACK));

        game.makeMove(ai, 5,5,5,4);

        Assert.assertEquals(1, ai.estimate(game.getField(), Colours.WHITE));

        game.makeMove(player, 0,1,2,3);

        Assert.assertEquals(-5, ai.estimate(game.getField().cloneField(), Colours.BLACK));

    }

    @Test
    public void fewVariantTest()
    {
        Game game = new Game();
        game.setSize(8,3,3);

        AIPlayer ai = new AIPlayer();
        Player player = new ConsolePlayer();
        game.addPlayer(player);
        game.addPlayer(ai);
        game.start();

        Assert.assertEquals(0, ai.estimate(game.getField(), Colours.WHITE));

        game.makeMove(player, 1,1,1,3);

        Assert.assertEquals(-2, ai.estimate(game.getField(), Colours.BLACK));

        game.makeMove(ai, 5,5,5,4);

        game.makeMove(player, 0,1,2,3);

        ai.getPossibleMoves();

    }



}
