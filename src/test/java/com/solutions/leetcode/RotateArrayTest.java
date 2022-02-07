package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RotateArrayTest {

    @Test
    public void test_1() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 2;
        rotate(nums, k);
        int[] expected = {4, 5, 1, 2, 3};
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void test_2() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 7;
        rotate(nums, k);
        int[] expected = {4, 5, 1, 2, 3};
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void test_3() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 12;
        rotate(nums, k);
        int[] expected = {4, 5, 1, 2, 3};
        Assertions.assertArrayEquals(expected, nums);
    }

    @Test
    public void test_4() {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 5;
        rotate(nums, k);
        int[] expected = {1, 2, 3, 4, 5};
        Assertions.assertArrayEquals(expected, nums);
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if (k == 0)
            return;
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        while (right > left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }

        left = 0;
        right = k - 1;
        while (right > left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }
        left = k;
        right = n - 1;
        while (right > left) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            right--;
            left++;
        }

    }
}
