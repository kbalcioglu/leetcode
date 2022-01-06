package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/smallest-integer-divisible-by-k/
public class SmallestIntegerDivisiblebyKTest {
    @Test
    public void test_1() {
        int k = 7;
        int expected = 6;
        int result = smallestRepunitDivByK(k);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_11() {
        int k = 6;
        int expected = -1;
        int result = smallestRepunitDivByK(k);
        Assertions.assertEquals(expected, result);
    }

    public int smallestRepunitDivByK(int k) {
        if(k==1)
            return 1;
        if(k % 2 == 0 || k % 5 == 0){
            return -1;
        }
        int n = 1;
        int len = 1;

        while(n != 0){
            n = (n*10 + 1) % k;
            len++;
        }
        return len;
    }
}
