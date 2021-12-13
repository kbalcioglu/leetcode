package com.solutions.leetcode;


import com.solutions.leetcode.utils.StringOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/letter-combinations-of-a-phone-number/
public class LetterCombinationsOfAPhoneNumberTest {
    @Test
    public void test_1() {
        String given = "23";
        Set<String> expected = Set.of("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
        var result = letterCombinations(given);
        Assertions.assertEquals(expected.size(), result.size());
        for (String s : result) {
            Assertions.assertTrue(expected.contains(s));
        }
    }
    @Test
    public void test_2() {
        String given = "248";
        Set<String> expected = Set.of("agt","agu","agv","aht","ahu","ahv","ait","aiu","aiv",
                "bgt","bgu","bgv","bht","bhu","bhv","bit","biu","biv",
                "cgt","cgu","cgv","cht","chu","chv","cit","ciu","civ");
        var result = letterCombinations(given);
        Assertions.assertEquals(expected.size(), result.size());
        for (String s : result) {
            Assertions.assertTrue(expected.contains(s));
        }
    }
    @Test
    public void test_3() {
        String given = "";
        List<String> expected = new ArrayList<>();
        var result = letterCombinations(given);
        Assertions.assertEquals(expected.size(), result.size());
        for (String s : result) {
            Assertions.assertTrue(expected.contains(s));
        }
    }

    private static final Map<Character, Set<String>> map = Map.of(
            '2', Set.of("a", "b", "c"),
            '3', Set.of("d", "e", "f"),
            '4', Set.of("g", "h", "i"),
            '5', Set.of("j", "k", "l"),
            '6', Set.of("m", "n", "o"),
            '7', Set.of("p", "q", "r", "s"),
            '8', Set.of("t", "u", "v"),
            '9', Set.of("w", "x", "y", "z"));

    // valid faster than %75
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits == null || digits.trim().length() == 0)
            return list;
        letterCombinations(digits, 0, "", list);
        return list;
    }

    private void letterCombinations(String digits, int index, String s, List<String> list) {
        if (index >= digits.length()) {
            list.add(s);
            return;
        }
        char c = digits.charAt(index);
        Set<String> set = map.get(c);
        for (String val : set) {
            letterCombinations(digits, index + 1, s + val, list);
        }
    }
}
