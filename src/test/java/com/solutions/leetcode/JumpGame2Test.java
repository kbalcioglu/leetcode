package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGame2Test {

    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] nums = {2, 3, 4, 2, 1, 1, 0};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] nums = {2, 5, 3, 2, 1, 1, 0};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    public int jump(int[] nums) {
        int count = 0;
        int l = 0;
        int r = 0;
        while(r<nums.length-1)
        {
            int farthest = 0;
            for(int i = l; i < r+1; i++){
                farthest = Math.max(farthest, i + nums[i]);
            }
            l = r+1;
            r = farthest;
            count++;
        }
        return count;
    }
}
