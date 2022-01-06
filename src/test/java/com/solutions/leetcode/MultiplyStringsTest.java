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
    public String multiply(String num1, String num2) {
        String shortS;
        String longS;
        if(num1.length()<= num2.length()){
            shortS = num1;
            longS = num2;
        }else{
            shortS = num2;
            longS = num1;
        }
        int n = shortS.length();
        int m = longS.length();

        int[][] g = new int[n + m][n];

        int t = 0;
        for (int i = n - 1; i >= 0; i--) {
            int val1 = shortS.charAt(i) - '0';
            int r = 0;
            int s = t;
            for (int j = m - 1; j >= 0; j--) {
                int val2 = longS.charAt(j) - '0';
                int k = (val1 * val2) + r;
                int x = k % 10;
                if (k >= 10)
                    r = (k - x) / 10;
                else r = 0;
                g[s][t] = x;
                s++;
            }
            if(r>0)
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
        if(k==0)
            return "0";
        return sb.toString();
    }
}
