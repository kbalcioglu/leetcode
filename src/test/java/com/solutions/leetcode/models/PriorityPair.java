package com.solutions.leetcode.models;


public class PriorityPair implements Comparable<PriorityPair> {
    private int parentIndex;
    private int nodeIndex;
    private int weight;

    public PriorityPair(int nodeIndex, int weight, int parentIndex) {
        this.parentIndex = parentIndex;
        this.nodeIndex = nodeIndex;
        this.weight = weight;
    }

    public int getParentIndex() {
        return parentIndex;
    }

    public int getNodeIndex() {
        return nodeIndex;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(PriorityPair o) {
        return this.weight - o.weight;
    }
}
