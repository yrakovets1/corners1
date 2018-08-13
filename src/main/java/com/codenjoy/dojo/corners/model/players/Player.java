package com.codenjoy.dojo.corners.model.players;

import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.items.Move;


public interface Player {
    Move makeTurn(Game game);
}
