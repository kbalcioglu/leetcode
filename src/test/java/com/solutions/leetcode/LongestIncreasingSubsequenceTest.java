package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequenceTest {

    @Test
    public void test_1() {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int expected = 4;
        int result = lengthOfLIS(nums);
        Assertions.assertEquals(expected, result);
    }

    public int lengthOfLIS(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < x)
                    i = m + 1;
                else
                    j = m;
            }
            tails[i] = x;
            if (i == size)
                ++size;
        }
        return size;
    }
    public int lengthOfLIS2(int[] nums)
    {
        List<Integer> sequence = new ArrayList<>() {{add(nums[0]);}};
        int n = nums.length;
        for(int i=1;i<n;i++)
        {
            if(sequence.get(sequence.size()-1) < nums[i])
                sequence.add(nums[i]);
            else
                sequence.set(getGreaterElementIndex(nums[i],sequence), nums[i]);
        }
        return sequence.size();
    }

    public int getGreaterElementIndex(int element , List<Integer> sequence)
    {
        int low = 0, high = sequence.size();
        while(low<=high)
        {
            int mid = low + (high-low) /2;
            if(sequence.get(mid) == element)
                return mid;
            else if(sequence.get(mid)< element)
                low = mid+1;
            else
                high = mid-1;
        }
        return low;
    }
}
