package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OnesAndZerosTest {

    @Test
    public void test_1() {
        int m = 5;
        int n = 3;
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int expected = 4;
        int result = findMaxForm(strs, m, n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int m = 1;
        int n = 1;
        String[] strs = {"10", "0", "1"};
        int expected = 2;
        int result = findMaxForm(strs, m, n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int m = 9;
        int n = 3;
        String[] strs = {"111", "1000", "1000", "1000"};
        int expected = 3;
        int result = findMaxForm(strs, m, n);
        Assertions.assertEquals(expected, result);
    }

    public int findMaxForm2(String[] strs, int m, int n) {
        int result = 0;
        int[][][] dp = new int[m + 1][n + 1][strs.length];
        result = atMost(strs, m, n, 0, dp);
        return result;
    }

    public int atMost(String[] strs, int zero, int one, int index, int[][][] dp) {
        if (index >= strs.length || zero + one == 0)
            return 0;
        if (dp[zero][one][index] > 0)
            return dp[zero][one][index];

        int ones = strs[index].replace("0", "").length();
        int zeros = strs[index].length() - ones;

        int p = 0;
        if (zeros <= zero && ones <= one) {
            p = 1 + atMost(strs, zero - zeros, one - ones, index + 1, dp);
        }

        int q = atMost(strs, zero, one, index + 1, dp);
        dp[zero][one][index] = Math.max(p, q);
        return dp[zero][one][index];

    }

    public int findMaxForm(String[] strs, int m, int n) {
        int s = strs.length;

        int[][][] t = new int[s + 1][m + 1][n + 1];

        for (int i = 1; i < s + 1; i++) {

            int count1 = strs[i - 1].replace("0", "").length();
            int count0 = strs[i - 1].length() - count1;

            for (int j = 0; j < m + 1; j++) {
                for (int k = 0; k < n + 1; k++) {
                    if (count0 <= j && count1 <= k) {//string to be include or not
                        t[i][j][k] = Math.max(1 + t[i - 1][j - count0][k - count1], t[i - 1][j][k]);
                    } else //string not included not in my budget
                        t[i][j][k] = t[i - 1][j][k];
                }
            }
        }
        return t[s][m][n];
    }
}
