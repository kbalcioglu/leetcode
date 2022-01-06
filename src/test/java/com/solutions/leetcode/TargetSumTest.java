package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/target-sum
public class TargetSumTest {
    @Test
    public void test_1() {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 7;
        int expected = 2;
        int result = findTargetSumWays(nums, target);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;
        int expected = 5;
        int result = findTargetSumWays(nums, target);
        Assertions.assertEquals(expected, result);
    }

    public int findTargetSumWays(int[] nums, int target) {
        int sumOfArray = 0;
        for (int i = 0; i < nums.length; i++) {
            sumOfArray += nums[i];
        }
        int sum = sumOfArray + target;
        if (sum < 0 || sum % 2 == 1)
            return 0;
        Map<String, Integer> memo = new HashMap<>();

        return dfs(nums, target, 0, 0, memo);
    }

    private int dfs(int[] nums, int target, int index, int sum, Map<String, Integer> memo) {
        if (index == nums.length) {
            if (sum == target)
                return 1;
            return 0;
        }
        String key = index + "@" + sum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int newSum = (dfs(nums, target, index + 1, sum + nums[index], memo) + dfs(nums, target, index + 1, sum - nums[index], memo));
        memo.put(key, newSum);
        return memo.get(key);
    }

    public int findTargetSumWays2(int[] arr, int diff) {

        int sumofArray = 0;
        for (int i = 0; i < arr.length; i++) {
            sumofArray += arr[i];
        }

        int sum = (diff + sumofArray) / 2;

        if (sumofArray + diff < 0 || (sumofArray + diff) % 2 == 1) { // point 1.
            return 0;
        }

        return countofSubsetSum(arr, sum);
    }

    public int countofSubsetSum(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0) {
                    t[i][j] = 0;
                }
                if (j == 0) {
                    t[i][j] = 1;
                }
            }
        }

        // 'j' started from zero to handle multiple zeros input edge case
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {  // point 3.
                if (arr[i - 1] <= j) {
                    t[i][j] = t[i - 1][j] + t[i - 1][j - arr[i - 1]];
                } else {
                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][sum];
    }
}
