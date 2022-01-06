package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CoinChangeTest {

    @Test
    public void test_1() {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int expected = 3;
        int result = coinChange(coins, amount);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] coins = {3, 2, 5};
        int amount = 11;
        int expected = 3;
        int result = coinChange(coins, amount);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] coins = {3, 2, 5};
        int amount = 0;
        int expected = 0;
        int result = coinChange(coins, amount);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] coins = {2};
        int amount = 3;
        int expected = -1;
        int result = coinChange(coins, amount);
        Assertions.assertEquals(expected, result);
    }

    // bestSum
    public int coinChange(int[] coins, int sum) {
        int[] table = new int[sum + 1];
        for (int i = 0; i <= sum; i++) {
            table[i] = -1;
        }
        table[0] = 0;
        for (int i = 0; i <= sum; i++) {
            if (table[i] >= 0) {
                for (int coin : coins) {
                    int newCombination = table[i] + 1;
                    int nextIndex = i + coin;
                    if (nextIndex >= 0 && nextIndex < table.length) {
                        if (table[nextIndex] == -1)
                            table[nextIndex] = newCombination;
                        else if (table[nextIndex] > newCombination)
                            table[nextIndex] = newCombination;
                    }
                }
            }
        }
        return table[sum];
    }
}
