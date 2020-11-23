package com.stones.resttree.services;

import com.stones.resttree.entities.BinaryTree;
import org.springframework.stereotype.Service;

@Service
public class TreeService {

  private final BinaryTree tree;

  public TreeService() {
    tree = new BinaryTree();
  }

  public BinaryTree getTree() {
    return tree;
  }

  public void addNumber(int number) {
    tree.add(number);
  }

  public void deleteNumber(int number) {
    tree.delete(number);
  }

  public int searchNumber(int number) {
    return tree.contains(number);
  }

}
