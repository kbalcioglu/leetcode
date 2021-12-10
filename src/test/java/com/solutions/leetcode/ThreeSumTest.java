package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/3sum/
public class ThreeSumTest {

    @Test
    public void test_1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }

    @Test
    public void test_2() {
        int[] nums = {0, 0, 0};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }

    @Test
    public void test_3() {
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> result = threeSum(nums);
        System.out.println(result.toString());
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3)
            return List.of();
        if (nums.length == 3) {
            int val = nums[0] + nums[1] + nums[2];
            if (val == 0)
                return List.of(List.of(nums[0], nums[1], nums[2]));
            else
                return List.of();
        }
        Arrays.sort(nums);


        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left = i + 1;
                int right = nums.length - 1;
                int sum = 0;
                while (right > left) {
                    sum = nums[i] + nums[left] + nums[right];
                    if (sum < 0)
                        left++;
                    else if (sum > 0)
                        right--;
                    else {
                        result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;
                        right--;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right + 1]) {
                            right--;
                        }
                    }
                }
            }
        }
        return result;
    }
/*
    public void deneme(int[] nums) {
        List<List<Integer>> returnList = new ArrayList<>();
        int k = 3;
        int n = nums.length;
        int[] binary = new int[(int) Math.pow(2, n)];
        for (int i = 0; i < Math.pow(2, n); i++) {
            int b = 1;
            binary[i] = 0;
            int num = i, count = 0;
            while (num > 0) {
                if (num % 2 == 1)
                    count++;
                binary[i] += (num % 2) * b;
                num /= 2;
                b = b * 10;
            }
            if (count == k) {
                Set<Integer> subset = new HashSet<>();
                int sum = 0;
                for (int j = 0; j < n; j++) {
                    if (binary[i] % 10 == 1 && subset.contains(nums[j])) {
                        binary[i] /= 10;
                        break;
                    }
                    if (binary[i] % 10 == 1) {
                        sum += nums[j];
                    }
                    binary[i] /= 10;
                }
                if(sum == 0 && subset.size() == k){
                    lis
                    returnList.add(subset);
                }
            }
        }
    }
    */
}
