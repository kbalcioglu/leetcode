package com.solutions.leetcode;

import com.solutions.leetcode.utils.StringOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class StringOperationsTest {

    @Test
    public void test_revert_string() {
        String given = "HELLO";
        String expected = "OLLEH";
        String result = StringOperations.revertString(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_get_suffixes() {
        String given = "HELLO";
        List<String> expected = List.of("O", "LO", "LLO", "ELLO", "HELLO");
        List<String> result = StringOperations.getSuffixes(given);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_get_prefixes() {
        String given = "HELLO";
        List<String> expected = List.of("H","HE","HEL","HELL","HELLO");
        List<String> result = StringOperations.getPrefixes(given);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < result.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
    @Test
    public void test_longest_common_prefix() {
        String tex1 = "HELLO";
        String tex2 = "HELOSED";
        String expected = "HEL";
        String result = StringOperations.longestCommonPrefix(tex1,tex2);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_longest_repeated_substring() {
        String text = "helloasdadasdhello";
        String expected = "hello";
        String result = StringOperations.longestRepeatedSubstring(text);
        Assertions.assertEquals(expected, result);
    }
}
