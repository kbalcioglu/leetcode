package com.solutions.leetcode.models;

public class BinaryTreeNode {
    int val;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.val = value;
        this.right = null;
        this.left = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinaryTreeNode that = (BinaryTreeNode) o;
        return val == that.val
                && ((left == null && that.left == null) || (left.equals(that.left)))
                &&  ((right == null && that.right == null) || (right.equals(that.right)));
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.val;
        if (this.left != null)
            hash = 67 * hash + this.left.hashCode();
        else
            hash = 67 * hash;
        if (this.right != null)
            hash = 67 * hash + this.right.hashCode();
        else
            hash = 67 * hash;
        return hash;
    }

    public int getVal() {
        return val;
    }

    public BinaryTreeNode getLeft() {
        return left;
    }

    public BinaryTreeNode getRight() {
        return right;
    }

    public void setLeft(BinaryTreeNode left) {
        this.left = left;
    }

    public void setRight(BinaryTreeNode right) {
        this.right = right;
    }
}
