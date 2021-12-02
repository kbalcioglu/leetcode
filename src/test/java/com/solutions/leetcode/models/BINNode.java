package com.solutions.leetcode.models;

public class BINNode {
    private int value;
    private String cardType;
    private BINNode[] children;

    private boolean isAllFromHere;
    private boolean isLeaf;

    public BINNode(int value) {
        this.value = value;
        this.children = new BINNode[BinConstants.NODE_COUNT];
    }

    public int getValue() {
        return value;
    }

    public String getCardType() {
        return cardType;
    }

    public BINNode[] getChildren() {
        return children;
    }
    public BINNode getChild(int index) {
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

    public void setChild(BINNode child,int index) {
        this.children[index] = child;
    }

    public void setAllFromHere() {
        isAllFromHere = true;
    }

    public void setIsLeaf() {
        isLeaf = true;
    }
}
