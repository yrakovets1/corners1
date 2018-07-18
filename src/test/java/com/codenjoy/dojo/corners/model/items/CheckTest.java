package com.codenjoy.dojo.corners.model.items;

import com.codenjoy.dojo.corners.model.Field;
import com.codenjoy.dojo.corners.model.items.Check;
import com.codenjoy.dojo.corners.model.services.WrongStepException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static com.codenjoy.dojo.corners.model.services.Colours.WHITE;

public class CheckTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void inHouseTest()
    {
        int fieldSize = 8;
        int houseHorisontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize,houseHorisontal,houseVertical);

        Assert.assertTrue(field.getChecks().get(4).isInHouse(true));
        Assert.assertTrue(field.getChecks().get(17).isInHouse(true));

        Assert.assertEquals(
                new ArrayList<Check>(),
                field
                        .getChecks()
                        .stream()
                        .filter(x-> x.isInHouse(false))
                        .collect(Collectors.toList())
        );

/*
        field
                .getChecks()
                .stream()
                .map(x -> {System.out.println(" X: " + x.getX() + " Y: " + x.getY() + " color: " + x.getColour()); return 0;})
                .collect(Collectors.toList());
*/
    }

    @Test
    public void possibleMoveTest() {
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);

        Assert.assertEquals(2, field.getCheck(2,2).possibleMoves().size());

    }

    @Test
    public void unPossibleMoveTest()
    { // берем шашку, которой нет
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);
        thrown.expect(WrongStepException.class);

        field.getCheck(4,5).moveTo(6,7);

    }

    @Test
    public void unPossibleMove2Test()
    { // ходим на занятое поле
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);
        thrown.expect(WrongStepException.class);

        field.getCheck(2,2).moveTo(2,1);

    }

    @Test
    public void MoveTest()
    {
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);
        field.getCheck(2,2).moveTo(2,3);
        field.getCheck(5,5).moveTo(5,4);

        Assert.assertEquals(WHITE,  field.getCheck(2,3).getColour());
    }

    @Test
    public void MoveWithJumpTest()
    {
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);
        field.getCheck(2,2).moveTo(2,3);
        field.getCheck(5,5).moveTo(5,4);
        field.getCheck(1,1).moveTo(1,3);

        Assert.assertEquals(WHITE,  field.getCheck(1,3).getColour());
    }

    @Test
    public void possibleMoveWithJumpTest() {
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize, houseHorizontal, houseVertical);
        field.getCheck(2,2).moveTo(2,3);
        field.getCheck(5,5).moveTo(5,4);

        Assert.assertEquals(3, field.getCheck(1,1).possibleMoves().size());
        //field.getCheck(1,1).possibleMoves().stream().mapToInt(z-> {System.out.println("X: "+ z.get(0) + " Y: " + z.get(1)); return 0;}).sum();

    }
}
