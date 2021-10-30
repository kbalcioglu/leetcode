package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.LinkedList;
import java.util.Queue;

public class TestSnakeProblem {
    @Test
    public void firstTest() {
        int[][] grid = new int[][]{
                {0, 0, 0, 0, 0, 1},
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 1},
                {0, 0, 1, 0, 1, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0}
        };
        int result = this.minimumMoves(grid);
        Assertions.assertEquals(11, result);
    }
    @Test
    public void secondTest() {
        int[][] grid = new int[][]{
                {0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1},
                {1, 1, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 1},
                {1, 1, 1, 0, 0, 0}
        };
        int result = this.minimumMoves(grid);
        Assertions.assertEquals(9, result);
    }


    private int minimumMoves(int[][] grid) {
        var initSnake = new Snake(0, 0, 0, 1);
        Queue<Snake> snakeQueue = new LinkedList<>();
        snakeQueue.add(initSnake);
        while (!snakeQueue.isEmpty()) {
            Snake currentSnake = snakeQueue.poll();
            if (currentSnake.isFinished(grid.length)) {
                return currentSnake.moveCount;
            }
            Snake sRight = currentSnake.moveRight(grid);
            Snake sDown = currentSnake.moveDown(grid);
            Snake sClock = currentSnake.turnClockWise(grid);
            Snake sAClock = currentSnake.turnAntiClockWise(grid);
            if (sRight != null) {
                snakeQueue.offer(sRight);
            }
            if (sDown != null) {
                snakeQueue.offer(sDown);
            }
            if (sClock != null) {
                snakeQueue.offer(sClock);
            }
            if (sAClock != null) {
                snakeQueue.offer(sAClock);
            }
        }
        return -1;
    }
}

class Snake {
    int headRow;
    int headCol;
    int tailRow;
    int tailCol;
    int moveCount;

    Snake(int tailRow, int tailCol, int headRow, int headCol) {
        this.headRow = headRow;
        this.headCol = headCol;
        this.tailRow = tailRow;
        this.tailCol = tailCol;
        this.moveCount = 0;
    }

    Snake(int tailRow, int tailCol, int headRow, int headCol, int moveCount) {
        this.headRow = headRow;
        this.headCol = headCol;
        this.tailRow = tailRow;
        this.tailCol = tailCol;
        this.moveCount = moveCount;
    }

    public boolean isFinished(int n) {
        int position = n - 1;
        if (this.headRow == position && this.headCol == position && this.tailRow == position && this.tailCol == (position - 1)) {
            return true;
        }
        return false;
    }

    public boolean isValidPosition(int[][] grid) {
        if (this.tailRow < 0 || tailRow >= grid.length || this.tailCol < 0 || tailCol >= grid.length
                || this.headRow < 0 || headRow >= grid.length || this.headCol < 0 || headCol >= grid.length) {
            return false;
        }
        if (grid[this.tailRow][this.tailCol] == 1 || grid[this.headRow][this.headCol] == 1) {
            return false;
        }
        return true;
    }

    public Snake moveRight(int[][] grid) {
        int newHeadRow = this.headRow;
        int newHeadCol = this.headCol + 1;
        int newTailRow = this.tailRow;
        int newTailCol = this.tailCol + 1;
        int newMoveCount = this.moveCount + 1;
        if (newTailRow < 0 || newTailRow >= grid.length || newTailCol < 0 || newTailCol >= grid.length
                || newHeadRow < 0 || newHeadRow >= grid.length || newHeadCol < 0 || newHeadCol >= grid.length) {
            return null;
        }
        if (grid[newTailRow][newTailCol] == 1 || grid[newHeadRow][newHeadCol] == 1) {
            return null;
        }
        return new Snake(newTailRow, newTailCol, newHeadRow, newHeadCol, newMoveCount);
    }

    public Snake moveDown(int[][] grid) {
        int newHeadRow = this.headRow + 1;
        int newHeadCol = this.headCol;
        int newTailRow = this.tailRow + 1;
        int newTailCol = this.tailCol;
        int newMoveCount = this.moveCount + 1;
        if (newTailRow < 0 || newTailRow >= grid.length || newTailCol < 0 || newTailCol >= grid.length
                || newHeadRow < 0 || newHeadRow >= grid.length || newHeadCol < 0 || newHeadCol >= grid.length) {
            return null;
        }
        if (grid[newTailRow][newTailCol] == 1 || grid[newHeadRow][newHeadCol] == 1) {
            return null;
        }
        return new Snake(newTailRow, newTailCol, newHeadRow, newHeadCol, newMoveCount);
    }

    public Snake turnClockWise(int[][] grid) {
        if (this.tailRow != this.headRow || this.tailCol + 1 != this.headCol) {
            return null;
        }
        int newHeadRow = this.headRow + 1;
        int newHeadCol = this.headCol - 1;
        int newMoveCount = this.moveCount + 1;
        if (this.tailRow < 0 || this.tailRow >= grid.length || this.tailCol < 0 || this.tailCol >= grid.length
                || newHeadRow < 0 || newHeadRow >= grid.length || newHeadCol < 0 || newHeadCol >= grid.length) {
            return null;
        }
        if (grid[this.tailRow][this.tailCol] == 1 || grid[newHeadRow][newHeadCol] == 1) {
            return null;
        }
        return new Snake(this.tailRow, this.tailCol, newHeadRow, newHeadCol, newMoveCount);
    }

    public Snake turnAntiClockWise(int[][] grid) {
        if (this.tailRow + 1 != this.headRow || this.tailCol != this.headCol) {
            return null;
        }
        int newHeadRow = this.headRow - 1;
        int newHeadCol = this.headCol + 1;
        int newMoveCount = this.moveCount + 1;
        if (this.tailRow < 0 || this.tailRow >= grid.length || this.tailCol < 0 || this.tailCol >= grid.length
                || newHeadRow < 0 || newHeadRow >= grid.length || newHeadCol < 0 || newHeadCol >= grid.length) {
            return null;
        }
        if (grid[this.tailRow][this.tailCol] == 1 || grid[newHeadRow][newHeadCol] == 1) {
            return null;
        }
        return new Snake(this.tailRow, this.tailCol, newHeadRow, newHeadCol, newMoveCount);
    }
}

