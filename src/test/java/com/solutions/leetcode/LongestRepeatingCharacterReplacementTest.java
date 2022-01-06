package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacementTest {

    @Test
    public void test_1() {
        String s = "ABAB";
        int k = 2;
        int expected = 4;
        int result = characterReplacement(s, k);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_2() {
        String s = "AABABBA";
        int k = 1;
        int expected = 4;
        int result = characterReplacement(s, k);
        Assertions.assertEquals(expected, result);
    }

    public int characterReplacement(String s, int k) {
        Map<Character, Integer> memo = new HashMap<>();

        int result = 0;
        int left = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            memo.putIfAbsent(c, 0);
            int frequency = memo.get(c) + 1;
            memo.put(c, frequency);

            maxFrequency = Math.max(maxFrequency, frequency);

            int windowLength = right - left + 1;
            while (windowLength - maxFrequency > k) {
                char cL = s.charAt(left);
                memo.put(cL, (memo.get(cL) - 1));
                left++;
                windowLength = right - left + 1;
            }
            result = Math.max(result, windowLength);
        }


        return result;
    }
}
