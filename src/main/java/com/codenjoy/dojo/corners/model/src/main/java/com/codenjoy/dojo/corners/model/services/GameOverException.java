package com.codenjoy.dojo.corners.model.services;

public class GameOverException extends IllegalArgumentException {
  public GameOverException(String message) {
    super(message);
  }
}
