package com.solutions.leetcode.models;

public class BINNode {
    private int startValue;
    private int endValue;
    private BINNode[] children;

    public static BINNode initialTree() {
        return new BINNode(-1, -1, true);
    }

    public static BINNode newNode(int value) {
        return new BINNode(value, value, false);
    }

    public static BINNode newNode(int startValue, int endValue) {
        return new BINNode(startValue, endValue, false);
    }

    private BINNode(int startValue, int endValue, boolean initial) {
        if (!initial && (startValue < 0 || endValue < 0))
            throw new IllegalArgumentException("");
        this.startValue = startValue;
        this.endValue = endValue;
        this.children = new BINNode[10];
    }

    public int getStartValue() {
        return this.startValue;
    }

    public int getEndValue() {
        return this.startValue;
    }

    public boolean isValueIn(int value) {
        return value >= this.startValue && value <= this.endValue;
    }

    public BINNode[] getChildren() {
        return this.children;
    }

    public BINNode getChildNode(int index) {
        if (index >= this.children.length)
            throw new IllegalArgumentException("No Index in Children");
        return this.children[index];
    }

    public BINNode setChildNode(BINNode node, int index) {
        if (index >= this.children.length)
            throw new IllegalArgumentException("No Index in Children");
        this.children[index] = node;
        return this;
    }

    public BINNode setChildren(BINNode[] children) {
        if (children.length >= this.children.length)
            throw new IllegalArgumentException("Given children is larger then node children count");
        for (int i = 0; i < children.length; i++) {
            this.children[i] = children[i];
        }
        return this;
    }
}
