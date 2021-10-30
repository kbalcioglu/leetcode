package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.Map;


public class IntegerToRomanTest {
    Map<Character, Integer> map = Map.of(
            'M', 1000,
            'D', 500,
            'C', 100,
            'L', 50,
            'X', 10,
            'V', 5,
            'I', 1
    );

    @Test
    public void test_solution() {
        int num = 1994;
        String result = this.intToRoman(num);
        Assertions.assertEquals("MCMXCIV", result);
    }

    @Test
    public void test_solutio2() {
        String num = "MCMXCIV";
        int result = this.romanToInteger(num);
        Assertions.assertEquals(1994, result);
    }

    private String intToRoman(int num) {
        StringBuilder sbResult = new StringBuilder();
        if (num < 1 || num > 3999)
            return null;
        if (num >= 1000) {
            int m = Math.floorDiv(num, 1000);
            for (int i = 0; i < m; i++) {
                sbResult.append("M");
            }
            num = num - (m * 1000);
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 900 && num < 1000) {
            sbResult.append("CM");
            num = num - 900;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 500 && num < 900) {
            sbResult.append("D");
            num = num - 500;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 400 && num < 500) {
            sbResult.append("CD");
            num = num - 400;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 100 && num < 400) {
            int c = Math.floorDiv(num, 100);
            for (int i = 0; i < c; i++) {
                sbResult.append("C");
            }
            num = num - (c * 100);
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 90 && num < 100) {
            sbResult.append("XC");
            num = num - 90;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 50 && num < 90) {
            sbResult.append("L");
            num = num - 50;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 40 && num < 50) {
            sbResult.append("XL");
            num = num - 40;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 10 && num < 40) {
            int x = Math.floorDiv(num, 10);
            for (int i = 0; i < x; i++) {
                sbResult.append("X");
            }
            num = num - (x * 10);
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num == 9) {
            sbResult.append("IX");
            num = num - 9;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 5 && num < 9) {
            sbResult.append("V");
            num = num - 5;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num == 4) {
            sbResult.append("IV");
            num = num - 4;
            System.out.println("num : " + num);
            if (num == 0)
                return sbResult.toString();
        }
        if (num >= 1 && num < 4) {
            for (int i = 0; i < num; i++) {
                sbResult.append("I");
            }
        }
        System.out.println("num : " + num);
        return sbResult.toString();
    }

    private int romanToInteger(String s) {
        int result = 0;
        char latestChar = s.charAt(0);
        int val = map.get(latestChar);
        result = result + val;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (checkChar(latestChar, c)) {
                if (latestChar == 'C') {
                    result = result - map.get('C');
                    if (c == 'M') {
                        result = result + 900;
                    } else if (c == 'D') {
                        result = result + 400;
                    }
                } else if (latestChar == 'X') {
                    result = result - map.get('X');
                    if (c == 'C') {
                        result = result + 90;
                    } else if (c == 'L') {
                        result = result + 40;
                    }

                } else if (latestChar == 'I') {
                    result = result - map.get('I');
                    if (c == 'X') {
                        result = result + 9;
                    } else if (c == 'V') {
                        result = result + 4;
                    }
                }
            } else {
                val = map.get(c);
                result = result + val;
            }
            latestChar = c;
        }
        return result;
    }

    private boolean checkChar(char latestChar, char currentChar) {
        switch (latestChar) {
            case 'C':
                if (currentChar == 'M')
                    return true;
                if (currentChar == 'D')
                    return true;
                break;
            case 'X':
                if (currentChar == 'C')
                    return true;
                if (currentChar == 'L')
                    return true;
                break;
            case 'I':
                if (currentChar == 'X')
                    return true;
                if (currentChar == 'V')
                    return true;
                break;
        }
        return false;

    }
}
