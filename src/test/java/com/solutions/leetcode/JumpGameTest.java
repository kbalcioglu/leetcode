package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

//https://leetcode.com/problems/jump-game/
public class JumpGameTest {

    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        boolean result = canJump(nums);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        int[] nums = {3, 2, 1, 0, 4};
        boolean result = canJump(nums);
        Assertions.assertFalse(result);
    }

    // %5 faster
    public boolean canJump3(int[] nums) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int lastIndex = nums.length - 1;
        Set<Integer> offered = new HashSet<>();
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if (index == lastIndex)
                return true;
            int maxJump = nums[index];
            for (int i = 1; i <= maxJump; i++) {
                int nextIndex = index + i;
                if (nextIndex == lastIndex)
                    return true;
                if (offered.contains(nextIndex))
                    continue;
                offered.add(nextIndex);
                queue.offer(nextIndex);
            }
        }
        return false;
    }

    // %75 faster
    public boolean canJump2(int[] nums) {
        int n = nums.length;
        int steps_left = 0;
        for (int i = 0; i < n; i++) {
            steps_left--;
            steps_left = Math.max(steps_left, nums[i]);
            if (steps_left == 0)
                return i == n - 1;
        }
        return true;
    }

    // %100 faster
    public boolean canJump(int[] nums) {
        int n = nums.length - 1;
        int target = n;
        for (int i = n; i >= 0; i--) {
            if (i + nums[i] >= target)
                target = i;
        }
        return target == 0;
    }
}
