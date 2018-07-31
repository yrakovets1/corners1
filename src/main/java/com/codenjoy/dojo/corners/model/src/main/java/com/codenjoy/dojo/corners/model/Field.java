package com.codenjoy.dojo.corners.model;

import com.codenjoy.dojo.corners.model.items.Check;
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
    private List<Check> checks;

    public Field(int size, int houseHorizontal, int houseVertical)
    {

        if (houseHorizontal > size/2) throw new IllegalArgumentException("HouseHorizontal is too big");
        if (houseVertical > size/2) throw new IllegalArgumentException("HouseVertical is too big");
        if (houseHorizontal < 0) throw new IllegalArgumentException("HouseHorizontal is negative");
        if (houseVertical < 0) throw new IllegalArgumentException("HouseVertical is negative");
        if (size < 0) throw new IllegalArgumentException("Size is negative");


        this.size = size;
        this.houseHorizontal = houseHorizontal;
        this.houseVertical = houseVertical;
        checks = new ArrayList<>();

    }

    public void fillChecks(){
        IntStream
                .range(0, houseHorizontal)
                .map(z ->IntStream
                        .range(0,houseVertical)
                        .map(y-> {checks.add(new Check(z,y,WHITE, this)); checks.add(new Check(size - z -1, size - y -1, BLACK, this)); return 0;})
                        .sum()
                )
                .sum();
    }

    public int getSize(){
        return size;
    }

    public List<Check> getChecks() {
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

    public Check getCheck(int x, int y) {
        Optional<Check> check = checks.stream().filter(z->z.getX() == x && z.getY() == y).findFirst();
        if(!check.isPresent()) throw new WrongStepException();
        return check.get();
    }

    public String toString()
    {
        String block = "+-";
        StringBuilder out = new StringBuilder();
        IntStream
                .range(0,size)
                .map(y-> {
            out.append(IntStream.range(0, size).boxed().map(x -> block).reduce("", String::concat));
            out.append("+\n");
            out.append(IntStream.range(0, size).mapToObj(x -> "|" + ceilToString(x,size - y - 1)).reduce("", String::concat));
            out.append("|\n");
            return 0;
        }).sum();
        out.append(IntStream.range(0, size).boxed().map(x -> block).reduce("", String::concat));


        return out.toString();
    }

    private String ceilToString(int x, int y)
    {
        if(ceilIsEmpty(x,y)) return " ";
        if(getCheck(x,y).getColour() == WHITE) return "☺";
        else  return "☻";
    }

    public Field cloneField(){
        Field newField = new Field(this.getSize(), this.getHouseHorizontal(),this.getHouseVertical());
        this.getChecks().stream().mapToInt(z->{newField.checks.add(new Check(z.getX(),z.getY(),z.getColour(),newField)); return 0;}).sum();
        return newField;
    }
}
