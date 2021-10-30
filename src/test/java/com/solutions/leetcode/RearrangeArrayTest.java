package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

//https://leetcode.com/problems/array-with-elements-not-equal-to-average-of-neighbors/
public class RearrangeArrayTest {
    @Test
    public void test_1() {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = this.rearrangeArray(nums);
        for (int i = 1; i < result.length - 1; i++) {
            int val = result[i] * 2;
            int val2 = result[i - 1] + result[i + 1];
            Assertions.assertEquals(false, val == val2);
        }
    }

    @Test
    public void test_2() {
        int[] nums = {6, 2, 0, 9, 7};
        int[] result = this.rearrangeArray(nums);
        for (int i = 1; i < result.length - 1; i++) {
            int val = result[i] * 2;
            int val2 = result[i - 1] + result[i + 1];
            Assertions.assertEquals(false, val == val2);
        }
    }

    @Test
    public void test_3() {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        int[] result = this.rearrangeArray(nums);
        for (int i = 1; i < result.length - 1; i++) {
            int val = result[i] * 2;
            int val2 = result[i - 1] + result[i + 1];
            Assertions.assertEquals(false, val == val2);
        }
    }
    public int[] rearrangeArray(int[] nums) {
        int i = 1;
        int n = nums.length;
        while (i < n - 1) {
            int sum = nums[i - 1] + nums[i + 1];
            if (sum % 2 == 0 && nums[i] * 2 == sum) {
                swapElement(nums, i, i + 1);
                if (i > 1) {
                    i--;
                }
            } else {
                i++;
            }
        }

        return nums;
    }

    private int[] swapElement(int[] arr, int index1, int index2) {
        int x = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = x;
        return arr;
    }
}
