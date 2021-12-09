package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//https://leetcode.com/problems/count-sub-islands/
public class CountSubIslandsTest {


    @Test
    public void test_1() {
        int[][] grid1 = {{1, 1, 1, 0, 0}, {0, 1, 1, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};
        int[][] grid2 = {{1, 1, 1, 0, 0}, {0, 0, 1, 1, 1}, {0, 1, 0, 0, 0}, {1, 0, 1, 1, 0}, {0, 1, 0, 1, 0}};
        int expected = 3;
        int result = countSubIslands(grid1, grid2);
        Assertions.assertEquals(expected, result);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if (grid2 == null || grid2.length == 0 || grid1 == null || grid1.length == 0)
            return 0;
        if (grid1[0].length == 0 || grid2[0].length == 0)
            return 0;
        int countOfIslands = 0;
        Set<GridPoint> visited = new HashSet<>();

        for (int row = 0; row < grid2.length; row++) {
            for (int col = 0; col < grid2[0].length; col++) {
                GridPoint g = new GridPoint(row, col);
                int val = grid2[row][col];
                if (visited.contains(g) || val != 1)
                    continue;
                boolean isOk = expand(g, grid1, grid2, visited);
                if (isOk)
                    countOfIslands++;
            }
        }

        return countOfIslands;
    }

    private boolean expand(GridPoint g, int[][] grid1, int[][] grid2, Set<GridPoint> visited) {
        boolean isOk = true;
        visited.add(g);
        GridPoint left = g.left();
        if (pointInbound(grid2, left) && !visited.contains(left)) {
            isOk &= expand(left, grid1, grid2, visited);
        }
        GridPoint right = g.right();
        if (pointInbound(grid2, right) && !visited.contains(right)) {
            isOk &= expand(right, grid1, grid2, visited);
        }
        GridPoint up = g.up();
        if (pointInbound(grid2, up) && !visited.contains(up)) {
            isOk &= expand(up, grid1, grid2, visited);
        }
        GridPoint down = g.down();
        if (pointInbound(grid2, down) && !visited.contains(down)) {
            isOk &= expand(down, grid1, grid2, visited);
        }
        if (!pointInbound(grid1, g))
            return false;
        return isOk;
    }

    private boolean pointInbound(int[][] grid, GridPoint g) {
        if (g.row < 0 || g.row >= grid.length)
            return false;
        if (g.col < 0 || g.col >= grid[0].length)
            return false;
        if (grid[g.row][g.col] != 1)
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
