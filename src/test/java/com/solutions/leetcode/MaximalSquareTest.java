package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class MaximalSquareTest {
    // https://leetcode.com/problems/maximal-square/
    // Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
    @Test
    public void test_1() {
        char[][] matrix = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        int expected = 4;
        int result = maximalSquare(matrix);
        Assertions.assertEquals(expected, result);
    }

    public int maximalSquare(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0)
            return 0;
        int cols = matrix[0].length;
        int[][] dp = new int[rows + 1][cols + 1];
        int largest = 0;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (matrix[i-1][j-1] == '1') {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest * largest;
    }

    public int maximalSquare2(char[][] matrix) {
        Set<String> checked = new HashSet<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int x = Math.min(m, n) + 1;
        boolean found = false;
        while (!found) {
            x--;
            found = checkNextSubMatrix(matrix, x);
        }

        return x * x;
    }

    private boolean checkNextSubMatrix(char[][] matrix, int x) {
        int endI = matrix.length - x + 1;
        int endJ = matrix[0].length - x + 1;

        for (int i = 0; i < endI; i++) {
            for (int j = 0; j < endJ; j++) {
                char[][] subMatrix = getSubMatrix(matrix, x, i, j);
                if (subMatrix != null)
                    return true;
            }
        }
        return false;
    }

    private char[][] getSubMatrix(char[][] matrix, int x, int startI, int startJ) {
        int endI = startI + x;
        int endJ = startJ + x;
        char[][] subMatrix = new char[x][x];
        int r = 0;
        for (int i = startI; i < endI; i++) {
            int c = 0;
            for (int j = startJ; j < endJ; j++) {
                if (matrix[i][j] == '0')
                    return null;
                subMatrix[r][c] = matrix[i][j];
                c++;
            }
            r++;
        }
        return subMatrix;
    }
}
