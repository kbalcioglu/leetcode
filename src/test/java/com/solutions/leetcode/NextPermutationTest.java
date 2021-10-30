package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

// https://leetcode.com/problems/next-permutation/
public class NextPermutationTest {
    @Test
    public void test_1() {
        int[] expected = {1};
        int[] nums = {1};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_2() {
        int[] expected = {1, 3, 2};
        int[] nums = {1, 2, 3};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_3() {
        int[] expected = {1, 5, 1};
        int[] nums = {1, 1, 5};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_4() {
        int[] expected = {1, 2, 3};
        int[] nums = {3, 2, 1};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_5() {
        int[] expected = {4, 5, 2, 7, 1, 3, 6};
        int[] nums = {4, 5, 2, 6, 7, 3, 1};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_6() {
        int[] expected = {2, 1, 3};
        int[] nums = {1, 3, 2};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_7() {
        int[] expected = {6, 9, 3, 7, 4, 5, 2, 5, 4, 7, 4, 4, 3, 7, 0};
        int[] nums = {6, 9, 3, 7, 4, 5, 2, 5, 4, 7, 4, 4, 3, 0, 7};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_8() {
        int[] expected = {6, 8, 8, 4, 3, 1, 4, 9, 2, 0, 6, 8, 9, 2, 6, 6, 9, 4};
        int[] nums = {6, 8, 8, 4, 3, 1, 4, 9, 2, 0, 6, 8, 9, 2, 6, 6, 4, 9};
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_9() {
        ;
        int[] expected = {16, 27, 25, 23, 25, 16, 12, 9, 1, 2, 7, 20, 19, 23, 16, 0, 6, 22, 16, 11, 8, 27, 9, 2, 20, 2, 13, 7, 25, 29, 12, 12, 18, 29, 27, 13, 16, 1, 22, 9, 3, 21, 29, 14, 7, 8, 14, 5, 0, 23, 16, 20, 1};
        int[] nums = {16, 27, 25, 23, 25, 16, 12, 9, 1, 2, 7, 20, 19, 23, 16, 0, 6, 22, 16, 11, 8, 27, 9, 2, 20, 2, 13, 7, 25, 29, 12, 12, 18, 29, 27, 13, 16, 1, 22, 9, 3, 21, 29, 14, 7, 8, 14, 5, 0, 23, 16, 1, 20};
        //this.findNext(nums);
        this.nextPermutation(nums);
        this.assertion(expected, nums);
    }

    @Test
    public void test_arrayToNumber() {
        int expected = 4526731;
        int[] nums = {4, 5, 2, 6, 7, 3, 1};
        long number = this.arrayToNumber(nums);
        Assertions.assertEquals(expected, number);
    }

    private void assertion(int[] expected, int[] nums) {
        Assertions.assertEquals(expected.length, nums.length);
        for (int i = 0; i < nums.length; i++) {
            Assertions.assertEquals(expected[i], nums[i]);
        }
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        int n = nums.length - 1;
        int startIndex = 0;
        for (int i = n; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                startIndex = i;
                break;
            }
        }
        if (startIndex == 0) {
            Arrays.sort(nums);
        } else {
            int x = nums[startIndex - 1];
            int min = startIndex;
            for (int j = startIndex + 1; j <= n; j++) {
                if (nums[j] > x && nums[j] < nums[min]) {
                    min = j;
                }
            }
            swapElement(nums, startIndex - 1, min);
            Arrays.sort(nums, startIndex, nums.length);
        }
    }
    public void nextPermutation2(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        long number = this.arrayToNumber(nums);
        int n = nums.length - 1;
        int startIndex = 0;
        long minNumber = Long.MAX_VALUE;
        for (int i = n; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                swapElement(nums, i, i - 1);
                long newNumber = this.arrayToNumber(nums);
                if (newNumber > number && newNumber < minNumber) {
                    startIndex = i;
                    break;
                } else {
                    swapElement(nums, i, i - 1);
                }
            }
        }


        if (startIndex <= nums.length) {
            int b1[] = Arrays.copyOfRange(nums, startIndex, nums.length);
            Arrays.sort(b1);
            for (int i = 0; i < b1.length; i++) {
                nums[startIndex + i] = b1[i];
            }
        }

    }
    public void nextPermutation3(int[] nums) {
        if (nums.length == 0 || nums.length == 1)
            return;
        long number = this.arrayToNumber(nums);
        int n = nums.length - 1;
        int startIndex = 0;
        long minNumber = Long.MAX_VALUE;
        int swapIndex1 = -1;
        int swapIndex2 = -1;
        boolean breakLoop = false;
        for (int i = n; i > 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    swapElement(nums, i, j);
                    long newNumber = this.arrayToNumber(nums);
                    if (newNumber > number && newNumber < minNumber) {
                        minNumber = newNumber;
                        swapIndex1 = i;
                        swapIndex2 = j;
                        startIndex = j + 1;
                        swapElement(nums, i, j);
                        breakLoop = true;
                        break;
                    }
                    else {
                        swapElement(nums, i, j);
                    }
                }
            }
        }
        if (swapIndex1 >= 0 && swapIndex2 >= 0 && swapIndex2 != swapIndex1) {
            swapElement(nums, swapIndex1, swapIndex2);
        }


        if (startIndex <= nums.length) {
            int b1[] = Arrays.copyOfRange(nums, startIndex, nums.length);
            Arrays.sort(b1);
            for (int i = 0; i < b1.length; i++) {
                nums[startIndex + i] = b1[i];
            }
        }

    }
    private int[] swapElement(int[] arr, int index1, int index2) {
        int x = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = x;
        return arr;
    }

    private long arrayToNumber(int[] arr) {
        long number = 0;
        int power = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            number = number + ((long) Math.pow(10, power) * arr[i]);
            power++;
        }
        return number;
    }

    private void findNext(int arr[]) {
        int n = arr.length;
        int i;
        for (i = n - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }
        if (i == 0) {
            System.out.println("Not possible");
        } else {
            int x = arr[i - 1], min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > x && arr[j] < arr[min]) {
                    min = j;
                }
            }
            swapElement(arr, i - 1, min);
            Arrays.sort(arr, i, n);
        }
    }
}
