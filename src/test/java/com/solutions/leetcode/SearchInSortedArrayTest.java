package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInSortedArrayTest {

    @Test
    public void test_1() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int expected = 4;
        int result = search(nums, target);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_2() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 3;
        int expected = -1;
        int result = search(nums, target);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_3() {
        int[] nums = {1};
        int target = 1;
        int expected = 0;
        int result = search(nums, target);
        Assertions.assertEquals(expected, result);
    }

    public int search(int[] nums, int target) {
        int x = nums[nums.length - 1];
        int y = nums[0];
        if (target == x)
            return nums.length - 1;
        else if (target == y)
            return 0;
        else if (x < target && y > target)
            return -1;
        else if (target < x) {
            for (int i = nums.length - 2; i > 0; i--) {
                if (nums[i] == target)
                    return i;
            }
        } else if (target > y) {
            for (int i = 1; i < nums.length - 1; i++) {
                if (nums[i] == target)
                    return i;
            }
        }
        return -1;
    }
}
