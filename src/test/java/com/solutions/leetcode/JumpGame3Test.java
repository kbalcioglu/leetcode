package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/jump-game-iii/
public class JumpGame3Test {

    @Test
    public void test_1() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 5;
        boolean result = canReach(arr, start);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        int[] arr = {4, 2, 3, 0, 3, 1, 2};
        int start = 0;
        boolean result = canReach(arr, start);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_3() {
        int[] arr = {3, 0, 2, 1, 2};
        int start = 2;
        boolean result = canReach(arr, start);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_4() {
        int[] arr = {1, 1, 1, 1, 1, 1, 1, 1, 0};
        int start = 3;
        boolean result = canReach(arr, start);
        Assertions.assertTrue(result);
    }

    public boolean canReach(int[] arr, int start) {
        return bfsFlip(arr, start);
    }

    // %5
    private boolean bfs(int[] arr, int start, Set<Integer> offered) {
        if (arr[start] == 0)
            return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        offered.add(start);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            int left = index - arr[index];
            if (left >= 0) {
                if (arr[left] == 0)
                    return true;
                if (!offered.contains(left)) {
                    queue.offer(left);
                    offered.add(left);
                }
            }
            int right = index + arr[index];
            if (right < arr.length) {
                if (arr[right] == 0)
                    return true;
                if (!offered.contains(right)) {
                    queue.offer(right);
                    offered.add(right);
                }
            }
        }
        return false;
    }

    // %56
    private boolean bfsFlip(int[] arr, int start) {
        if (arr[start] == 0)
            return true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int index = queue.poll();
            arr[index] *= -1;

            for (int j : new int[]{index + arr[index], index - arr[index]}) {
                if (j >= 0 && j < arr.length) {
                    if (arr[j] == 0)
                        return true;
                    else if (arr[j] > 0)
                        queue.offer(j);
                }
            }
        }
        return false;
    }

    // faster %5
    private boolean dfs(int[] arr, int index, Set<Integer> offered) {
        if (index < 0 || index >= arr.length || offered.contains(index))
            return false;
        offered.add(index);
        if (arr[index] == 0)
            return true;
        return dfs(arr, index + arr[index], offered) || dfs(arr, index - arr[index], offered);
    }

    // Faster %56
    private boolean dfsFlip(int[] arr, int index) {
        if (index < 0 || index >= arr.length || arr[index] < 0)
            return false;
        if (arr[index] == 0)
            return true;
        arr[index] *= -1;
        return dfsFlip(arr, index + arr[index]) || dfsFlip(arr, index - arr[index]);
    }
}
