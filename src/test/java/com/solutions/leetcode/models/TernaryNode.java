package com.solutions.leetcode.models;

public class TernaryNode {
    private char character;
    private int value;
    private boolean isLeaf;
    private TernaryNode leftChild;
    private TernaryNode rightChild;
    private TernaryNode middleChild;

    public TernaryNode(char character) {
        this.character = character;
    }

    public char getCharacter() {
        return character;
    }

    public int getValue() {
        return value;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public TernaryNode getLeftChild() {
        return leftChild;
    }

    public TernaryNode getRightChild() {
        return rightChild;
    }

    public TernaryNode getMiddleChild() {
        return middleChild;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setLeaf() {
        isLeaf = true;
    }

    public void setLeftChild(TernaryNode leftChild) {
        this.leftChild = leftChild;
    }

    public void setRightChild(TernaryNode rightChild) {
        this.rightChild = rightChild;
    }

    public void setMiddleChild(TernaryNode middleChild) {
        this.middleChild = middleChild;
    }
}
