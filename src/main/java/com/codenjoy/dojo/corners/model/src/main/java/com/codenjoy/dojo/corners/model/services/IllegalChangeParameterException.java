package com.codenjoy.dojo.corners.model.services;

public class IllegalChangeParameterException extends IllegalArgumentException {
  public IllegalChangeParameterException()
  {
  }
  public IllegalChangeParameterException(String message){
    super(message);
  }

}
