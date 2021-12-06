package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.TernaryNode;

public class TernarySearchTree {
    private TernaryNode root;

    public void put(String key, int value) {
        this.put(key, value, root, 0);
    }

    private TernaryNode put(String key, int value, TernaryNode node, int index) {
        char c = key.charAt(index);
        if (node == null)
            node = new TernaryNode(c);

        if (c < node.getCharacter()) {
            node.setLeftChild(put(key, value, node.getLeftChild(), index));
        } else if (c > node.getCharacter()) {
            node.setRightChild(put(key, value, node.getRightChild(), index));
        } else if (index < key.length() - 1) {
            node.setMiddleChild(put(key, value, node.getMiddleChild(), index + 1));
        } else {
            node.setLeaf();
            node.setValue(value);
        }
        return node;
    }

    public Integer get(String key) {
        TernaryNode node = get(root, key, 0);
        if (node == null)
            return null;
        return node.getValue();
    }

    private TernaryNode get(TernaryNode node, String key, int index) {
        if (node == null)
            return null;
        char c = key.charAt(index);
        if (c < node.getCharacter()) {
            return get(node.getLeftChild(), key, index);
        } else if (c > node.getCharacter()) {
            return get(node.getRightChild(), key, index);
        } else if (index < key.length() - 1) {
            return get(node.getMiddleChild(), key, index + 1);
        } else if (node.isLeaf()) {
            return node;
        } else {
            return null;
        }
    }
}
