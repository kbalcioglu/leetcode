package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CombinationSumsTest {
    @Test
    public void test_1() {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> expected = List.of(List.of(2, 2, 3), List.of(7));
        List<List<Integer>> result = combinationSum(candidates, target);
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    public void test_2() {
        int[] candidates = {2, 3, 5};
        int target = 8;
        List<List<Integer>> expected = List.of(List.of(2, 2, 2, 2), List.of(2, 3, 3), List.of(3, 5));
        List<List<Integer>> result = combinationSum(candidates, target);
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    public void test_3() {
        int[] candidates = {2};
        int target = 1;
        List<List<Integer>> expected = List.of();
        List<List<Integer>> result = combinationSum(candidates, target);
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    public void test_4() {
        int[] candidates = {2, 7, 6, 3, 5, 1};
        int target = 9;
        List<List<Integer>> expected = List.of();
        List<List<Integer>> result = combinationSum(candidates, target);
        Assertions.assertEquals(expected.size(), result.size());
    }




    //[[1,1,1,1,1,1,1,1,1],[1,1,1,1,1,1,1,2],[1,1,1,1,1,1,3],[1,1,1,1,1,2,2],[1,1,1,1,2,3],[1,1,1,1,5],[1,1,1,2,2,2],[1,1,1,3,3],[1,1,1,6],[1,1,2,2,3],[1,1,2,5],[1,1,7],[1,2,2,2,2],[1,2,3,3],[1,2,6],[1,3,5],[2,2,2,3],[2,2,5],[2,7],[3,3,3],[3,6]]

    //[[1,1,1,1,1,2,2],[1,1,1,1,2,3],[1,1,1,2,2,2],[1,1,1,3,3],[1,1,2,2,3],[1,1,2,5],[1,2,3,3],[1,2,6],[1,3,5]]
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<String> unique = new HashSet<>();
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> check = new HashSet<>();
        for (int i = 0; i < candidates.length; i++) {
            check.add(candidates[i]);
        }
        for (int i = 0; i < candidates.length; i++) {
            int x = target;
            int k = candidates[i];
            if (x == k) {
                result.add(List.of(x));
                unique.add(String.valueOf(x));
            } else {
                int kCount = 0;
                while (x > k) {
                    StringBuilder sb = new StringBuilder();
                    kCount++;
                    x = x - k;
                    if (check.contains(x)) {
                        List<Integer> list = new ArrayList<>();
                        for (int j = 0; j < kCount; j++) {
                            list.add(k);
                            sb.append(k);

                        }
                        list.add(x);
                        sb.append(x);
                        if (!unique.contains(sb.toString()) && !unique.contains(sb.reverse().toString())) {
                            result.add(list);
                            unique.add(sb.toString());
                        }
                    }
                }
            }
        }
        return result;
    }






}
