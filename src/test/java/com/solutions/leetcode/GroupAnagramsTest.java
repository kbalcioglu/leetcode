package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class GroupAnagramsTest {


    @Test
    public void test_1() {
        String[] strs = {"", ""};
        List<List<String>> expected = List.of(List.of("", ""));
        List<List<String>> result = groupAnagrams(strs);
        Assertions.assertEquals(expected.size(), result.size());
    }

    @Test
    public void test_2() {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> expected = List.of(List.of("bat"), List.of("tan", "nat"), List.of("tea", "eat", "ate"));
        List<List<String>> result = groupAnagrams(strs);
    }

    @Test
    public void test_3() {
        String[] strs = {""};
        List<List<String>> expected = List.of(List.of(""));
        List<List<String>> result = groupAnagrams(strs);
    }

    @Test
    public void test_4() {
        String[] strs = {"a"};
        List<List<String>> expected = List.of(List.of("a"));
        List<List<String>> result = groupAnagrams(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            result.add(new ArrayList<>());
            return result;
        } else if (strs.length == 1) {
            result.add(List.of(strs[0]));
            return result;
        }
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int hash = getHash(s);
            map.putIfAbsent(hash, new ArrayList<>());
            map.get(hash).add(s);
        }
        for (int key : map.keySet()) {
            var list = map.get(key);
            result.add(list);
        }
        return result;
    }

    private int getHash(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return Arrays.hashCode(chars);
    }
}
