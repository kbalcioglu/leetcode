package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/decode-ways/
public class DecodeWaysTest {


    @Test
    public void test_3() {
        String s = "11106";
        int expected = 2;
        int result = numDecodings(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        String s = "10";
        int expected = 1;
        int result = numDecodings(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        String s = "12";
        int expected = 2;
        int result = numDecodings(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        String s = "226";
        int expected = 3;
        int result = numDecodings(s);
        Assertions.assertEquals(expected, result);
    }
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0')
            return 0;
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= s.length(); i++) {
            int j = i-1;
            if (s.charAt(j) == '0') {
                if ((s.charAt(j - 1) - '0') > 2 || s.charAt(j - 1) == '0') // can not be 30 or 00 invalid encode
                    return 0;
                else if (i - 2 < 0)
                    return 0;
                dp[i] = dp[i - 2];
            } else if ((s.charAt(j - 1) - '0') > 2)
                dp[i] = dp[i - 1];
            else if (s.charAt(j - 1) == '0')
                dp[i] = dp[i - 1];
            else if ((s.charAt(j) - '0') > 6 && s.charAt(j - 1) == '2')
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[s.length() ];
    }
}
