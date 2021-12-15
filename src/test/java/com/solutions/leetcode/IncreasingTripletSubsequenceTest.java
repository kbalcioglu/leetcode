package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequenceTest {

    @Test
    public void test_1() {
        int[] nums = {1, 2, 3, 4, 5};
        boolean result = increasingTriplet(nums);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        int[] nums = {15, 4, 3, 2, 1};
        boolean result = increasingTriplet(nums);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_3() {
        int[] nums = {2, 1, 5, 0, 6};
        boolean result = increasingTriplet(nums);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_4() {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        boolean result = increasingTriplet(nums);
        Assertions.assertFalse(result);
    }

    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int n : nums) {
            if (first >= n)
                first = n;
            else if (second >= n)
                second = n;
            else
                return true;
        }
        return false;
    }
}
