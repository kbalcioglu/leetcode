package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

//https://leetcode.com/problems/number-of-islands/
public class NumberOfIslandsTest {
    /*
    Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
    An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
    You may assume all four edges of the grid are all surrounded by water.
    */
    @Test
    public void test_1() {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        int expected = 1;
        int result = numIslands(grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        char[][] grid = {{'0', '0', '0', '0', '0'}};
        int expected = 0;
        int result = numIslands(grid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        int expected = 3;
        int result = numIslands(grid);
        Assertions.assertEquals(expected, result);
    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        if (grid[0].length == 0)
            return 0;
        int countOfIslands = 0;
        Set<GridPoint> visited = new HashSet<>();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                GridPoint g = new GridPoint(row, col);
                int val = grid[row][col];
                if (visited.contains(g) || val != '1')
                    continue;
                expand(g, grid, visited);
                countOfIslands++;
            }
        }

        return countOfIslands;
    }

    private void expand(GridPoint g, char[][] grid, Set<GridPoint> visited) {
        visited.add(g);
        GridPoint left = g.left();
        if (pointInbound(grid, left) && !visited.contains(left) && grid[left.row][left.col] == '1') {
            expand(left, grid, visited);
        }
        GridPoint right = g.right();
        if (pointInbound(grid, right) && !visited.contains(right) && grid[right.row][right.col] == '1') {
            expand(right, grid, visited);
        }
        GridPoint up = g.up();
        if (pointInbound(grid, up) && !visited.contains(up) && grid[up.row][up.col] == '1') {
            expand(up, grid, visited);
        }
        GridPoint down = g.down();
        if (pointInbound(grid, down) && !visited.contains(down) && grid[down.row][down.col] == '1') {
            expand(down, grid, visited);
        }
    }

    private boolean pointInbound(char[][] grid, GridPoint g) {
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
