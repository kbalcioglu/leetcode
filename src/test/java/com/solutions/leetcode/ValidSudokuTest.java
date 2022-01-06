package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ValidSudokuTest {

    @Test
    public void test_valid_1() {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = isValidSudoku(board);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_valid_2() {
        char[][] board = {{'1', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = isValidSudoku(board);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_invalid_1() {
        char[][] board = {{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = isValidSudoku(board);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_invalid_2() {
        char[][] board = {{'9', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        boolean result = isValidSudoku(board);
        Assertions.assertFalse(result);
    }

    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> areas = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            areas.add(new HashSet<>());
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.')
                    continue;
                if (rows.get(i).contains(c))
                    return false;
                rows.get(i).add(c);
                if (cols.get(j).contains(c))
                    return false;
                cols.get(j).add(c);
                int k = getAreaIndex(i, j);
                if (areas.get(k).contains(c))
                    return false;
                areas.get(k).add(c);
            }
        }
        return true;
    }


    private int getAreaIndex(int i, int j) {
        if (i >= 0 && i <= 2) {
            if (j >= 0 && j <= 2) {
                return 0;
            }
            else if (j >= 3 && j <= 5) {
                return 1;
            }
            else if (j >= 6 && j <= 8) {
                return 2;
            }
        }
        else if (i >= 3 && i <= 5) {
            if (j >= 0 && j <= 2) {
                return 3;
            }
            else if (j >= 3 && j <= 5) {
                return 4;
            }
            else if (j >= 6 && j <= 8) {
                return 5;
            }
        }
        else if (i >= 6 && i <= 8) {
            if (j >= 0 && j <= 2) {
                return 6;
            }
            else if (j >= 3 && j <= 5) {
                return 7;
            }
            else if (j >= 6 && j <= 8) {
                return 8;
            }
        }
        return 0;
    }
}
