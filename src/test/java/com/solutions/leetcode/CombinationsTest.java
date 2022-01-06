package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/combinations/submissions/
public class CombinationsTest {

    @Test
    public void test_1() {
        int n = 4;
        int k = 2;
        List<List<Integer>>  expected = List.of(List.of(1,2),List.of(1,3),List.of(1,4),List.of(2,3),List.of(2,4),List.of(3,4));
        List<List<Integer>>  ans = combine(n,k);
    }


    List<List<Integer>> result;
    public List<List<Integer>> combine(int n, int k) {
        result = new ArrayList<>();
        int x = n - k + 1;
        for (int i = 1; i <= x; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            dfs(i + 1, n, k, list);
        }
        return result;
    }

    private void dfs(int start, int end, int k, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < end + 1; i++) {
            list.add(i);
            dfs(i + 1, end, k, list);
            list.remove(list.size() - 1);
        }
    }

    static class Point {
        int m;
        int n;
        String word;
        StringBuilder sb;
        int row;
        int col;

        public Point(int row, int col, int m, int n, String word) {
            this.row = row;
            this.col = col;
            this.m = m;
            this.n = n;
            this.word = word;
            this.sb.append(word.charAt(0));
        }

        private Point(int row, int col, int m, int n, String word, char ch) {
            this.row = row;
            this.col = col;
            this.m = m;
            this.n = n;
            this.word = word;
            this.sb.append(ch);
        }

        public Point right(char[][] board) {
            int r = this.row;
            int c = this.col + 1;
            if (!isInBound(r, c))
                return null;
            char ch = board[r][c];
            Point p = new Point(r, c, this.m, this.n, this.word, ch);
            if (p.isCharValid())
                return p;
            return null;
        }

        public Point left(char[][] board) {
            int r = this.row;
            int c = this.col - 1;
            if (!isInBound(r, c))
                return null;
            char ch = board[r][c];
            Point p = new Point(r, c, this.m, this.n, this.word, ch);
            if (p.isCharValid())
                return p;
            return null;
        }

        public Point up(char[][] board) {
            int r = this.row - 1;
            int c = this.col;
            if (!isInBound(r, c))
                return null;
            char ch = board[r][c];
            Point p = new Point(r, c, this.m, this.n, this.word, ch);
            if (p.isCharValid())
                return p;
            return null;
        }

        public Point down(char[][] board) {
            int r = this.row + 1;
            int c = this.col;
            if (!isInBound(r, c))
                return null;
            char ch = board[r][c];
            Point p = new Point(r, c, this.m, this.n, this.word, ch);
            if (p.isCharValid())
                return p;
            return null;
        }

        private boolean isInBound(int row, int col) {
            return row >= 0 && row < this.m && col >= 0 && col < this.n;
        }

        private boolean isCharValid() {
            int k = sb.length();
            return word.substring(0, k).equals(sb.toString());
        }

        public boolean isFound() {
            return this.word.equals(sb.toString());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return row == point.row &&
                    col == point.col &&
                    sb.equals(point.sb);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sb, row, col);
        }
    }
}
