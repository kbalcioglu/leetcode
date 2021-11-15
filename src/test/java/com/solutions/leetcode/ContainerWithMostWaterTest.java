package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

//https://leetcode.com/problems/container-with-most-water/
public class ContainerWithMostWaterTest {
    /*
    Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
    n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
    Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
    Notice that you may not slant the container
    */
    @Test
    public void test_1() {
        int[] given = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int expected = 49;
        int result = this.maxArea(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] given = {1, 1};
        int expected = 1;
        int result = this.maxArea(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] given = {4, 3, 2, 1, 4};
        int expected = 16;
        int result = this.maxArea(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] given = {1, 2, 1};
        int expected = 2;
        int result = this.maxArea(given);
        Assertions.assertEquals(expected, result);
    }

    public int maxArea(int[] height) {
        int max = 0;
        int leftPointer = 0;
        int rightPointer = height.length - 1;
        while (leftPointer < rightPointer) {
            int wallHeight = Math.min(height[leftPointer], height[rightPointer]);
            max = Math.max(max, wallHeight * (rightPointer - leftPointer));
            if (height[leftPointer] > height[rightPointer])
                rightPointer -= 1;
            else leftPointer += 1;
        }
        return max;
    }
}
