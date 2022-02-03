package com.solutions.leetcode;

import java.util.*;

public class PalindromePartitioningTest {
    private List<List<String>> result;
    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        dfs(0,s,partition);
        Map<Integer,Integer> map = new HashMap<>();

        return result;
    }

    private void dfs(int i, String s,List<String> partition){
        if(i>= s.length()){
            result.add(new ArrayList<>(partition));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if(isPallindrome(s,i,j)) {
                partition.add(s.substring(i,j+1));
                dfs(j+1,s,partition);
                partition.remove(partition.size()-1);
            }
        }
    }

    public boolean isPallindrome(String s, int left, int right) {
        while(left < right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
