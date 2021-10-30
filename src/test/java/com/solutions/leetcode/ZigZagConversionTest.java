package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class ZigZagConversionTest {
    @Test
    public void test_2() {
        String s = "PAYPALISHIRING";
        int numRows = 4;
        String expected = "PINALSIGYAHRPI";
        String result = this.convert(s, numRows);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_1() {
        String s = "PAYPALISHIRING";
        int numRows = 3;
        String expected = "PAHNAPLSIIGYIR";
        String result = this.convert(s, numRows);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_3() {
        String s = "A";
        int numRows = 1;
        String expected = "A";
        String result = this.convert(s, numRows);
        Assertions.assertEquals(expected, result);

    }

    public String convert(String s, int numRows) {
        if (numRows <= 1)
            return s;
        StringBuilder sb = new StringBuilder();
        int k = numRows - 2;
        int m = numRows + k;
        int[] arr = new int[numRows];
        for (int j = 1; j <= k; j++) {
            arr[j] = 2 * j;
        }
        for (int i = 0; i < numRows; i++) {// i = 0 ->
            int index = i;
            while (index < s.length()) {
                sb.append(s.charAt(index));
                index += m;
                if (arr[i] > 0 && index - arr[i] >= 0 && index - arr[i] < s.length()) {
                    sb.append(s.charAt(index - arr[i]));
                }
            }
        }

        return sb.toString();
    }

    public String convert2(String s, int numRows) {
        StringBuilder sb = new StringBuilder();
        char grid[][] = new char[numRows][s.length()];
        int k = numRows - 2;
        int col = 0;
        int i = 0;
        while (i < s.length()) {
            int row = 0;
            while (i < s.length() && row < numRows) {
                grid[row][col] = s.charAt(i);
                row++;
                i++;
            }
            row--;
            for (int j = 0; j < k; j++) {
                if (i < s.length()) {
                    col++;
                    row--;
                    grid[row][col] = s.charAt(i);
                    i++;
                }
            }
            col++;
        }
        System.out.println(grid);
        for (int p = 0; p < grid.length; p++) {
            for (int r = 0; r < grid[p].length; r++) {
                if (grid[p][r] != 0)
                    sb.append(grid[p][r]);
            }
        }
        return sb.toString();
    }
}
