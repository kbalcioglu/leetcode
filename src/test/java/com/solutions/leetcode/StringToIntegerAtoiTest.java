package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/string-to-integer-atoi/
public class StringToIntegerAtoiTest {
    @Test
    public void test_1() {
        String given = "42";
        int expected = 42;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        String given = "-42";
        int expected = -42;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        String given = "    -42";
        int expected = -42;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        String given = " +4193 with words";
        int expected = 4193;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        String given = "words and 987";
        int expected = 0;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        String given = "-91283472332";
        int expected = -2147483648;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        String given = "+-12";
        int expected = 0;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_8() {
        String given = "-+12";
        int expected = 0;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_9() {
        String given = "00000-42a1234";
        int expected = 0;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_10() {
        String given = "   +   423";
        int expected = 0;
        int result = myAtoi(given);
        Assertions.assertEquals(expected, result);
    }

    public int myAtoi(String s) {
        boolean isSigned = false;
        boolean isNegative = false;
        StringBuilder sb = new StringBuilder();
        for (Character c : s.toCharArray()) {
            if (c == ' ' && sb.length() == 0 && !isSigned)
                continue;
            else if (c == ' ' && (sb.length() > 0 || isSigned))
                break;
            else if (sb.length() == 0 && !isSigned && (c == '-' || c == '+')) {
                isSigned = true;
                if (c == '-')
                    isNegative = true;
                continue;
            } else if (sb.length() == 0 && isSigned && (c == '-' || c == '+'))
                break;
            else if (!Character.isDigit(c))
                break;

            sb.append(c);
        }
        if (isNegative && sb.length() > 0)
            sb.insert(0, "-");
        return parseInt(sb.toString(), isNegative);
    }

    private int parseInt(String text, boolean isNegative) {
        if (text == null || text.trim().length() == 0)
            return 0;
        try {
            int x = Integer.parseInt(text);
            return x;
        } catch (Exception ex) {
            if (isNegative)
                return Integer.MIN_VALUE;
            return Integer.MAX_VALUE;
        }
    }
}
