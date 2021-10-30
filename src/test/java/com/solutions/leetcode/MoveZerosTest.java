package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MoveZerosTest {
    @Test
    public void test_1() {
        int[] nums = {0, 1, 0, 3, 12};
        int[] expected = {1, 3, 12, 0, 0};
        this.moveZeroes(nums);
        Assertions.assertEquals(expected.length, nums.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], nums[i]);
        }
    }

    @Test
    public void test_2() {
        int[] nums = {0};
        int[] expected = {0};
        this.moveZeroes(nums);
        Assertions.assertEquals(expected.length, nums.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], nums[i]);
        }
    }

    @Test
    public void test_3() {
        int[] nums = {0, 0};
        int[] expected = {0, 0};
        this.moveZeroes(nums);
        Assertions.assertEquals(expected.length, nums.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], nums[i]);
        }
    }

    @Test
    public void test_4() {
        int[] nums = {0, 0, 1};
        int[] expected = {1, 0, 0};
        this.moveZeroes(nums);
        Assertions.assertEquals(expected.length, nums.length);
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(expected[i], nums[i]);
        }
    }

    public void moveZeroes(int[] nums) {
        int fromIndex = 0;
        int toIndex = nums.length - 1;
        int key = 0;
        while (fromIndex >= 0 && fromIndex <= toIndex) {
            if (nums[fromIndex] == 0) {
                for (int i = fromIndex + 1; i <= toIndex; i++) {
                    nums[i-1] = nums[i];
                }
                nums[toIndex] = key;
                toIndex--;
            }
            else {
                fromIndex++;
            }
        }
    }
}
