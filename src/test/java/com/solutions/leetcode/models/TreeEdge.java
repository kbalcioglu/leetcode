package com.solutions.leetcode.models;

public class TreeEdge implements  Comparable<TreeEdge>{
    private final int source;
    private final int destination;
    private final int weight;

    public TreeEdge(int source, int destination, int weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public int getSource() {
        return source;
    }

    public int getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(TreeEdge o) {
        return this.weight - o.weight;
    }
}
