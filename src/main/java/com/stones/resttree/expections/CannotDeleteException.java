package com.stones.resttree.expections;

public class CannotDeleteException extends RuntimeException {

  public CannotDeleteException(String message) {
    super(message);
  }

}
