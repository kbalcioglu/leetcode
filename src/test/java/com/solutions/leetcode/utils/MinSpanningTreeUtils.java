package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.PriorityPair;
import com.solutions.leetcode.models.TreeEdge;

import java.util.*;

public class MinSpanningTreeUtils {

    //region KRUSKAL
    public void kruskalAlgorithm(List<List<Integer>> edgesList) {
        TreeEdge[] treeEdges = new TreeEdge[edgesList.size()];
        for (int i = 0; i < edgesList.size(); i++) {
            treeEdges[i] = new TreeEdge(edgesList.get(i).get(0), edgesList.get(i).get(1), edgesList.get(i).get(2));
        }
        kruskalAlgorithm(treeEdges);
    }

    public void kruskalAlgorithm(int[] sources, int[] destinations, int[] weights) {
        TreeEdge[] treeEdges = new TreeEdge[sources.length];
        for (int i = 0; i < sources.length; i++) {
            treeEdges[i] = new TreeEdge(sources[i], destinations[i], weights[i]);
        }
        kruskalAlgorithm(treeEdges);
    }

    public int kruskalAlgorithm(TreeEdge[] treeEdges) {
        List<TreeEdge> minSpanningTree = new ArrayList<>(treeEdges.length);
        List<Set<Integer>> subsets = new ArrayList<>();
        Arrays.sort(treeEdges);
        int totalCost = 0;
        for (TreeEdge edge : treeEdges) {
            totalCost += arrangeSubsets(subsets, edge, minSpanningTree);
        }
        return totalCost;
    }

    private int arrangeSubsets(List<Set<Integer>> subsets, TreeEdge edge, List<TreeEdge> minSpanningTree) {
        int sourceSubset = -1;
        int destinationSubset = -1;
        if (subsets.size() == 0) {
            createNewSubset(subsets, edge);
            minSpanningTree.add(edge);
            return edge.getWeight();
        }
        for (int i = 0; i < subsets.size(); i++) {
            if (subsets.get(i).contains(edge.getSource())) {
                sourceSubset = i;
            }
            if (subsets.get(i).contains(edge.getDestination())) {
                destinationSubset = i;
            }
            if (sourceSubset != -1 && destinationSubset != -1)
                break;
        }
        if (sourceSubset == -1 && destinationSubset == -1) {
            createNewSubset(subsets, edge);
            minSpanningTree.add(edge);
            return edge.getWeight();
        } else if (sourceSubset == -1 || destinationSubset == -1) {
            addToSubset(subsets, edge, Math.max(sourceSubset, destinationSubset));
            minSpanningTree.add(edge);
            return edge.getWeight();
        } else if (sourceSubset != destinationSubset) {
            unionSubsets(subsets, sourceSubset, destinationSubset);
            minSpanningTree.add(edge);
            return edge.getWeight();
        }

        return 0;
    }

    private void createNewSubset(List<Set<Integer>> subsets, TreeEdge edge) {
        Set<Integer> newSubset = new HashSet<>();
        newSubset.add(edge.getSource());
        newSubset.add(edge.getDestination());
        subsets.add(newSubset);
    }

    private void addToSubset(List<Set<Integer>> subsets, TreeEdge edge, int subsetIndex) {
        subsets.get(subsetIndex).add(edge.getSource());
        subsets.get(subsetIndex).add(edge.getDestination());
    }

    private void unionSubsets(List<Set<Integer>> subsets, int subsetIndex1, int subsetIndex2) {
        subsets.get(subsetIndex1).addAll(subsets.get(subsetIndex2));
        subsets.remove(subsetIndex2);

    }
    //endregion

    //region PRIM'S

    public int primAlgorithm(int[][] adjacencyMatrix, int nodeCount) {
        int totalCost = 0;
        int[] minSpanningTreeWeights = new int[nodeCount];
        int[] minSpanningTreeParents = new int[nodeCount];
        for (int i = 0; i < nodeCount; i++) {
            minSpanningTreeWeights[i] = Integer.MAX_VALUE;
            minSpanningTreeParents[i] = -1;
        }
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<PriorityPair> queue = new PriorityQueue<>();
        queue.offer(new PriorityPair(0, 0, -1));

        while (!queue.isEmpty()) {
            PriorityPair pair = queue.poll();
            if (visited.contains(pair.getNodeIndex()))
                continue;
            visited.add(pair.getNodeIndex());
            if (minSpanningTreeWeights[pair.getNodeIndex()] > pair.getWeight()) {
                minSpanningTreeWeights[pair.getNodeIndex()] = pair.getWeight();
                minSpanningTreeParents[pair.getNodeIndex()] = pair.getParentIndex();
            }
            for (int i = 0; i < adjacencyMatrix[pair.getNodeIndex()].length; i++) {
                if (visited.contains(i) || adjacencyMatrix[pair.getNodeIndex()][i] == 0)
                    continue;
                queue.offer(new PriorityPair(i, adjacencyMatrix[pair.getNodeIndex()][i], pair.getNodeIndex()));
            }
        }
        for (int w : minSpanningTreeWeights) {
            totalCost += w;
        }
        return totalCost;
    }
    //endregion

}
