package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CoinChange2Test {

    @Test
    public void test_1() {
        int[] coins = {1, 2, 5};
        int amount = 5;
        int expected = 4;
        int result = change(amount, coins);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] coins = {1,2,5};
        int amount = 11;
        int expected = 11;
        int result = change(amount, coins);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] coins = {2,3,5};
        int amount = 11;
        int expected = 4;
        int result = change(amount, coins);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] coins = {2};
        int amount = 3;
        int expected = 0;
        int result = change(amount, coins);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int[] coins = {10};
        int amount = 10;
        int expected = 1;
        int result = change(amount, coins);
        Assertions.assertEquals(expected, result);
    }

    // Time : O(n*m), Space : O(n)
    public int change2(int amount, int[] coins) {
        if (amount == 0) return 1;


        int[] dp = new int[amount + 1];
        dp[0] = 1;

        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    // Time : O(n*m), Space : O(n*m)
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int left = j - coins[i] < 0 ? 0 : dp[i][j - coins[i]];
                int up = i - 1 < 0 ? 0 : dp[i - 1][j];
                dp[i][j] = left + up;
            }
        }
        return dp[coins.length - 1][amount];
    }
}
