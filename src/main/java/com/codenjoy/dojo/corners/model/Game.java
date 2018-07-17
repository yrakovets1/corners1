package com.codenjoy.dojo.corners.model;

import com.codenjoy.dojo.corners.model.items.Check;
import com.codenjoy.dojo.corners.model.services.Colours;
import com.codenjoy.dojo.corners.model.services.IllegalChangeParameterException;
import com.codenjoy.dojo.corners.model.services.WrongStepException;

import java.util.HashMap;
import java.util.Map;

public class Game {

  private Map<Colours,Player> players = new HashMap<>();
  private Field field;
  private int fieldSize = 8;
  private int houseHorizontal = 3;
  private int houseVertical = 3;
  private Colours turn = null;


  public void setSize(int fieldSize, int houseHorizontal, int houseVertical)
  {
    if(turn != null) throw new IllegalChangeParameterException();
    this.fieldSize = fieldSize;
    this.houseHorizontal = houseHorizontal;
    this.houseVertical = houseVertical;
  }


  public boolean addPlayer(Player player)
  {
    if(!players.containsKey(Colours.WHITE))
    {
      return addPlayer(player, Colours.WHITE);
    }
    return addPlayer(player, Colours.BLACK);
  }

  public boolean addPlayer(Player player, Colours colour)
  {
    if(players.containsKey(colour))
      return false;
    players.put(colour, player);
    return true;
  }

  public boolean isReady() {
    return players.size() == 2;
  }

  public Colours getTurn() {
    return turn;
  }

  public void start() {
    if(!isReady()) throw new IllegalChangeParameterException();
    field = new Field(fieldSize,houseHorizontal,houseVertical);
    turn = Colours.WHITE;
  }

  public Field getField() {
    return field;
  }

  public void makeMove(Player player, int xFrom, int yFrom, int xTo, int yTo) {
    if (turn == null) throw new WrongStepException("The game isn't started jet");
    if (players.get(turn) != player) throw new WrongStepException("There is another player's turn");
    Check check = field.getCheck(xFrom,yFrom);
    if(check.getColour() != turn) throw new WrongStepException("There is another player's check");

    check.moveTo(xTo,yTo);

    checkGameOver();

    if(turn == Colours.WHITE) turn = Colours.BLACK;
    else turn = Colours.WHITE;
  }

  private void checkGameOver() {

  }
}
