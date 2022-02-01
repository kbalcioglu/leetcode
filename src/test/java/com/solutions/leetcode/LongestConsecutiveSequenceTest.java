package com.solutions.leetcode;

import java.util.*;

public class LongestConsecutiveSequenceTest {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        Set<Integer> seqStarts = new HashSet<>();
        for(int num:nums){
            numSet.add(num);
        }
        int result = 0;

        for(int i = 0; i< nums.length; i++){
            if(!numSet.contains(nums[i]-1)){
                seqStarts.add(nums[i]);
            }
        }
        for(int start : seqStarts){
            int end = start;
            while(numSet.contains(end)){
                end++;
            }
            result = Math.max(result, end - start);
        }

        return result;
    }
}
