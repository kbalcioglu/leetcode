package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//https://leetcode.com/problems/remove-k-digits/
public class RemoveKDigitsTest {

    @Test
    public void test_1() {
        String num = "1432219";
        int k = 3;
        String expected = "1219";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        String num = "10200";
        int k = 1;
        String expected = "200";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        String num = "10";
        int k = 2;
        String expected = "0";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        String num = "10001";
        int k = 4;
        String expected = "0";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_5() {
        String num = "1020109";
        int k = 4;
        String expected = "0";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_6() {
        String num = "10200";
        int k = 2;
        String expected = "0";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_7() {
        String num = "199191";
        int k = 3;
        String expected = "111";
        String result = removeKdigits(num, k);
        Assertions.assertEquals(expected, result);
    }

    public String removeAdjacentKDigits(String num, int k) {
        if (num.length() < k)
            return "0";
        else if (num.length() == k)
            return "0";
        int min = Integer.parseInt(num);
        for (int i = 0; i < num.length() - k + 1; i++) {
            min = Math.min(min, Integer.parseInt(num.substring(0, i) + num.substring(i + k)));
        }
        return String.valueOf(min);
    }

    public String removeKdigits(String num, int k) {
        if(k == num.length())
            return "0";
        int len = num.length();
        char stack[] = new char[len];
        int index = 0;
        for(int i = 0; i < len; i++){
            char c = num.charAt(i);
            while(k > 0 && index > 0 && stack[index-1] > c){
                index--;
                k--;
            }
            stack[index++] = c;
        }

        //  is there anything needs to delete
        index = index - k;
        String ans = String.valueOf(stack, 0, index);

        // what is the first index that have non zero value
        int i;
        for(i = 0; i < (ans.length()-1) && ans.charAt(i) == '0'; i++);

        return ans.substring(i);


    }
    private String removeDigitAtIndex(String num, int index) {
        return num.substring(0, index) + num.substring(index + 1);
    }
}
