package com.codenjoy.dojo.corners.model.players;

import com.codenjoy.dojo.corners.model.Field;
import com.codenjoy.dojo.corners.model.Game;
import com.codenjoy.dojo.corners.model.services.Colours;

import java.util.List;

public class AIPlayer implements Player {

    private class PossibleMove {
        int xFrom;
        int yFrom;
        int xTo;
        int yTo;

        int estimate;

        Field field;
    }

    public List<Integer> makeTurn(Game game) {
        return null;
    }

    public int estimate(Field field, Colours colour)
    {
        int whiteWeight = field.getChecks()
                .stream()
                .filter(z->z.getColour()==Colours.WHITE)
                .mapToInt(z->Math.abs(2*field.getSize() - field.getHouseHorizontal() -  z.getX()*2 - 1)
                        + Math.abs(2*field.getSize() - field.getHouseVertical() -  z.getY()*2 - 1))
                .sum();
        int blackWeight = field.getChecks()
                .stream()
                .filter(z->z.getColour()==Colours.BLACK)
                .mapToInt(z->Math.abs(z.getX()*2 - field.getHouseHorizontal() + 1)
                        + Math.abs(z.getY()*2 - field.getHouseVertical() + 1))
                .sum();
        return (colour==Colours.WHITE)?(blackWeight-whiteWeight)/2:(whiteWeight-blackWeight)/2;
    }

    public List<PossibleMove> getPossibleMoves(Field field, Colours colour) {
        //field.getChecks().stream().filter(z->z.getColour() == colour).map(z->z.possibleMoves().)

        return null;
    }


}
