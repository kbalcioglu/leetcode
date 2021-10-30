package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class RemoveInvalidParentheses {
    @Test
    public void test1(){
        String input = "()())()";
        List<String> expected = List.of(
                "(())()",
                "()()()"
        );
        List<String> result = removeInvalidParentheses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
    @Test
    public void test2(){
        String input = "(a)())()";
        List<String> expected = List.of(
                "(a())()",
                "(a)()()"
        );
        List<String> result = removeInvalidParentheses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
    @Test
    public void test3(){
        String input = ")(";
        List<String> expected = List.of("");
        List<String> result = removeInvalidParentheses(input);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> validSet = new ArrayList<>();
        if(s.isBlank())
            return List.of();
        String temp = s;
        Set<String> visitedSet = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(temp);
        visitedSet.add(temp);
        int targetLevel = 0;
        while (!q.isEmpty()){
            temp = q.poll();
            int level = s.length() - temp.length();
            if(isValidString(temp)){
                if(validSet.size() == 0){
                    validSet.add(temp);
                    targetLevel = level;
                }
                else if(targetLevel == level){
                    validSet.add(temp);
                }
                continue;
            }
            for (int i = 0; i < temp.length(); i++){
                if (!isParenthesis(s.charAt(i)))
                    continue;
                String str = temp.substring(0,i) + temp.substring(i+1);
                if(!visitedSet.contains(str)){
                    visitedSet.add(str);
                    q.add(str);
                }
            }
        }
        return validSet;
    }
    private boolean isParenthesis(char c)
    {
        return ((c == '(') || (c == ')'));
    }
    private boolean isValidString(String str)
    {
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
}
