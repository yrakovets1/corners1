package com.codenjoy.dojo.corners.model.players;

import com.codenjoy.dojo.corners.model.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class ConsolePlayer implements Player {

    public List<Integer> makeTurn(Game game)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(game.getField().toString());
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            line = "";
        }
        String[] arrr = line.split(" ");
        return List.of(Integer.valueOf(arrr[0]),
                Integer.valueOf(arrr[1]),
                Integer.valueOf(arrr[2]),
                Integer.valueOf(arrr[3])
        );
    }

}
