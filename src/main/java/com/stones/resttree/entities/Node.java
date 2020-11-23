package com.stones.resttree.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class Node {

  private final int number;

  @JacksonXmlProperty(localName = "right-leaf")
  private Node left;

  @JacksonXmlProperty(localName = "left-leaf")
  private Node right;

  public Node(int number) {
    this.number = number;
  }

  public int getNumber() {
    return number;
  }

  public Node getLeft() {
    return left;
  }

  public void setLeft(Node left) {
    this.left = left;
  }

  public Node getRight() {
    return right;
  }

  public void setRight(Node right) {
    this.right = right;
  }

}
