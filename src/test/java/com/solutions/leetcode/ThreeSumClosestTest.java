package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
public class ThreeSumClosestTest {
    @Test
    public void test_1() {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        int expected = 2;
        int result = threeSumClosest(nums, target);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] nums = {0, 0, 0};
        int target = 1;
        int expected = 0;
        int result = threeSumClosest(nums, target);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] nums = {1, 1, 1, 1};
        int target = 0;
        int expected = 3;
        int result = threeSumClosest(nums, target);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] nums = {0, 2, 1, -3};
        int target = 1;
        int expected = 0;
        int result = threeSumClosest(nums, target);
        Assertions.assertEquals(expected, result);
    }

    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3)
            return 0;
        if (nums.length == 3) {
            int val = nums[0] + nums[1] + nums[2];
            return val;
        }
        Arrays.sort(nums);
        int closestSum = 5000;
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int sum = 0;
            while (right > left) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    closestSum = sum;
                    break;
                } else {
                    int difference = Math.abs(sum - target);
                    int differenceClosest = Math.abs(closestSum - target);
                    if (difference < differenceClosest)
                        closestSum = sum;
                    if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return closestSum;
    }
}
