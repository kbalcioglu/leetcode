package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class WordSearchTest {
    @Test
    public void test_1() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
        boolean result = exist(board, word);
        Assertions.assertTrue(result);
    }
    @Test
    public void test_2() {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        boolean result = exist(board, word);
        Assertions.assertFalse(result);
    }
    @Test
    public void test_3() {
        char[][] board = {{'a', 'a'}};
        String word = "aa";
        boolean result = exist(board, word);
        Assertions.assertTrue(result);
    }
    @Test
    public void test_4() {
        char[][] board = {{'a'}, {'a'}};
        String word = "aa";
        boolean result = exist(board, word);
        Assertions.assertTrue(result);
    }
    @Test
    public void test_5() {
        char[][] board = {{'A','B','C','D'}, {'D','A','B','A'},{'C','A','A','D'}};
        String word = "ABCBAB";
        boolean result = exist(board, word);
        Assertions.assertFalse(result);
    }

    public boolean exist(char[][] board, String word) {
        if(board.length * board[0].length < word.length()) return false;

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }


    public boolean search(char[][] board, String word, int x, int y, int index){
        if(index == word.length()) {
            return true;
        }
        if(x >= board.length || x < 0 || y >= board[0].length || y < 0){
            return false;
        }
        if(board[x][y] != word.charAt(index)){
            return false;
        }

        char temp = board[x][y];
        board[x][y] = ' ';
        boolean found = search(board, word, x+1, y, index+1)
                || search(board, word, x, y+1, index+1)
                || search(board, word, x-1, y, index+1)
                || search(board, word, x, y-1, index+1);
        board[x][y] = temp;
        return found;
    }

    public boolean exist2(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char init = word.charAt(0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == init) {
                    Pointt p = new Pointt(i, j, m, n, word);
                    if(exists2(p,board)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean exists2(Pointt start, char[][] board){
        Set<Pointt> offered = new HashSet<>();
        offered.add(start);
        Queue<Pointt> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            Pointt p = queue.poll();
            if (p.isFound())
                return true;
            Pointt left = p.left(board);
            if (left != null) {
                if(left.isFound())
                    return true;
                if (!offered.contains(left)){
                    queue.offer(left);
                    offered.add(left);
                }
            }
            Pointt right = p.right(board);
            if (right != null) {
                if(right.isFound())
                    return true;
                if (!offered.contains(right)){
                    queue.offer(right);
                    offered.add(right);
                }
            }
            Pointt up = p.up(board);
            if (up != null) {
                if(up.isFound())
                    return true;
                if (!offered.contains(up)){
                    queue.offer(up);
                    offered.add(up);
                }
            }
            Pointt down = p.down(board);
            if (down != null) {
                if(down.isFound())
                    return true;
                if (!offered.contains(down)){
                    queue.offer(down);
                    offered.add(down);
                }
            }
        }
        return false;
    }
    static class Pointt {
        Set<String> track;
        int m;
        int n;
        String word;
        StringBuilder sb;
        int row;
        int col;

        private String key(int row, int col){
            return row + "@" + col;
        }
        Pointt(int row, int col, int m, int n, String word) {
            this.track = new HashSet<>();
            this.sb = new StringBuilder();
            this.row = row;
            this.col = col;
            this.m = m;
            this.n = n;
            this.word = word;
            this.sb.append(word.charAt(0));
            this.track.add(key(row,col));
        }

        private Pointt(int row, int col, int m, int n, String word, StringBuilder sb,Set<String> track, char ch) {
            this.row = row;
            this.col = col;
            this.m = m;
            this.n = n;
            this.word = word;
            this.sb = new StringBuilder(sb);
            this.sb.append(ch);
            this.track = new HashSet<>(track);
            this.track.add(key(row,col));
        }

        private Pointt getPoint(int row, int col,char[][] board){
            if(this.track.contains(key(row,col)))
                return null;
            if (!isInBound(row, col))
                return null;
            char ch = board[row][col];
            Pointt p = new Pointt(row, col, this.m, this.n, this.word, this.sb,this.track, ch);
            if (!p.isCharValid())
                return null;
            return p;
        }

        public Pointt right(char[][] board) {
            int r = this.row;
            int c = this.col + 1;
            return getPoint(r,c,board);
        }

        public Pointt left(char[][] board) {
            int r = this.row;
            int c = this.col - 1;
            return getPoint(r,c,board);
        }

        public Pointt up(char[][] board) {
            int r = this.row - 1;
            int c = this.col;
            return getPoint(r,c,board);
        }

        public Pointt down(char[][] board) {
            int r = this.row + 1;
            int c = this.col;
            return getPoint(r,c,board);
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
            Pointt pointt = (Pointt) o;
            return row == pointt.row &&
                    col == pointt.col &&
                    sb.equals(pointt.sb);
        }

        @Override
        public int hashCode() {
            return Objects.hash(sb, row, col);
        }
    }
}
