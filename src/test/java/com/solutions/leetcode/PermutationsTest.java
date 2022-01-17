package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

public class PermutationsTest {

    @Test
    public void test_1() {
        int[] nums = {};
        var result = permute(nums);
    }

    @Test
    public void test_2() {
        int[] nums = {1};
        var result = permute(nums);
    }

    @Test
    public void test_3() {
        int[] nums = {1, 2};
        var result = permute(nums);
    }

    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0)
            return new ArrayList<>();

        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return dfs(list);
    }

    private List<List<Integer>> dfs(List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(new ArrayList<>(nums));
            return result;
        }
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int k = nums.get(i);
            nums.remove(i);
            List<List<Integer>> permutations = dfs(nums);
            for (int j = 0; j < permutations.size(); j++) {
                permutations.get(j).add(k);
            }
            result.addAll(permutations);
            nums.add(i, k);
        }
        return result;
    }
}
