package com.solutions.leetcode.models;

import java.util.HashSet;
import java.util.Set;

public class EdgeSubset {
    private Set<Integer> subsetNodes;

    public EdgeSubset() {
        subsetNodes = new HashSet<>();
    }

    public Set<Integer> getSubsetNodes() {
        return subsetNodes;
    }

    public boolean subsetContainsEdge(TreeEdge edge) {
        return subsetNodes.contains(edge.getSource()) || subsetNodes.contains(edge.getDestination()) ;
    }
    public void addEdge(TreeEdge edge){
        if(!subsetContainsEdge(edge)){
            this.subsetNodes.add(edge.getDestination());
            this.subsetNodes.add(edge.getSource());
        }
    }

    public void unionSubset(EdgeSubset subset){
        for(int node : subset.getSubsetNodes()){
            this.subsetNodes.add(node);
        }
    }

}
