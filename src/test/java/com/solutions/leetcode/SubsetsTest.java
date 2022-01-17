package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class SubsetsTest {

    @Test
    public void test_1() {
        int[] nums = {1,2,3};
        var list = subsets(nums);
    }

    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>());
        return result;
    }

    private void dfs(int[] nums, int index, List<Integer> subset) {
        if (index >= nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[index]);
        dfs(nums, index + 1, subset);
        subset.remove(subset.size() - 1);
        dfs(nums, index + 1, subset);
    }
}
