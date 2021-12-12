package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/generate-parentheses/
public class GenerateParenthesesTest {
    @Test
    public void test_1() {
        int given = 3;
        List<String> expectedList = List.of("()()()", "(()())", "((()))", "()(())", "(())()");
        var resultList = generateParenthesis(given);
        Assertions.assertEquals(expectedList.size(), resultList.size());
        for (String expected : expectedList) {
            Assertions.assertTrue(resultList.contains(expected));
        }
    }

    @Test
    public void test_2() {
        int given = 4;
        List<String> expectedList = List.of(
                "(((())))",
                "((()()))",
                "((())())",
                "((()))()",
                "(()(()))",
                "(()()())",
                "(()())()",
                "(())(())",
                "(())()()",
                "()((()))",
                "()(()())",
                "()(())()",
                "()()(())",
                "()()()()");
        var resultList = generateParenthesis(given);
        Assertions.assertEquals(expectedList.size(), resultList.size());
        for (String expected : expectedList) {
            Assertions.assertTrue(resultList.contains(expected));
        }
    }

    public List<String> generateParenthesis(int n) {
        if (n == 0)
            return List.of();
        if (n == 1)
            return List.of("()");
        List<String> result = new ArrayList<>();
        pattern("", n, n, result);
        return result;
    }

    private void pattern(String text, int open, int close, List<String> res) {
        if (open == 0 && close == 0) {
            res.add(text);
            return;
        }
        if (open > 0)
            pattern(text + "(", open - 1, close, res);

        if (close > 0 && close > open)
            pattern(text + ")", open, close - 1, res);
    }
}
