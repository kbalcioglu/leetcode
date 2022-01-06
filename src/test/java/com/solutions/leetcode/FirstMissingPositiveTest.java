package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class FirstMissingPositiveTest {


    @Test
    public void test_1() {
        int[] nums = {1, 1000};
        int expected = 2;
        int result = firstMissingPositive(nums);
        Assertions.assertEquals(expected,result);
    }
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int min = 1;
        for(int i = 0; i<nums.length;i++){
            if(nums[i]<=0)
                continue;
            else if(nums[i] < min)
                continue;
            else if(min == nums[i])
                min++;
            else
                return min;
        }
        return min;
    }
}
