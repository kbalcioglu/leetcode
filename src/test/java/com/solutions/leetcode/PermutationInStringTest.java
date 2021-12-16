package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/permutation-in-string/
public class PermutationInStringTest {

    @Test
    public void test_1() {
        String s1 = "ab";
        String s2 = "eidbaooo";
        boolean result = checkInclusion(s1, s2);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        String s1 = "ab";
        String s2 = "eidboaoo";
        boolean result = checkInclusion(s1, s2);
        Assertions.assertFalse(result);
    }
    public boolean checkInclusion(String s1, String s2) {
        String p = s1;
        String s = s2;
        if (s == null || s.trim().length() == 0 || p == null || p.trim().length() == 0)
            return false;
        if (s.length() < p.length())
            return false;
        List<Integer> result = new ArrayList<>();
        int m = p.length();
        int n = s.length();
        int[] charsP = new int[26];
        int[] charsS = new int[26];
        for (int i = 0; i < m; i++) {
            charsP[p.charAt(i) - 'a'] += 1;
            charsS[s.charAt(i) - 'a'] += 1;
        }
        if (isAnagram(charsP, charsS)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            int k = i - m;
            charsS[s.charAt(k) - 'a'] -= 1;
            charsS[s.charAt(i) - 'a'] += 1;
            if (isAnagram(charsP, charsS)) {
                return true;
            }
        }
        return false;
    }

    private boolean isAnagram(int[] charsP, int[] charsS) {
        for (int i = 0; i < 26; i++) {
            if (charsP[i] != charsS[i])
                return false;
        }
        return true;
    }
}
