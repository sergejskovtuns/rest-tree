package com.stones.resttree.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.stones.resttree.expections.CannotDeleteException;
import com.stones.resttree.expections.NodeAlreadyExistsException;
import com.stones.resttree.expections.NodeNotFoundException;

import java.util.Objects;

@JacksonXmlRootElement(localName = "tree")
public class BinaryTree {

  private Node root;

  public void add(int number) {
    root = add(root, number);
  }

  private Node add(Node node, int number) {
    if (Objects.isNull(node)) {
      return new Node(number);
    }

    if (number > node.getNumber()) {
      node.setRight(add(node.getRight(), number));
    } else if (number < node.getNumber()) {
      node.setLeft(add(node.getLeft(), number));
    } else {
      throw new NodeAlreadyExistsException("Node already present in the tree.");
    }

    return node;
  }

  private int contains(Node node, int number, int level) {
    if (Objects.isNull(node)) {
      return -1;
    }

    if (node.getNumber() == number) {
      return level;
    }

    return number > node.getNumber()
            ? contains(node.getRight(), number, ++level)
            : contains(node.getLeft(), number, ++level);
  }

  public int contains(int number) {
    return contains(root, number, 0);
  }

  private Node delete(Node node, int number) {
    if (Objects.isNull(node)) {
      throw new NodeNotFoundException("Can't find node to delete!");
    }

    if (node.getNumber() == number) {
      if (Objects.isNull(node.getLeft()) && Objects.isNull(node.getRight())) {
        return null;
      } else {
        throw new CannotDeleteException("Cannot delete node with children!");
      }
    }

    if (number > node.getNumber()) {
      node.setRight(delete(node.getRight(), number));
    } else {
      node.setLeft(delete(node.getLeft(), number));
    }

    return node;
  }

  public void delete(int number) {
    root = delete(root, number);
  }

  public Node getRoot() {
    return root;
  }

  public void setRoot(Node root) {
    this.root = root;
  }

}
