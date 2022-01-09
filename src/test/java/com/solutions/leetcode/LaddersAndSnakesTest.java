package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/snakes-and-ladders/
public class LaddersAndSnakesTest {

    @Test
    public void test_point_of_index_1() {
        int n = 6;
        List<Integer> given = List.of(12, 13, 7, 18, 23, 14, 27, 5);
        List<Integer> expectedRow = List.of(4, 3, 4, 3, 2, 3, 1, 5);
        List<Integer> expectedCol = List.of(0, 0, 5, 5, 1, 1, 2, 4);

        for (int i = 0; i < given.size(); i++) {
            var point = getPointOfIndex(given.get(i), n);
            Assertions.assertEquals(expectedRow.get(i), point.getRow());
            Assertions.assertEquals(expectedCol.get(i), point.getCol());
        }
    }

    @Test
    public void test_point_of_index_2() {
        int n = 4;
        List<Integer> given = List.of(16, 1, 4, 13, 9, 12, 8, 5, 15, 11, 7, 3);
        List<Integer> expectedRow = List.of(0, 3, 3, 0, 1, 1, 2, 2, 0, 1, 2, 3);
        List<Integer> expectedCol = List.of(0, 0, 3, 3, 0, 3, 0, 3, 1, 2, 1, 2);
        for (int i = 0; i < given.size(); i++) {
            var point = getPointOfIndex(given.get(i), n);
            Assertions.assertEquals(expectedRow.get(i), point.getRow());
            Assertions.assertEquals(expectedCol.get(i), point.getCol());
        }
    }

    @Test
    public void test_game_1() {
        int[][] board = {{-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 35, -1, -1, 13, -1}, {-1, -1, -1, -1, -1, -1}, {-1, 15, -1, -1, -1, -1}};
        int expected = 4;
        int result = snakesAndLadders(board);
        Assertions.assertEquals(expected, result);
    }

    //[[-1,-1,-1],[-1,9,8],[-1,8,9]]
    @Test
    public void test_game_2() {
        int[][] board = {{-1, -1, -1}, {-1, 9, 8}, {-1, 8, 9}};
        int expected = 1;
        int result = snakesAndLadders(board);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_game_3() {
        int n = 14;
        int[][] board = {
                {-1, -1, -1, -1, 11, -1, 147, -1, 134, -1, 169, -1, -1, -1}, // [196 - 183]
                {-1, 64, -1, -1, -1, -1, -1, -1, -1, -1, 81, -1, 138, -1}, // [169 - 182]
                {-1, 66, -1, 65, -1, -1, 2, -1, 125, -1, -1, -1, -1, 190}, // [168 - 155]
                {-1, -1, -1, -1, 27, -1, 100, -1, -1, -1, 179, 147, -1, -1}, // [141 - 154]
                {-1, -1, -1, -1, 89, -1, 32, -1, 175, 62, 137, 175, 135, -1}, // [140 - 127]
                {-1, -1, -1, 7, 64, -1, -1, 122, -1, -1, -1, -1, -1, 15}, // [113 - 126]
                {-1, 21, -1, -1, -1, 103, -1, -1, -1, -1, 31, -1, -1, -1}, // [112 - 99]
                {-1, -1, 122, -1, -1, -1, 127, -1, -1, -1, 30, -1, 65, -1}, //[85 - 98]
                {-1, 196, -1, -1, -1, -1, -1, -1, -1, -1, 34, -1, 179, 116}, // [84 - 71]
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, // [57 - 70]
                {-1, -1, -1, -1, -1, 4, 138, 44, -1, -1, -1, -1, -1, -1}, // [56-43]
                {73, 26, -1, 33, -1, -1, -1, -1, -1, -1, 114, -1, 166, -1}, //[29-42]
                {-1, -1, -1, -1, -1, -1, -1, -1, -1, 57, -1, 78, 70, 144}, // [28-15]
                {-1, 28, -1, 151, 64, 5, -1, 23, -1, -1, -1, 85, -1, 79} // [1-14]
        };
        // 151 - 72
        // 179
        // 83 -> 196

        var p1 = getPointOfIndex(196, 14);
        int v1 = board[p1.getRow()][p1.getCol()];
        var p2 = getPointOfIndex(83, 14);
        int v2 = board[p2.getRow()][p2.getCol()];
        var p3 = getPointOfIndex(12, 14);
        int v3 = board[p3.getRow()][p3.getCol()];
        var p4 = getPointOfIndex(7, 14);
        int v4 = board[p4.getRow()][p4.getCol()];

        int expected = 3;
        int result = snakesAndLadders(board);
        Assertions.assertEquals(expected, result);
    }


    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int lastIndex = n * n;
        Queue<Position> queue = new LinkedList<>();
        Set<Position> offered = new HashSet<>();
        Position start = new Position(1, 0);
        queue.offer(start);
        offered.add(start);

        while (!queue.isEmpty()) {
            Position current = queue.poll();
            if (lastIndex == current.getIndex())
                return current.getMoveCount();
            for (int i = 1; i < 7; i++) {
                Position newPosition = current.move(i);
                if (newPosition.getIndex() > lastIndex)
                    continue;
                Point point = getPointOfIndex(newPosition.getIndex(), n);
                if (!pointInBound(n, point))
                    continue;
                int nextIndex = board[point.getRow()][point.getCol()];
                if (nextIndex > 0 && nextIndex == lastIndex)
                    return newPosition.getMoveCount();
                if (nextIndex > 0)
                    newPosition = newPosition.jump(nextIndex);
                if ( newPosition.getIndex() == lastIndex)
                    return newPosition.getMoveCount();
                if (!offered.contains(newPosition)) {
                    queue.offer(newPosition);
                    offered.add(newPosition);
                }
            }
        }

        return -1;
    }

    private Point getPointOfIndex(int index, int n) {
        int rowIndex = (index - 1) / n;
        int rowIndexInverted = Math.abs(rowIndex - (n - 1));
        int colIndex = (index - 1) % n;
        if (rowIndex % 2 != 0) {
            colIndex = n - 1 - colIndex;
        }
        return new Point(rowIndexInverted, colIndex);
    }

    private boolean pointInBound(int n, Point p) {
        return p.getCol() >= 0 && p.getCol() < n && p.getRow() >= 0 && p.getRow() < n;
    }

    static class Position {
        private final int index;
        private final int moveCount;

        public Position(int index) {
            this.index = index;
            this.moveCount = 0;
        }

        private Position(int index, int moveCount) {
            this.index = index;
            this.moveCount = moveCount;
        }

        public int getIndex() {
            return index;
        }

        public int getMoveCount() {
            return moveCount;
        }

        Position move(int dice) {
            return new Position(this.index + dice, this.moveCount + 1);
        }

        Position jump(int index) {
            return new Position(index, this.moveCount);
        }

        Position jumpMove(int index) {
            return new Position(index, this.moveCount +1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return index == position.index;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index);
        }
    }

    static class Point {
        private final int row;
        private final int col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public int getRow() {
            return row;
        }

        public int getCol() {
            return col;
        }
    }

}
