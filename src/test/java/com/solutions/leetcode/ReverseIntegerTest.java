package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-integer/
public class ReverseIntegerTest {
    @Test
    public void test_1() {
        int given = 321;
        int expected = 123;
        int result = reverse(given);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void test_2() {
        int given = 2147483647;
        int expected = 0;
        int result = reverse(given);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void test_3() {
        int given = -2147483648;
        int expected = 0;
        int result = reverse(given);
        Assertions.assertEquals(expected,result);
    }

    @Test
    public void test_4() {
        int given = -321;
        int expected = -123;
        int result = reverse(given);
        Assertions.assertEquals(expected,result);
    }

    public int reverse(int x) {
        boolean isNegative = x < 0;
        String given = String.valueOf(x);
        StringBuilder sb = new StringBuilder();
        for (Character val : given.toCharArray()) {
            if (val == '-') {
                continue;
            }
            sb.insert(0, val);
        }
        if(isNegative)
            sb.insert(0, '-');

        return parseInt(sb.toString());
    }

    private int parseInt(String text) {
        try {
            int x = Integer.parseInt(text);
            return x;
        } catch (Exception ex) {

        }
        return 0;
    }
}
