package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SurroundedRegionsTest {
    /*
    {{'X','X','X','X'},{'X','X','O','X'},{'O','O','X','X'},{'O','O','X','X'}}
    {{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}
    {{'X'}}
    {{'O'}}
    {{'X','X','X','X'},{'X','O','O','X'},{'O','O','X','X'},{'O','O','X','X'}}
    */
    @Test
    public void test_1() {
        char[][] board = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'O', 'O', 'X', 'X'}, {'O', 'O', 'X', 'X'}};
        printBoard(board);
        solve(board);
        printBoard(board);
    }

    private void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (j > 0)
                    System.out.print(",");
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("**************");
    }
    private static final int[][] directions = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void solve(char[][] board) {
        int width = board[0].length - 1;
        int firstRow = 0;
        int lastRow = board.length - 1;
        int firstCol = 0;
        int lastCol = board[0].length - 1;

        List<Position> list = new ArrayList<>();
        List<Position> list2 = new ArrayList<>();

        for (int i = firstCol; i <= lastCol; i++) {
            if (board[firstRow][i] == 'O') {
                board[firstRow][i] = 'K';
                list.add(new Position(firstRow, i));
            }
        }

        for (int i = firstRow; i <= lastRow; i++) {
            if (board[i][lastCol] == 'O') {
                board[i][lastCol] = 'K';
                list.add(new Position(i, lastCol));
            }
        }

        for (int i = firstCol; i <= lastCol; i++) {
            if (board[lastRow][i] == 'O') {
                board[lastRow][i] = 'K';
                list.add(new Position(lastRow, i));
            }
        }

        for (int i = firstRow; i <= lastRow; i++) {
            if (board[i][firstCol] == 'O') {
                board[i][firstCol] = 'K';
                list.add(new Position(i, firstCol));
            }
        }

        for (Position p : list) {
            board[p.getRow()][p.getCol()] = 'O';
            dfs(board, p, list2);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }
        for(Position p : list2){
            board[p.getRow()][p.getCol()] = 'O';
        }

    }

    private void dfs(char[][] board, Position p, List<Position> list) {
        if (p.getRow() < 0 || p.getCol() < 0 || p.getRow() >= board.length || p.getCol() >= board[0].length)
            return;
        if (board[p.getRow()][p.getCol()] != 'O')
            return;

        board[p.getRow()][p.getCol()] = 'K';
        list.add(p);
        for (int[] direction : directions) {
            Position newPosition = p.move(direction);
            dfs(board, newPosition, list);
        }
    }

    static class Position {
        private int row;
        private int col;

        Position(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return this.row;
        }

        public int getCol() {
            return this.col;
        }

        public Position move(int[] direction) {
            return new Position(this.row + direction[0], this.col + direction[1]);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return this.row == position.getRow() &&
                    this.col == position.getCol();
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
