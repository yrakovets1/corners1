package com.codenjoy.dojo.corners.model;

import com.codenjoy.dojo.corners.model.items.Checks;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static com.codenjoy.dojo.corners.model.services.Colours.BLACK;
import static com.codenjoy.dojo.corners.model.services.Colours.WHITE;

public class Field {
    private int size;
    private int houseHorizontal;
    private int houseVertical;
    private List<Checks> checks;

    public Field(int size, int houseHorizontal, int houseVertical)
    {

        if (houseHorizontal > size/2) throw new IllegalArgumentException("HouseHorisontal is too big");
        if (houseVertical > size/2) throw new IllegalArgumentException("HouseVertical is too big");
        if (houseHorizontal < 0) throw new IllegalArgumentException("HouseVertical is negative");
        if (houseVertical < 0) throw new IllegalArgumentException("HouseVertical is negative");
        if (size < 0) throw new IllegalArgumentException("Size is negative");


        this.size = size;
        this.houseHorizontal = houseHorizontal;
        this.houseVertical = houseVertical;
        checks = new ArrayList<Checks>();
        IntStream
                .range(0, houseHorizontal)
                .map(x ->IntStream
                        .range(0,houseVertical)
                        .map(y-> {checks.add(new Checks(x,y,WHITE, this)); checks.add(new Checks(size - x -1, size - y -1, BLACK, this)); return 0;})
                        .sum()
                )
                .sum();
    }

    public int getSize(){
        return size;
    }

    public List<Checks> getChecks() {
        return checks;
    }

    public int getHouseHorizontal() {
        return houseHorizontal;
    }

    public int getHouseVertical() {
        return houseVertical;
    }

    public boolean ceilIsEmpty(int x, int y) {
        return checks.stream().noneMatch(z-> z.getX() == x && z.getY() == y);
    }

    public Checks getCheck(int x, int y) {
        Optional<Checks> check = checks.stream().filter(z->z.getX() == x && z.getY() == y).findFirst();
        if(!check.isPresent()) throw new WrongStepException();
        return check.get();
    }
}
