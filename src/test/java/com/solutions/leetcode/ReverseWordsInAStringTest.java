package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/reverse-words-in-a-string/
public class ReverseWordsInAStringTest {

    @Test
    public void test_1() {
        String s = "  Bob    Loves  Alice   ";
        String expected = "Alice Loves Bob";
        String result = reverseWords(s);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void test_2() {
        String s = "the sky is blue";
        String expected = "blue is sky the";
        String result = reverseWords(s);
        Assertions.assertEquals(expected,result);
    }
    @Test
    public void test_3() {
        String s = "  hello world  ";
        String expected = "world hello";
        String result = reverseWords(s);
        Assertions.assertEquals(expected,result);
    }

    private boolean isNotBlank(String s) {
        return s != null && s.trim().length() > 0 && !s.isBlank();
    }

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> arr = Arrays.stream(s.split(" "))
                .filter(this::isNotBlank)
                .collect(Collectors.toList());
        for (int i = arr.size() - 1; i >= 0; i--) {
            sb.append(arr.get(i));
            if (i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
