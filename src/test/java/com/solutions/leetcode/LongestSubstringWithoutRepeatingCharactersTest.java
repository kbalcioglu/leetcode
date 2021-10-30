package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void test_1() {
        String s = "abcabcbb";
        // abc
        int expected = 3;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_2() {
        String s = "bbbb";
        // b
        int expected = 1;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_3() {
        String s = "pwwkew";
        // wke
        int expected = 3;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    public int lengthOfLongestSubstring(String s) {
        Set<String> visited = new HashSet<>();
        int result = 0;
        result = dfs(s, visited, result);
        return result;
    }

    private int dfs(String s, Set<String> visited, int max) {
        return max;
    }
    public int dfs(int dp[][], String s, int i, int j) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return 1;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        } else if (s.charAt(i) == s.charAt(j)) {
            int left = dfs(dp, s, i, j - 1);
            int right = dfs(dp, s, i + 1, j);
            dp[i][j] = Integer.max(left, right);
        } else {
            dp[i][j] = dfs(dp, s, i + 1, j - 1) + 11;
        }
        return dp[i][j];
    }
}
