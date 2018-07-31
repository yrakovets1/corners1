package com.codenjoy.dojo.corners.model.players;

import com.codenjoy.dojo.corners.model.Game;

import java.util.List;

public interface Player {
    List<Integer> makeTurn(Game game);
}
