package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SumOfTwoIntegersTest {
    @Test
    public void test_1() {
        int a = 3;
        int b = 2;
        int expected = 5;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int a = 3;
        int b = -2;
        int expected = 1;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int a = 2;
        int b = -2;
        int expected = 0;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int a = 0;
        int b = 0;
        int expected = 0;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int a = 0;
        int b = -5;
        int expected = -5;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        int a = -8;
        int b = -5;
        int expected = -13;
        int result = getSum(a, b);
        Assertions.assertEquals(expected, result);
    }

    private int getSum(int a, int b) {
        int xor = a ^ b;
        int carry = a & b;
        if (carry == 0)
            return xor;
        else
            return getSum(xor, carry << 1);
    }
}
