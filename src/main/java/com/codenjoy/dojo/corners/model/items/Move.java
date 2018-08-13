package com.codenjoy.dojo.corners.model.items;

public class Move {
    private int xFrom;
    private int yFrom;
    private int xTo;
    private int yTo;

    public Move(int xFrom, int yFrom, int xTo, int yTo){
        this.xFrom = xFrom;
        this.yFrom = yFrom;
        this.xTo = xTo;
        this.yTo = yTo;
    }

    public int getXFrom() {
        return xFrom;
    }

    public int getYFrom() {
        return yFrom;
    }

    public int getXTo() {
        return xTo;
    }

    public int getYTo() {
        return yTo;
    }
}
