package com.solutions.leetcode.models;

public class BinNode {
    private int value;
    private String cardType;
    private BinNode[] children;

    private boolean isAllFromHere;
    private boolean isLeaf;

    public BinNode(int value) {
        this.value = value;
        this.children = new BinNode[BinConstants.NODE_COUNT];
    }

    public int getValue() {
        return value;
    }

    public String getCardType() {
        return cardType;
    }

    public BinNode[] getChildren() {
        return children;
    }
    public BinNode getChild(int index) {
        return children[index];
    }
    public boolean isAllFromHere() {
        return isAllFromHere;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setChild(BinNode child, int index) {
        this.children[index] = child;
    }

    public void setAllFromHere() {
        isAllFromHere = true;
    }

    public void setIsLeaf() {
        isLeaf = true;
    }
}
