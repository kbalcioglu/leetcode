package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.Map;

public class BullsAndCowsTest {
    @Test
    public void test_1() {
        String secret = "1";
        String guess = "0";
        String expected = "0A0B";
        String result = this.getHint(secret, guess);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        String secret = "1";
        String guess = "1";
        String expected = "1A0B";
        String result = this.getHint(secret, guess);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        String secret = "1807";
        String guess = "7810";
        String expected = "1A3B";
        String result = this.getHint(secret, guess);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        String secret = "1123";
        String guess = "0111";
        String expected = "1A1B";
        String result = this.getHint(secret, guess);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_5() {
        String secret = "1122";
        String guess = "1222";
        String expected = "3A0B";
        String result = this.getHint(secret, guess);
        Assertions.assertEquals(expected, result);
    }

    public String getHint(String secret, String guess) {
        Map<Integer, Character> aMap = new HashMap<>();
        Map<Integer, Character> bMap = new HashMap<>();
        for (int i = 0; i < secret.length(); i++) {
            char g = guess.charAt(i);
            char s = secret.charAt(i);
            if (s == g) {
                aMap.putIfAbsent(i, g);
            } else {
                int index = secret.indexOf(g, 0);
                while (index > -1) {
                    if (aMap.containsKey(index) || bMap.containsKey(index)) {
                        index = secret.indexOf(g, (index + 1));
                        continue;
                    }
                    if(secret.charAt(index) == guess.charAt(index)){
                        index = secret.indexOf(g, (index + 1));
                        continue;
                    }
                    bMap.putIfAbsent(index, g);
                    index = -1;
                }
            }
        }
        return aMap.size() + "A" + bMap.size() + "B";
    }
}
