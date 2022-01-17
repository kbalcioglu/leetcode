package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UniqueBinarySearchTreesTest {

    @Test
    public void test_1() {
        int n = 3;
        int expected = 5;
        int result = numTrees(n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int n = 1;
        int expected = 1;
        int result = numTrees(n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int n = 0;
        int expected = 1;
        int result = numTrees(n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int n = 2;
        int expected = 2;
        int result = numTrees(n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int n = 4;
        int expected = 14;
        int result = numTrees(n);
        Assertions.assertEquals(expected, result);
    }

    public int numTrees(int n) {
        if (n == 0 || n == 1)
            return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < n + 1; i++) {
            int total = 0;
            for (int j = 1; j < i + 1; j++) {
                int left = j - 1;
                int right = i - j;
                total += dp[left] * dp[right];
            }
            dp[i] = total;
        }
        return dp[n];
    }
}
