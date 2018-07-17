package com.codenjoy.dojo.corners.model.services;

public class WrongStepException extends IllegalArgumentException {
  public WrongStepException()
  {
  }
  public WrongStepException(String message){
    super(message);
  }
}
