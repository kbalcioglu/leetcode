package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class IntegerToEnglishWordsTest {

    @Test
    public void test_1() {
        int num = 123;
        String expected = "One Hundred Twenty Three";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int num = 12345;
        String expected = "Twelve Thousand Three Hundred Forty Five";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int num = 1234567;
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int num = 1234567891;
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        int num = 12;
        String expected = "Twelve";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        int num = 11;
        String expected = "Eleven";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        int num = 0;
        String expected = "Zero";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_8() {
        int num = 2147483647;
        String expected = "Two Billion One Hundred Forty Seven Million Four Hundred Eighty Three Thousand Six Hundred Forty Seven";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_9() {
        int num = 123000;
        String expected = "One Hundred Twenty Three Thousand";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_10() {
        int num = 23000;
        String expected = "Twenty Three Thousand";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_11() {
        int num = 23;
        String expected = "Twenty Three";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_12() {
        int num = 923;
        String expected = "Nine Hundred Twenty Three";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_13() {
        int num = 100000;
        String expected = "One Hundred Thousand";
        String result = this.numberToWords(num);
        Assertions.assertEquals(expected, result);
    }
    public String numberToWords(int num) {
        if (num < 0 || num > 2147483647) {
            return null;
        }
        int givenNumber = num;
        Map<Integer, String> map = this.getMap();
        Map<Integer, String> map2 = this.getMap2();
        Map<Integer, String> map3 = this.getMap3();
        StringBuilder sBuilder = new StringBuilder();
        if (map2.containsKey(givenNumber))
            return map2.get(givenNumber);

        for (int key : map.keySet()) {
            int existsCount = Math.floorDiv(givenNumber, key);
            if (existsCount > 0) {
                String s = map.get(key);
                givenNumber = givenNumber - (existsCount * key);
                if (existsCount >= 100) {
                    int hundredCount = Math.floorDiv(existsCount, 100);
                    if (hundredCount > 0) {
                        sBuilder.append(" ");
                        sBuilder.append(map2.get(hundredCount));
                        sBuilder.append(" ");
                        sBuilder.append(map.get(100));
                        existsCount = existsCount - (hundredCount * 100);
                    }
                }
                if (existsCount >= 20) {
                    int tenDigitCount = Math.floorDiv(existsCount, 10);
                    if (tenDigitCount > 1) {
                        String sTen = map3.get((tenDigitCount * 10));
                        sBuilder.append(" ");
                        sBuilder.append(sTen);
                        existsCount = existsCount - (tenDigitCount * 10);

                    }
                }
                if (existsCount > 0 && existsCount < 20) {
                    String sTen = map2.get(existsCount);
                    sBuilder.append(" ");
                    sBuilder.append(sTen);
                }
                sBuilder.append(" ");
                sBuilder.append(s);
            }
        }
        if( givenNumber >= 20){
            int tenDigitCount = Math.floorDiv(givenNumber, 10);
            int twoDigitNum = (tenDigitCount * 10);
            if(map3.containsKey(twoDigitNum)){
                String sTen = map3.get((tenDigitCount * 10));
                givenNumber = givenNumber - (tenDigitCount * 10);
                sBuilder.append(" ");
                sBuilder.append(sTen);
            }
        }
        if(givenNumber > 0 && map2.containsKey(givenNumber)){
            String s = map2.get(givenNumber);
            sBuilder.append(" ");
            sBuilder.append(s);
        }
        return sBuilder.toString().trim();
    }

    private Map<Integer, String> getMap() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.putIfAbsent(1000000000, "Billion");
        map.putIfAbsent(1000000, "Million");
        map.putIfAbsent(1000, "Thousand");
        map.putIfAbsent(100, "Hundred");
        return map;
    }

    private Map<Integer, String> getMap3() {
        Map<Integer, String> map = new LinkedHashMap<>();
        map.putIfAbsent(90, "Ninety");
        map.putIfAbsent(80, "Eighty");
        map.putIfAbsent(70, "Seventy");
        map.putIfAbsent(60, "Sixty");
        map.putIfAbsent(50, "Fifty");
        map.putIfAbsent(40, "Forty");
        map.putIfAbsent(30, "Thirty");
        map.putIfAbsent(20, "Twenty");
        return map;
    }

    private Map<Integer, String> getMap2() {
        Map<Integer, String> map = new HashMap<>();
        map.putIfAbsent(19, "Nineteen");
        map.putIfAbsent(18, "Eighteen");
        map.putIfAbsent(17, "Seventeen");
        map.putIfAbsent(16, "Sixteen");
        map.putIfAbsent(15, "Fifteen");
        map.putIfAbsent(14, "Fourteen");
        map.putIfAbsent(13, "Thirteen");
        map.putIfAbsent(12, "Twelve");
        map.putIfAbsent(11, "Eleven");
        map.putIfAbsent(10, "Ten");
        map.putIfAbsent(9, "Nine");
        map.putIfAbsent(8, "Eight");
        map.putIfAbsent(7, "Seven");
        map.putIfAbsent(6, "Six");
        map.putIfAbsent(5, "Five");
        map.putIfAbsent(4, "Four");
        map.putIfAbsent(3, "Three");
        map.putIfAbsent(2, "Two");
        map.putIfAbsent(1, "One");
        map.putIfAbsent(0, "Zero");
        return map;
    }
}
