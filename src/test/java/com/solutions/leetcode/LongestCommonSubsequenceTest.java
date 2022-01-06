package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LongestCommonSubsequenceTest {

    @Test
    public void test_1() {
        String text1 = "abcde";
        String text2 = "ace";
        int expected = 3;
        int result = longestCommonSubsequence(text1, text2);
        Assertions.assertEquals(expected, result);
    }

    // iterative O(n*m)
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for(int i = text1.length()-1; i>= 0; i--){
            for(int j = text2.length()-1; j>= 0; j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    dp[i][j]= 1 + dp[i+1][j+1];
                }else{
                    dp[i][j]= Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }
        return dp[0][0];

        //return dfs(text1,text2,dp,0,0);
    }

    // Recursive O(n*m)
    public int longestCommonSubsequence2(String text1, String text2) {
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        return dfs(text1, text2, dp, 0, 0);
    }

    private int dfs(String text1, String text2, int[][] dp, int x, int y) {

        if (x >= text1.length() || y >= text2.length())
            return 0;
        if (dp[x][y] > 0)
            return dp[x][y];

        if (text1.charAt(x) == text2.charAt(y)) {
            dp[x][y] = 1 + dfs(text1, text2, dp, x + 1, y + 1);
        } else {
            dp[x][y] = Math.max(dfs(text1, text2, dp, x, y + 1), dfs(text1, text2, dp, x + 1, y));
        }
        return dp[x][y];
    }
}
