package com.solutions.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//https://leetcode.com/problems/max-area-of-island/
public class MaxAreaOfIslandTest {
    /*
    You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
    You may assume all four edges of the grid are surrounded by water.
    The area of an island is the number of cells with a value 1 in the island.
    Return the maximum area of an island in grid. If there is no island, return 0.
    */
    @Test
    public void test_1() {
        int[][] grid = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int expected = 6;
        int result = maxAreaOfIsland(grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[][] grid = {{0, 0, 0, 0, 0, 0, 0, 0}};
        int expected = 0;
        int result = maxAreaOfIsland(grid);
        Assertions.assertEquals(expected, result);
    }

    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        if (grid[0].length == 0)
            return 0;
        int maxArea = 0;
        Set<GridPoint> visited = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                GridPoint g = new GridPoint(row, col);
                int val = grid[row][col];
                if (visited.contains(g) || val != 1)
                    continue;
                int area = calculate(g, grid, visited);
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    private int calculate(GridPoint g, int[][] grid, Set<GridPoint> visited) {
        int area = 0;
        visited.add(g);
        GridPoint left = g.left();
        if (pointInbound(grid, left) && !visited.contains(left) && grid[left.row][left.col] == 1) {
            area += calculate(left, grid, visited);
        }
        GridPoint right = g.right();
        if (pointInbound(grid, right) && !visited.contains(right) && grid[right.row][right.col] == 1) {
            area += calculate(right, grid, visited);
        }
        GridPoint up = g.up();
        if (pointInbound(grid, up) && !visited.contains(up) && grid[up.row][up.col] == 1) {
            area += calculate(up, grid, visited);
        }
        GridPoint down = g.down();
        if (pointInbound(grid, down) && !visited.contains(down) && grid[down.row][down.col] == 1) {
            area += calculate(down, grid, visited);
        }
        return area + 1;
    }

    private boolean pointInbound(int[][] grid, GridPoint g) {
        if (g.row < 0 || g.row >= grid.length)
            return false;
        if (g.col < 0 || g.col >= grid[0].length)
            return false;
        return true;
    }

    private static class GridPoint {
        int row;
        int col;

        public GridPoint(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public GridPoint left() {
            return new GridPoint(row, col - 1);
        }

        public GridPoint right() {
            return new GridPoint(row, col + 1);
        }

        public GridPoint up() {
            return new GridPoint(row - 1, col);
        }

        public GridPoint down() {
            return new GridPoint(row + 1, col);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            GridPoint gridPoint = (GridPoint) o;
            return row == gridPoint.row && col == gridPoint.col;
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, col);
        }
    }
}
