package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/submissions/
// TODO : Time Limit Exceeded Error
public class MinimumSwapsStringBalanced {
    @Test
    public void test_ValidString1() {
        String s = "][][";
        Assertions.assertEquals(false, this.isValidString(s));
    }

    @Test
    public void test_ValidString2() {
        String s = "";
        Assertions.assertEquals(true, this.isValidString(s));
    }

    @Test
    public void test_ValidString3() {
        String s = "[[]]";
        Assertions.assertEquals(true, this.isValidString(s));
    }

    @Test
    public void test_ValidString4() {
        String s = "[][]";
        Assertions.assertEquals(true, this.isValidString(s));
    }

    @Test
    public void test_ValidString5() {
        String s = "[[][]]";
        Assertions.assertEquals(true, this.isValidString(s));
    }

    @Test
    public void test_ValidString6() {
        String s = "[[[]]][[][]][[]][][]";
        Assertions.assertEquals(true, this.isValidString(s));
    }

    @Test
    public void test_1() {
        String s = "][][";
        // [[]]
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        String s = "]]][[[";
        // []][][
        // [[][]]
        int expected = 2;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        String s = "][][][";
        // [[][]]
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        String s = "][[]][][[][]";
        // [[[]][]][][]
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        String s = "[[[]]]][][]][[]]][[[";
        // length = 20
        // replace 6 | 19
        // [[[]]][[][]][[]]][[]
        // [[[]]][[][]][[]]][[]
        // replace 16 | 17
        // [[[]]][[][]][[]][][];
        int expected = 2;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        String s = "][[][[][[][][[]]]]";
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        String s = "][][[][[[][][]][][]]";
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }
    /*@Test
    public void test_8(){
        String s = "][][[][]][[][]]]]][][[[][[[]][]][[][[[][[]]][[[]]][[[[][][[]][]]]][]]][][]]][[][][[][]][[[[[[]]]][]]]][[]]][[][][[][[]]][[][]]][]]][[[]]][[][][[][[[[]][]]][[[[]][[]]]][[][[[[][][]][]][[]]]]][[[[[[[][][[[][]][]]][][][]]][][][]][[[][]]][]][[][]]]][]]][[]][[[]]]]]]]][]]][[[]]]][]][[[[][][[[[][[[][[[[[[[[][[][][][[]][[][[[]]][[]][][]][][]][[]]][[][]][]]][[][][]][[[][[][[[]][][][][[[[[[[][][[[]]][]][[[[[[[[][[[]]][[][[][][[][]]][]][[]]][]][[[][[]][][]][[[[]][[]]][][][]]]]][[[[[]][[[]]][][]][]]]]]][[]]][[[[[]][][]][[]]]]][[][]]]";
        int expected = 1;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }*/

    @Test
    public void test_9() {
        String s = "[]";
        int expected = 0;
        int result = this.minSwaps(s);
        Assertions.assertEquals(expected, result);
    }
    public int minSwaps(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<String> q = new PriorityQueue<>();
        q.add(s);
        map.put(s,0);
        while (!q.isEmpty()) {
            String str = q.poll();
            int count = 0;
            if (map.containsKey(str)) {
                count = map.get(str);
                map.remove(str);
            }
            if (isValidString(str)) {
                map.put(str, count);
                return count;
            }
            count++;
            for (int i = 0; i < str.length() - 1; i++) {
                for (int j = i + 1; j < str.length(); j++) {
                    if (str.charAt(i) == str.charAt(j)) {
                        continue;
                    }
                    String temp = str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i) + str.substring(j + 1);
                    if (!visited.contains(temp)) {
                        map.put(temp, count);
                        q.add(temp);
                        if (isValidString(temp)) {
                            return count;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private boolean isValidString(String str) {
        int openedBracelet = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '[') {
                openedBracelet++;
            } else if (openedBracelet > 0 && str.charAt(i) == ']')
                openedBracelet--;
        }
        return (openedBracelet == 0);
    }
}
