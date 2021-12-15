package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BestTimeToBuyAndSellStock2Test {

    @Test
    public void test_1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] prices = {1, 2, 3, 4, 5};
        int expected = 4;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] prices = {7, 6, 4, 3, 1};
        int expected = 0;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] prices = {7, 1, 5, 8, 2, 1, 0, 4, 3, 9, 1, 1, 1};
        int expected = 17;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int[] prices = {7, 1, 0, 2, 1, 3, 0};
        int expected = 4;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        int[] prices = {7, 0, 3, 4, 10};
        int expected = 10;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    public int maxProfit(int[] prices) {
        int totalProfit = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                totalProfit += prices[i + 1] - prices[i];
            }
        }
        return totalProfit;
    }
}
