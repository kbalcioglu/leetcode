package com.solutions.leetcode;

import org.junit.jupiter.api.Test;

public class PowerOfBigNumbersTest {
    @Test
    public void test_1(){
        double x = 2.0000;
        int n = Integer.MAX_VALUE;
        double result = myPow(x,n);
    }

    public double myPow(double x, int n) {
        if(n == 0)
            return 1.0;
        if(x == 0.0)
            return 0.0;
        else if(x == 1.0)
            return 1.0;
        double result = 0.0;
        int absN = Math.abs(n);
        if(n == Integer.MIN_VALUE){
            absN = Integer.MAX_VALUE;
        }

        result = power(x,absN);

        if(n <0 ){
            if(n == Integer.MIN_VALUE){
                result = x * result;
            }
            result = 1 / result;
        }
        return result;
    }

    private double power(double x, int n) {
        if (n == 0) return 1;

        double result = power(x, (n / 2));
        result = result * result;
        if (n % 2 == 1)
            result = result * x;
        return result;
    }
}
