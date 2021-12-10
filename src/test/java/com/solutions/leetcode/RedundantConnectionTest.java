package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/redundant-connection/
public class RedundantConnectionTest {
    /*
    In this problem, a tree is an undirected graph that is connected and has no cycles.
    You are given a graph that started as a tree with n nodes labeled from 1 to n, with one additional edge added.
    The added edge has two different vertices chosen from 1 to n, and was not an edge that already existed.
    The graph is represented as an array edges of length n where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the graph.
    Return an edge that can be removed so that the resulting graph is a tree of n nodes.
    If there are multiple answers, return the answer that occurs last in the input.

    there are n nodes and n edges. n node and n-1 edge is enough to be connected.
    */

    @Test
    public void test_1() {
        int[][] grid = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};
        int[] result = findRedundantConnection(grid);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[][] grid = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] expected = {1, 4};
        int[] result = findRedundantConnection(grid);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[][] grid = {{3, 4}, {1, 2}, {2, 4}, {3, 5}, {2, 5}};
        int[] expected = {2, 5};
        int[] result = findRedundantConnection(grid);
        Assertions.assertArrayEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[][] grid = {{9, 10}, {5, 8}, {2, 6}, {1, 5}, {3, 8}, {4, 9}, {8, 10}, {4, 10}, {6, 8}, {7, 9}};
        int[] expected = {4, 10};
        int[] result = findRedundantConnection(grid);
        Assertions.assertArrayEquals(expected, result);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            int parentX = find(x, parent), parentY = find(y, parent);
            if (parentX == parentY)
                return edge;
            else {
                parent[parentX] = parentY;

            }
        }

        return new int[]{-1, -1};
    }

    private int find(int val, int[] parent) {
        int parentVal = parent[val];
        if (parentVal == val)
            return parentVal;
        return parent[val] = find(parentVal,parent);
    }
}
