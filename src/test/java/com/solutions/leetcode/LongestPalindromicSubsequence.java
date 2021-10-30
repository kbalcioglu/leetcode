package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class LongestPalindromicSubsequence {

    /*
    https://leetcode.com/problems/longest-palindromic-subsequence/
    Given a string s, find the longest palindromic subsequence's length in s.
    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
    without changing the order of the remaining elements.
    */

    private void assertion(int expected, int result) {
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_s1() {
        String s = "bbbab";
        int expected = 4;

        int result = this.longestPalindromeSubseq_dp_topdown(s);
        int result2 = this.longestPalindromeSubseq_dp_bottomup(s);
        this.assertion(expected, result);
        this.assertion(expected, result2);
    }

    @Test
    public void test_2() {
        String s = "cbbd";
        int expected = 2;

        int result = this.longestPalindromeSubseq_dp_topdown(s);
        int result2 = this.longestPalindromeSubseq_dp_bottomup(s);
        this.assertion(expected, result);
        this.assertion(expected, result2);
    }

    public int longestPalindromeSubseq_dp_topdown(String s) {
        int n = s.length() - 1;
        int dp[][] = new int[s.length() + 1][s.length() + 1];

        return longestPalindrome(dp, s, 0, n);
    }

    public int longestPalindrome(int dp[][], String s, int i, int j) {
        if (i > j) {
            return 0;
        } else if (i == j) {
            return 1;
        } else if (dp[i][j] != 0) {
            return dp[i][j];
        } else if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = longestPalindrome(dp, s, i + 1, j - 1) + 2;
        } else {
            int left = longestPalindrome(dp, s, i, j - 1);
            int right = longestPalindrome(dp, s, i + 1, j);
            dp[i][j] = Integer.max(left, right);
        }
        return dp[i][j];
    }

    // yanlış çalışıyor
    public int longestPalindromeSubseq_dp_bottomup(String s) {
        int n = s.length();
        int dp[][] = new int[n][n];

        for (int i = 0; i <= n; i++) {
            dp[i][1] = 1;
        }
        for (int i = 2; i < n; i++) {
            for (int j = 1; j < n - i + 1; j++) {
                int k = j + i - 1;
                if (s.charAt(j) == s.charAt(k)) {
                    dp[j][i] = 2 + dp[j + 1][i - 2];
                } else {
                    int val1 = dp[j + 1][i - 1];
                    int val2 = dp[j][i - 1];
                    dp[j][i] = Math.max(val1, val2);
                }
            }
        }

        return dp[1][n-1];
    }
}

