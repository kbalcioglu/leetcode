package com.solutions.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringWithAtLeastKRepeatingCharsTest {

    @Test
    public void test_1() {
        int k = 3;
        String s = "aaabb";
        int expected = 3;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int k = 2;
        String s = "ababbc";
        int expected = 5;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int k = 3;
        String s = "ababacb";
        int expected = 0;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int k = 3;
        String s = "abcabdabababceaba";
        int expected = 6;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int k = 4;
        String s = "abcabdabababceaba";
        int expected = 0;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        int k = 3;
        String s = "bbaaacbd";
        int expected = 3;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        int k = 3;
        String s = "aaabbbcdefcdefgggggggggggggggcde";
        int expected = 15;
        int result = longestSubstring(s, k);
        Assertions.assertEquals(expected, result);
    }

    // faster than %55
    public int longestSubstring(String s, int k) {
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            countMap.putIfAbsent(c, 0);
            countMap.put(c, countMap.get(c) + 1);
        }
        int max = longestSubstring(s, k, countMap, 0);
        return max;
    }

    public int longestSubstring(String s, int k, Map<Character, Integer> countMap, int max) {
        WordObj sb = new WordObj();
        for (char c : s.toCharArray()) {
            int count = countMap.get(c);
            if (count >= k)
                sb.appendChar(c);
            else {
                if (sb.isValid(k)) {
                    max = Math.max(sb.size(), max);
                } else if (sb.size() > max) {
                    max = longestSubstring(sb.toString(), k, sb.getCountMap(), max);
                }
                sb = new WordObj();
            }
        }
        if (sb.isValid(k)) {
            max = Math.max(sb.size(), max);
        }else if (sb.size() > max) {
            max = longestSubstring(sb.toString(), k, sb.getCountMap(), max);
        }
        return max;
    }

    static class WordObj {
        private StringBuilder sb;
        private Map<Character, Integer> map;

        WordObj() {
            map = new HashMap<>();
            sb = new StringBuilder();
        }

        void appendChar(char c) {
            sb.append(c);
            map.putIfAbsent(c, 0);
            map.put(c, map.get(c) + 1);
        }


        boolean isValid(int k) {
            if (sb == null || map == null || sb.length() == 0 || map.size() == 0)
                return false;
            for (char key : map.keySet()) {
                if (map.get(key) < k)
                    return false;
            }
            return true;
        }

        int size() {
            return sb.length();
        }

        Map<Character, Integer> getCountMap() {
            return map;
        }

        @Override
        public String toString() {
            return sb.toString();
        }
    }
}
