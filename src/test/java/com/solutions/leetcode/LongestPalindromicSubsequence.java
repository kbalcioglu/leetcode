package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

//https://leetcode.com/problems/longest-palindromic-subsequence/
public class LongestPalindromicSubsequence {

    /*

    Given a string s, find the longest palindromic subsequence's length in s.
    A subsequence is a sequence that can be derived from another sequence by deleting some or no elements
    without changing the order of the remaining elements.
    */

    private void assertion(int expected, int result) {
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_1() {
        String s = "bbbab";
        int expected = 4;

        int result = this.longestPalindromeSubseq(s);
        this.assertion(expected, result);
    }

    @Test
    public void test_2() {
        String s = "cbbd";
        int expected = 2;

        int result = this.longestPalindromeSubseq(s);
        this.assertion(expected, result);
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length() - 1;
        int dp[][] = new int[s.length() + 1][s.length() + 1];

        return longestPalindrome(dp, s, 0, n);
    }

    private int longestPalindrome(int dp[][], String s, int i, int j) {
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
}

