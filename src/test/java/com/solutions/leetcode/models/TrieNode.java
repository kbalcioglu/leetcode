package com.solutions.leetcode.models;

public class TrieNode {
    private char character;
    private boolean isLeaf;
    private TrieNode[] children;

    public TrieNode(char character) {
        this.character = character;
        this.children = new TrieNode[TrieConstants.ALPHABET_SIZE];
    }

    public char getCharacter() {
        return character;
    }

    public boolean isLeaf() {
        return isLeaf;
    }

    public TrieNode[] getChildren() {
        return children;
    }

    public TrieNode getChild(int index) {
        if (index > TrieConstants.ALPHABET_SIZE - 1 || index < 0)
            return null;
        return this.children[index];
    }

    public void setLeaf() {
        isLeaf = true;
    }

    public void setChild(TrieNode children, int index) {
        if (index > TrieConstants.ALPHABET_SIZE - 1 || index < 0)
            return;
        this.children[index] = children;
    }
}
