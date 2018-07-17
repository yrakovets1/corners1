package com.codenjoy.dojo.corners.model;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FieldTest
{
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void createTest()
    {
        Field field = new Field(8,3,3);
        Assert.assertEquals(8, field.getSize());
    }

    @Test
    public void createWrongTest()
    {
        thrown.expect(IllegalArgumentException.class);
        Field field = new Field(8,5,3);
    }

    @Test
    public void createAndInitTest()
    {
        int fieldSize = 8;
        int houseHorizontal = 3;
        int houseVertical = 3;
        Field field = new Field(fieldSize,houseHorizontal,houseVertical);
        Assert.assertEquals(fieldSize, field.getSize());
        Assert.assertEquals(houseHorizontal*houseVertical*2, field.getChecks().size());
    }

    @Test
    public void toStringTest()
    {
        Field field = new Field(8,3,3);
        Assert.assertEquals("+-+-+-+-+-+-+-+-+\n" +
                "| | | | | |☻|☻|☻|\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "| | | | | |☻|☻|☻|\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "| | | | | |☻|☻|☻|\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "| | | | | | | | |\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "| | | | | | | | |\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "|☺|☺|☺| | | | | |\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "|☺|☺|☺| | | | | |\n" +
                "+-+-+-+-+-+-+-+-+\n" +
                "|☺|☺|☺| | | | | |\n" +
                "+-+-+-+-+-+-+-+-",
                field.toString());
    }

}
