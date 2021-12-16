package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/find-all-anagrams-in-a-string/
public class FindAllAnagramsInStringTest {

    @Test
    public void test_1() {
        String s = "cbaebabacd";
        String p = "abc";
        Set<Integer> expected = Set.of(0, 6);
        List<Integer> result = findAnagrams(s, p);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertTrue(expected.contains(i));
        }
    }

    @Test
    public void test_2() {
        String s = "abab";
        String p = "ab";
        Set<Integer> expected = Set.of(0, 1, 2);
        List<Integer> result = findAnagrams(s, p);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertTrue(expected.contains(i));
        }
    }

    @Test
    public void test_3() {
        String s = "acbacb";
        String p = "ab";
        Set<Integer> expected = Set.of(2);
        List<Integer> result = findAnagrams(s, p);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertTrue(expected.contains(i));
        }
    }

    @Test
    public void test_4() {
        String s = "acbtcb";
        String p = "ab";
        Set<Integer> expected = Set.of();
        List<Integer> result = findAnagrams(s, p);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertTrue(expected.contains(i));
        }
    }

    @Test
    public void test_5() {
        String s = "aaaaaaaaaa";
        String p = "aaaaaaaaaaaaa";
        Set<Integer> expected = Set.of();
        List<Integer> result = findAnagrams(s, p);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertTrue(expected.contains(i));
        }
    }

    public List<Integer> findAnagrams(String s, String p) {
        if (s == null || s.trim().length() == 0 || p == null || p.trim().length() == 0)
            return List.of();
        if (s.length() < p.length())
            return List.of();
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
            result.add(0);
        }
        for (int i = m; i < n; i++) {
            int k = i - m;
            charsS[s.charAt(k) - 'a'] -= 1;
            charsS[s.charAt(i) - 'a'] += 1;
            if (isAnagram(charsP, charsS)) {
                result.add(k + 1);
            }
        }
        return result;
    }

    private boolean isAnagram(int[] charsP, int[] charsS) {
        for (int i = 0; i < 26; i++) {
            if (charsP[i] != charsS[i])
                return false;
        }
        return true;
    }
}
