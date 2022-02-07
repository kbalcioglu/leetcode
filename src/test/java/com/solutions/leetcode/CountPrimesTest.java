package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CountPrimesTest {
    @Test
    public void test_1() {
        int n = 10;
        int expected = 4;
        int result = countPrimes(n);
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_2() {
        int n = 5000000;
        int expected = 348513;
        int result = countPrimes(n);
        Assertions.assertEquals(expected, result);
    }

    public int countPrimes(int n) {
        boolean[] primes = new boolean[n];
        for (int i = 0; i < n; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < n; i++) {
            if (primes[i]) {
                for (int j = i; j * i < n; j++) {
                    primes[j * i] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (primes[i])
                count++;
        }
        return count;
    }
}
