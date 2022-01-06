package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
public class BestTimeToBuySellStocksWithCooldownTest {
    @Test
    public void test_1() {
        int[] prices = {1, 2, 3, 0, 2};
        int expected = 3;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] prices = {};
        int expected = 0;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] prices = {3};
        int expected = 0;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] prices = {4, 2};
        int expected = 0;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int[] prices = {1, 2, 3, 0, 2, 4};
        int expected = 5;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        int[] prices = {1, 1, 2, 0, 2, 4};
        int expected = 4;
        int result = maxProfit(prices);
        Assertions.assertEquals(expected, result);
    }

    public int maxProfit(int[] prices) {
        int[] buy = new int[prices.length];
        int[] sell = new int[prices.length];
        return dfs(prices, true, 0, buy, sell);

    }

    public int dfs(int[] prices, boolean buying, int index, int[] b, int[] s) {
        if (index >= prices.length) {
            return 0;
        }
        if (buying && b[index] != 0) {
            return b[index];
        }
        if (!buying && s[index] != 0) {
            return s[index];
        }

        if (buying) {
            int buy = dfs(prices, !buying, index + 1, b, s) - prices[index];
            int cooldown = dfs(prices, buying, index + 1, b, s);
            b[index] = Math.max(buy, cooldown);
            return b[index];
        } else {
            int sell = dfs(prices, !buying, index + 2, b, s) + prices[index];
            int cooldown = dfs(prices, buying, index + 1, b, s);
            s[index] = Math.max(sell, cooldown);
            return s[index];
        }
    }
}
