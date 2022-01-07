package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/multiply-strings
public class MultiplyStringsTest {

    @Test
    public void test_6() {
        String num1 = "456";
        String num2 = "123";
        String expected = "56088";
        String result = multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        String num1 = "123";
        String num2 = "456";
        String expected = "56088";
        String result = multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_8() {
        String num1 = "9999";
        String num2 = "0";
        String expected = "0";
        String result = multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_9() {
        String num1 = "9999";
        String num2 = "9999";
        String expected = "99980001";
        String result = multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_10() {
        String num1 = "408";
        String num2 = "5";
        String expected = "2040";
        String result = multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    public String multiply2(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();

        int[][] g = new int[n + m][n];

        int t = 0;
        for (int i = n - 1; i >= 0; i--) {
            int val1 = num1.charAt(i) - '0';
            int r = 0;
            int s = t;
            for (int j = m - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                int k = (val1 * val2) + r;
                int x = k % 10;
                if (k >= 10)
                    r = (k - x) / 10;
                else r = 0;
                g[s][t] = x;
                s++;
            }
            if (r > 0)
                g[s][t] = r;
            t++;
        }
        StringBuilder sb = new StringBuilder();
        int remainer = 0;
        int k = 0;
        for (int i = 0; i < g.length; i++) {
            for (int j : g[i]) {
                remainer += j;
            }
            int x = remainer % 10;
            if (remainer >= 10)
                remainer = (remainer - x) / 10;
            else remainer = 0;
            if (i == g.length - 1 && x == 0 && remainer == 0)
                continue;
            k += x;
            sb.insert(0, x);
        }
        if (k == 0)
            return "0";
        return sb.toString();
    }

    public String multiply(String num1, String num2) {
        int n = num1.length();
        int m = num2.length();
        int[] g = new int[n + m];

        int index = 0;
        for (int i = n - 1; i >= 0; i--) {
            int gIndex = index;
            int val1 = num1.charAt(i) - '0';
            int remainderMultiply = 0;
            for (int j = m - 1; j >= 0; j--) {
                int val2 = num2.charAt(j) - '0';
                int k = (val1 * val2) + remainderMultiply;
                int x = k % 10;
                if (k >= 10)
                    remainderMultiply = (k - x) / 10;
                else remainderMultiply = 0;

                addToTable(g, gIndex, x);
                gIndex++;
            }
            if (remainderMultiply > 0) {
                addToTable(g, gIndex, remainderMultiply);
            }
            index++;
        }
        StringBuilder sb = new StringBuilder();
        boolean foundStart = false;
        for (int i = g.length - 1; i >= 0; i--) {
            if (!foundStart && g[i] == 0)
                continue;
            foundStart = true;
            sb.append(g[i]);
        }
        if (sb.length() == 0)
            sb.append("0");
        return sb.toString();
    }

    private void addToTable(int[] g, int gIndex, int addValue) {
        int remainderSum = 0;
        int val = g[gIndex];
        val = val + addValue;
        if (val < 10)
            g[gIndex] = val;
        else {
            int rIndex = gIndex;
            while (val >= 10) {
                int t = val % 10;
                remainderSum = (val - t) / 10;
                g[rIndex++] = t;
                val = g[rIndex] + remainderSum;
            }
            g[rIndex] = val;
        }
    }
}
