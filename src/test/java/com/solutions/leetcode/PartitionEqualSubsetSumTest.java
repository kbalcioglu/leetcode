package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class PartitionEqualSubsetSumTest {

    @Test
    public void test_1() {
        int[] nums = {1, 2, 3, 5};
        boolean result = canPartition(nums);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_2() {
        int[] nums = {1, 2, 3, 5, 7};
        boolean result = canPartition(nums);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_3() {
        int[] nums = {1, 5, 11, 5};
        boolean result = canPartition(nums);
        Assertions.assertTrue(result);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) return false;
        int half = sum / 2;

        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = nums.length - 1; i >= 0; i--) {
            Set<Integer> newSet = new HashSet<>();
            for (int k : set) {
                int n = k + nums[i];
                if (n == half) return true;
                newSet.add(n);
                newSet.add(k);
            }
            set = newSet;
        }

        return set.contains(half);

        //Map<String,Boolean> memo = new HashMap<>();
        //return control(nums,half,0,0,memo);

    }

    private boolean control(int[] nums, int half, int index, int sum, Map<String, Boolean> memo) {
        if (sum == half) return true;
        if (index >= nums.length) return false;

        String key = index + "@" + sum;
        if (memo.containsKey(key))
            return memo.get(key);

        boolean result = control(nums, half, index + 1, sum + nums[index], memo) || control(nums, half, index + 1, sum, memo);

        memo.put(key, result);
        return result;
    }
}
