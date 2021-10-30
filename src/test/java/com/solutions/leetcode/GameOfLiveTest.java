package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class GameOfLiveTest {

    @Test
    public void firstTest() {
        int[][] board = new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        int[][] expectedBoard = new int[][]{
                {0, 0, 0},
                {1, 0, 1},
                {0, 1, 1},
                {0, 1, 0}
        };
        this.gameOfLife(board);

        int rowCount = board.length;
        int colCount = board[0].length;
        int eRowCount = board.length;
        int eColCount = board[0].length;

        Assertions.assertEquals(eRowCount, rowCount);
        Assertions.assertEquals(eColCount, colCount);

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                Assertions.assertEquals(expectedBoard[row][col], board[row][col]);
            }
        }

    }



    private void gameOfLife(int[][] board) {
        int rowCount = board.length;
        int colCount = board[0].length;
        int[][] tempBoard = new int[rowCount][colCount];
        for(int i = 0; i< rowCount;i++){
            tempBoard[i] = Arrays.copyOf(board[i], colCount);
        }

        for (int row = 0; row < rowCount; row++) {
            for (int col = 0; col < colCount; col++) {
                int val = tempBoard[row][col];
                int sum = this.sumOfNeighbours(col, row, tempBoard);
                if (val == 0 && sum == 3) {
                    board[row][col] = 1;
                } else if (val == 1 && sum >= 2 && sum <= 3) {
                    board[row][col] = 1;
                } else {
                    board[row][col] = 0;
                }
            }
        }
    }

    private int sumOfNeighbours(int col, int row, int[][] grid) {
        int rowCount = grid.length;
        int colCount = grid[0].length;
        int result = 0;
        if ((col - 1) >= 0) { // left
            result += grid[row][(col - 1)];
        }
        if ((col + 1) < colCount) { // right
            result += grid[row][(col + 1)];
        }
        if ((row - 1) >= 0) { // up
            result += grid[row - 1][col];
        }
        if ((row + 1) < rowCount) { // down
            result += grid[row + 1][col];
        }

        if ((col - 1) >= 0 && (row - 1) >= 0) { // left-up diagonal
            result += grid[row - 1][col - 1];
        }
        if ((col - 1) >= 0 && (row + 1) < rowCount) { // left-down diagonal
            result += grid[row + 1][col - 1];
        }
        if ((col + 1) < colCount && (row - 1) >= 0) { // right-up diagonal
            result += grid[row - 1][col + 1];
        }
        if ((col + 1) < colCount && (row + 1) < rowCount) { // right-down diagonal
            result += grid[row + 1][col + 1];
        }
        return result;
    }
}
