package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class ExpressionAddOperators {
    // https://leetcode.com/problems/expression-add-operators/
    @Test
    public void test_1() {
        String num = "123";
        int target = 6;
        List<String> expected = List.of(
                "1*2*3",
                "1+2+3"
        );
        List<String> result = this.addOperators(num, target);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_2() {
        String num = "232";
        int target = 8;
        List<String> expected = List.of(
                "2*3+2",
                "2+3*2"
        );
        List<String> result = this.addOperators(num, target);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_3() {
        String num = "105";
        int target = 5;
        List<String> expected = List.of(
                "1*0+5",
                "10-5"
        );
        List<String> result = this.addOperators(num, target);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_4() {
        String num = "00";
        int target = 0;
        List<String> expected = List.of(
                "0+0",
                "0-0",
                "0*0"
        );
        List<String> result = this.addOperators(num, target);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_5() {
        String num = "3456237490";
        int target = 9191;
        List<String> expected = List.of();
        List<String> result = this.addOperators(num, target);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    public List<String> addOperators(String num, int target) {
        Set<String> operators = Set.of("*","+","-");
        int maxTarget = 2147483647;
        int minTarget = -1 * 2147483647;

        if (num == null || num.length() > 10 || num.length() < 1 || target < minTarget || target > maxTarget)
            return List.of();


        return List.of();
    }
}
