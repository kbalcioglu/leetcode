package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/longest-substring-without-repeating-characters/
public class LongestSubstringWithoutRepeatingCharactersTest {
    @Test
    public void test_1() {
        String s = "abcabcbb";
        // abc
        int expected = 3;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_2() {
        String s = "bbbb";
        // b
        int expected = 1;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_3() {
        String s = "pwwkew";
        // wke
        int expected = 3;
        int result = this.lengthOfLongestSubstring(s);
        Assertions.assertEquals(expected, result);

    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        Map<Character, Integer> chars = new HashMap<>();
        int maxLength = 1;
        int i = 0;
        int j = 1;
        chars.put(s.charAt(i),i);
        while (i < s.length()
                && j < s.length()
                && i <= j
                && (s.length() - i > maxLength)) {
            char c = s.charAt(j);

            if (!chars.containsKey(c)) {
                chars.put(c, j);
                j++;
            } else {
                i = chars.get(c) + 1;
                j = i + 1;
                chars = new HashMap<>();
                chars.put(s.charAt(i),i);
            }
            maxLength = Math.max(maxLength, s.substring(i, j).length());
        }


        return maxLength;
    }
}
