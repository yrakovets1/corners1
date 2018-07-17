package com.codenjoy.dojo.corners.model.items;

import com.codenjoy.dojo.corners.model.Field;
import com.codenjoy.dojo.corners.model.services.Colours;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Check {

    private int x;
    private int y;
    private Colours colour;
    private Field field;

    public Check(int x, int y, Colours colour, Field field){
        this.x = x;
        this.y = y;
        this.colour = colour;
        this.field = field;
    }

    public boolean isInHouse(boolean ownHouse)
    {
        if(this.colour == Colours.WHITE ^ !ownHouse )
        {
            return this.x < field.getHouseHorizontal() && this.y < field.getHouseVertical();
        } else {
            return this.x >= field.getSize() - field.getHouseHorizontal() && this.y >= field.getSize() - field.getHouseVertical();
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Colours getColour() {
        return colour;
    }

    public boolean moveIsPossible(int x, int y)
    {
        return possibleMoves().contains(new ArrayList<>(Arrays.asList(x,y)));
    }

    public List<List<Integer>> possibleMoves()
    {
        List<List<Integer>> possibleMoves = new ArrayList<>();
        if (x < field.getSize() -1 && field.ceilIsEmpty(x+1, y))
            possibleMoves.add(new ArrayList<>(Arrays.asList(x+1, y)));
        else if(x < field.getSize() -2 && field.ceilIsEmpty(x+2, y))
            addJump(x+2, y,possibleMoves);

        if (x > 0 && field.ceilIsEmpty(x-1, y))
            possibleMoves.add(new ArrayList<>(Arrays.asList(x-1, y)));
        else if(x >1 && field.ceilIsEmpty(x-2, y))
            addJump(x-2, y,possibleMoves);

        if (y < field.getSize() -1 && field.ceilIsEmpty(x, y+1))
            possibleMoves.add(new ArrayList<>(Arrays.asList(x, y+1)));
        else if(y < field.getSize() -2 && field.ceilIsEmpty(x, y+2))
            addJump(x, y+2,possibleMoves);

        if (y > 0 && field.ceilIsEmpty(x, y-1))
            possibleMoves.add(new ArrayList<>(Arrays.asList(x, y-1)));
        else if(y > 1 && field.ceilIsEmpty(x, y-2))
            addJump(x, y-2,possibleMoves);

        return possibleMoves;
    }

    private void addJump(int x, int y, List<List<Integer>> possibleMoves) {
        possibleMoves.add(new ArrayList<>(Arrays.asList(x,y)));
        if(x < field.getSize() -2
                && !field.ceilIsEmpty(x+1, y)
                && field.ceilIsEmpty(x+2, y)
                && !possibleMoves.contains(new ArrayList<>(Arrays.asList(x+2,y))))
            addJump(x+2, y, possibleMoves);
        if(x > 1
                && !field.ceilIsEmpty(x-1, y)
                && field.ceilIsEmpty(x-2, y)
                && !possibleMoves.contains(new ArrayList<>(Arrays.asList(x-2,y))))
            addJump(x-2, y, possibleMoves);
        if(y < field.getSize() -2
                && !field.ceilIsEmpty(x, y+1)
                && field.ceilIsEmpty(x, y+2)
                && !possibleMoves.contains(new ArrayList<>(Arrays.asList(x,y+2))))
            addJump(x, y + 2, possibleMoves);
        if(y > 1
                && !field.ceilIsEmpty(x, y-1)
                && field.ceilIsEmpty(x, y-2)
                && !possibleMoves.contains(new ArrayList<>(Arrays.asList(x,y-2))))
            addJump(x, y-2, possibleMoves);
    }

    public void moveTo(int x, int y)
    {
        if (!field.ceilIsEmpty(x,y)) throw new WrongStepException();

        if(!moveIsPossible(x,y)) throw new WrongStepException();

        this.x = x;
        this.y = y;
    }

}

