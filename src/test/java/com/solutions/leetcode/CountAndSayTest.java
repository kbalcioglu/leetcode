package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountAndSayTest {

    @Test
    public void test_1() {
        int n = 1;
        String expected = "1";
        String result = countAndSay(n);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int n = 4;
        String expected = "1211";
        String result = countAndSay(n);
        Assertions.assertEquals(expected, result);
    }

    public String countAndSay(int n) {
        if (n == 1)
            return "1";
        String s = countAndSay(n - 1);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        char prev = '#';
        for (int i = 0; i < s.length(); i++) {
            if (prev == '#' ) {
                prev = s.charAt(i);
                count++;
            }else if (prev == s.charAt(i)) {
                count++;
            }else{
                sb.append(count);
                sb.append(prev);
                prev = s.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(prev);
        return sb.toString();
    }
}
