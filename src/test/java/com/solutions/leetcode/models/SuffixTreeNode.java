package com.solutions.leetcode.models;

import java.util.ArrayList;
import java.util.List;

public class SuffixTreeNode {
    private String text;
    private List<SuffixTreeNode> children;
    private int position;

    public SuffixTreeNode(String word, int position) {
        this.text = word;
        this.position = position;
        this.children = new ArrayList<>();
    }

    public String getText() {
        return text;
    }

    public List<SuffixTreeNode> getChildren() {
        return children;
    }

    public int getPosition() {
        return position;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setChildren(List<SuffixTreeNode> children) {
        this.children = children;
    }
    public void setChild(SuffixTreeNode child) {
        this.children.add(child);
    }
    public void setPosition(int position) {
        this.position = position;
    }
}
