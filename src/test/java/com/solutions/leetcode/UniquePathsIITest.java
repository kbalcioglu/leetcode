package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://leetcode.com/problems/unique-paths-ii/submissions/
public class UniquePathsIITest {


    @Test
    public void test_1() {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        int expected = 2;
        int result = uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[][] obstacleGrid = {{0, 1}, {0, 0}};
        int expected = 1;
        int result = uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[][] obstacleGrid = {{1}};
        int expected = 0;
        int result = uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[][] obstacleGrid = {{1, 0}};
        int expected = 0;
        int result = uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int[][] obstacleGrid = {{0, 0}, {1, 1}, {0, 0}};
        int expected = 0;
        int result = uniquePathsWithObstacles(obstacleGrid);
        Assertions.assertEquals(expected, result);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return -1;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;
        int[][] dp = new int[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                if (obstacleGrid[i][j] == 1)
                    dp[i][j] = 0;
                else {
                    if (i == 0 && j == 0)
                        dp[i][j] = 1;
                    else if (i == 0) {
                        dp[i][j] = dp[i][j - 1];
                    } else if (j == 0) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                    }
                }

            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0)
            return -1;

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1)
            return 0;
        if (obstacleGrid[m - 1][n - 1] == 1)
            return 0;

        int result = 0;
        Set<Position> visited = new HashSet<>();
        Position p = new Position(0, 0);
        LinkedList<Position> queue = new LinkedList<>();
        queue.offer(p);

        while (!queue.isEmpty()) {
            Position curr = queue.poll();
            visited.add(curr);
            if (isFinished(curr, obstacleGrid))
                result++;

            Position down = curr.moveDown();
            if (isValid(down, obstacleGrid) && !visited.contains(down))
                queue.offer(down);

            Position right = curr.moveRight();
            if (isValid(right, obstacleGrid) && !visited.contains(right))
                queue.offer(right);

        }

        return result;
    }

    private boolean isValid(Position p, int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return p.row >= 0 && p.row < m && p.col >= 0 && p.col < n && obstacleGrid[p.row][p.col] == 0;
    }

    private boolean isFinished(Position p, int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        return isValid(p, obstacleGrid) && p.row == m - 1 && p.col == n - 1;
    }

    static class Position {
        int row;
        int col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Position moveDown() {
            return new Position(this.row + 1, this.col);
        }

        public Position moveRight() {
            return new Position(this.row, this.col + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (o == null)
                return false;
            if (!(o instanceof Position))
                return false;
            Position p = (Position) o;
            return p.row == this.row && p.col == this.col;
        }

        @Override
        public int hashCode() {
            int hash = 31;
            hash = 31 * hash + this.row;
            hash = 31 * hash + this.col;
            return hash;
        }
    }
}
