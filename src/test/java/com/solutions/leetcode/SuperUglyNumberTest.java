package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.PriorityQueue;

public class SuperUglyNumberTest {

    @Test
    public void test_1() {
        int n = 12;
        int[] primes = {2, 7, 13, 19};
        int expected = 32;
        int result = nthSuperUglyNumber(n, primes);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int n = 1;
        int[] primes = {2, 3, 5};
        int expected = 1;
        int result = nthSuperUglyNumber(n, primes);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int n = 100000;
        int[] primes = {7, 19, 29, 37, 41, 47, 53, 59, 61, 79, 83, 89, 101, 103, 109, 127, 131, 137, 139, 157, 167, 179, 181, 199, 211, 229, 233, 239, 241, 251};
        int expected = 1092889481;
        int result = nthSuperUglyNumber(n, primes);
        Assertions.assertEquals(expected, result);
    }

    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] cur = new int[primes.length];
        int[] arr = new int[n];
        arr[0] = 1;
        if (n == 1)
            return 1;
        Set<Integer> offered = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++) {
            queue.add(primes[i]);
            offered.add(primes[i]);
        }

        for (int i = 1; i < n; i++) {
            arr[i] = queue.poll();
            for (int j = 0; j < primes.length; j++) {
                if (arr[i] == arr[cur[j]] * primes[j]) {
                    cur[j]++;
                    int  k = arr[cur[j]] * primes[j];
                    if(!offered.contains(k)){
                        queue.add(k);
                        offered.add(k);
                    }
                }
            }
        }
        return arr[n - 1];
    }

    public int nthSuperUglyNumber2(int n, int[] primes) {
        int cur[] = new int[primes.length];
        int ans = 1;
        int dp[] = new int[n + 1];
        dp[0] = 1;
        int index = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < primes.length; i++)
            pq.add(primes[i]);

        while (index < n) {
            int min = pq.poll();
            while (!pq.isEmpty() && min == pq.peek()) //check for duplicate values
                pq.poll();
            dp[index++] = min;
            for (int i = 0; i < primes.length; i++) {
                if (min == dp[cur[i]] * primes[i]) {
                    cur[i]++;
                    pq.add(dp[cur[i]] * primes[i]);
                }
            }
        }
        return dp[n - 1];
    }
}
