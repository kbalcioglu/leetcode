package com.solutions.leetcode;


import com.solutions.leetcode.utils.StringOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-break/
public class WordBreakTest {

    @Test
    public void test_1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "sand", "and", "cat", "dog");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_4() {
        String s = "aaaaaaa";
        List<String> wordDict = List.of("aaaa", "aaa");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> offered = new HashSet<>();
        offered.add(s);
        boolean result = false;
        while (!queue.isEmpty()) {
            String check = queue.poll();
            int n = check.length();
            for (String word : wordDict) {
                if (word.length() > check.length())
                    continue;
                String start = check.substring(0, word.length());
                String end = check.substring(n - word.length(), n);
                if (start.equals(word)) {
                    String next = check.substring(word.length());
                    if(next.equals("")){
                        result = true;
                        break;
                    }
                    if (!offered.contains(next)) {
                        queue.offer(next);
                        offered.add(next);
                    }
                }
                if (end.equals(word)) {
                    String next = check.substring(0, n - word.length());
                    if(next.equals("")){
                        result = true;
                        break;
                    }
                    if (!offered.contains(next)) {
                        queue.offer(next);
                        offered.add(next);
                    }
                }
            }
        }
        return result;
    }
}
