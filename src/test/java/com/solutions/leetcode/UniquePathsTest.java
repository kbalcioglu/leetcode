package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/unique-paths/
public class UniquePathsTest {
    // https://towardsdatascience.com/understanding-combinatorics-number-of-paths-on-a-grid-bddf08e28384
    // m x n grid. Length of path is same ==> m+n-2 ==> N
    // (m+n-2)! / (m-1)! * (n-1)!    ==> count of unique combinations


    @Test
    public void test_1() {
        int m = 3;
        int n = 7;
        int expected = 28;
        int result = uniquePaths(m, n);
        Assertions.assertEquals(expected, result);
    }


    public int uniquePaths(int m, int n) {
        long ans = 1;
        int s = m + n - 2;
        for (int i = s; i >= Math.max(m, n); i--) {
            ans *= i;
        }

        for (int i = 2; i < Math.min(m, n); i++) {
            ans /= i;
        }

        return (int) ans;

    }

    public int uniquePaths2(int m, int n) {
        int N = m + n - 2;
        int r = m - 1;
        double res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * (N - r + i) / i;
        }
        return (int) res;
    }
}
