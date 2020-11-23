package com.stones.resttree.entities;

import com.stones.resttree.expections.CannotDeleteException;
import com.stones.resttree.expections.NodeAlreadyExistsException;
import com.stones.resttree.expections.NodeNotFoundException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BinaryTreeTest {

  @Test
  public void addOneNumber_RootShouldBeCreated() {
    int number = 3;
    BinaryTree tree = new BinaryTree();

    Assertions.assertThat(tree.getRoot()).isNull();

    tree.add(number);

    Assertions.assertThat(tree.getRoot()).isNotNull();
    Assertions.assertThat(tree.getRoot().getNumber()).isEqualTo(number);
    Assertions.assertThat(tree.getRoot().getLeft()).isNull();
    Assertions.assertThat(tree.getRoot().getRight()).isNull();
  }

  @Test
  public void addTwoNumbersSecondIsHigher_SecondNumberShouldBeOnTheRightLeaf() {
    int secondNumber = 6;

    BinaryTree tree = new BinaryTree();
    tree.add(3);
    tree.add(secondNumber);

    Assertions.assertThat(tree.getRoot().getLeft()).isNull();
    Assertions.assertThat(tree.getRoot().getRight()).isNotNull();
    Assertions.assertThat(tree.getRoot().getRight().getNumber()).isEqualTo(secondNumber);
  }

  @Test
  public void addTwoNumbersSecondIsLower_SecondNumberShouldBeOnTheLeftLeaf() {
    int secondNumber = 1;

    BinaryTree tree = new BinaryTree();
    tree.add(3);
    tree.add(secondNumber);

    Assertions.assertThat(tree.getRoot().getRight()).isNull();
    Assertions.assertThat(tree.getRoot().getLeft()).isNotNull();
    Assertions.assertThat(tree.getRoot().getLeft().getNumber()).isEqualTo(secondNumber);
  }

  @Test
  public void addSameNumber_ExceptionShouldBeThrown() {
    int number = 1;
    BinaryTree tree = new BinaryTree();
    tree.add(number);

    Assertions.assertThatThrownBy(() -> tree.add(number))
            .isInstanceOf(NodeAlreadyExistsException.class)
            .hasMessageContaining("Node already present in the tree.");
  }

  @Test
  public void deleteLastNode_NodeShouldBeSetToNull() {
    int numberToDelete = 5;

    BinaryTree tree = new BinaryTree();
    tree.add(3);
    tree.add(1);
    tree.add(4);
    tree.add(numberToDelete);

    Assertions.assertThat(tree.getRoot().getRight().getRight()).isNotNull();

    tree.delete(numberToDelete);
    Assertions.assertThat(tree.getRoot().getRight().getRight()).isNull();
  }

  @Test
  public void deleteNodeWithChild_ExceptionShouldBeThrown() {
    int numberToDelete = 4;

    BinaryTree tree = new BinaryTree();
    tree.add(3);
    tree.add(1);
    tree.add(numberToDelete);
    tree.add(5);

    Assertions.assertThatThrownBy(() -> tree.delete(numberToDelete))
            .isInstanceOf(CannotDeleteException.class)
            .hasMessageContaining("Cannot delete node with children!");
  }

  @Test
  public void deleteNotPresentNode_ExceptionShouldBeThrown() {
    int numberToDelete = 9;

    BinaryTree tree = new BinaryTree();
    tree.add(3);
    tree.add(1);
    tree.add(4);
    tree.add(5);

    Assertions.assertThatThrownBy(() -> tree.delete(numberToDelete))
            .isInstanceOf(NodeNotFoundException.class)
            .hasMessageContaining("Can't find node to delete!");
  }


  @Test
  public void searchForRootNode_ShouldReturn0() {
    int rootNumber = 9;

    BinaryTree tree = new BinaryTree();
    tree.add(rootNumber);
    tree.add(1);
    tree.add(4);
    tree.add(5);

    Assertions.assertThat(tree.contains(rootNumber)).isEqualTo(0);
  }

  @Test
  public void searchForFirstChild_ShouldReturn1() {
    int childNumber = 1;

    BinaryTree tree = new BinaryTree();
    tree.add(9);
    tree.add(childNumber);
    tree.add(4);
    tree.add(5);

    Assertions.assertThat(tree.contains(childNumber)).isEqualTo(1);
  }

  @Test
  public void searchForNotPresentNode_ShouldReturnMinus1() {
    int missingNumber = 19;

    BinaryTree tree = new BinaryTree();
    tree.add(9);
    tree.add(1);
    tree.add(4);
    tree.add(5);

    Assertions.assertThat(tree.contains(missingNumber)).isEqualTo(-1);
  }

  @Test
  public void dasdad() {
    int missingNumber = 7;

    BinaryTree tree = new BinaryTree();
    tree.add(5);
    tree.add(1);
    tree.add(7);
    tree.add(8);

    Assertions.assertThat(tree.contains(missingNumber)).isEqualTo(0);
  }

}