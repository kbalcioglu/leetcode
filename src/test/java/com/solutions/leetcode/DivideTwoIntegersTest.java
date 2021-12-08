package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/divide-two-integers/
public class DivideTwoIntegersTest {

    @Test
    public void test_1() {
        int dividend = 10;
        int divisor = 3;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_2() {
        int dividend = 7;
        int divisor = -3;
        int expected = -2;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_3() {
        int dividend = 0;
        int divisor = 1;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_4() {
        int dividend = 185;
        int divisor = 3;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_5() {
        int dividend = Integer.MIN_VALUE;
        int divisor = -1;
        int expected = Integer.MAX_VALUE;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_6() {
        int dividend = Integer.MIN_VALUE;
        int divisor = Integer.MIN_VALUE;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_7() {
        int dividend = Integer.MAX_VALUE;
        int divisor = Integer.MIN_VALUE;
        int expected = 0;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_8() {
        int dividend = -1;
        int divisor = 1;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_9() {
        int dividend = 1;
        int divisor = -1;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_10() {
        int dividend = Integer.MIN_VALUE;
        int divisor = -5;
        int dividend2 = Integer.MIN_VALUE + Math.abs(divisor);
        int expected = dividend / divisor;
        int expected2 = (dividend2 / divisor) + 1;
        Assertions.assertEquals(expected, expected2);
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_11() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 5;
        int dividend2 = Integer.MIN_VALUE + Math.abs(divisor);
        int expected = dividend / divisor;
        int expected2 = -1 * ((Math.abs(dividend2) / divisor) + 1);
        Assertions.assertEquals(expected, expected2);
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_12() {
        int dividend = 13;
        int divisor = 3;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_13() {
        int dividend = 1;
        int divisor = 0;
        int expected = 0;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_14() {
        int dividend = Integer.MIN_VALUE;
        int divisor = 1;
        int expected = Integer.MIN_VALUE;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_15() {
        int dividend = -10;
        int divisor = 10;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_16() {
        int dividend = -2147483648;
        int divisor = -1109186033;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_17() {
        int dividend = -2147483648;
        int divisor = 1262480350;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }

    @Test
    public void test_18() {
        int dividend = 1;
        int divisor = 2;
        int expected = dividend / divisor;
        int quotient = this.divide(dividend, divisor);
        Assertions.assertEquals(expected, quotient);
    }


    public int divide(int dividend, int divisor) {
        int negative = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1 : -1;
        if (divisor == 0 || dividend == 0)
            return 0;
        else if (dividend == divisor)
            if (negative == -1) {
                return -1;
            } else
                return 1;
        else if (dividend == Integer.MIN_VALUE && divisor == -1)
            return Integer.MAX_VALUE;
        else if (dividend == Integer.MIN_VALUE && divisor == 1)
            return Integer.MIN_VALUE;
        else if (divisor == Integer.MIN_VALUE) {
            return 0;
        }

        int plusOne = 0;
        int positiveDividend;
        if (dividend == Integer.MIN_VALUE) {
            plusOne++;
            positiveDividend = Math.abs(dividend + Math.abs(divisor));
        } else {
            positiveDividend = Math.abs(dividend);
        }
        int positiveDivisor = Math.abs(divisor);
        if (positiveDividend < positiveDivisor){
            if(negative == -1){
                return ~plusOne + 1;
            }else{
                return plusOne;
            }
        }
        else if (positiveDivisor == 1){
            if(negative == -1){
                return ~positiveDividend + 1;
            }else{
                return positiveDividend;
            }
        }
        else if (positiveDividend == positiveDivisor)
            return negative;

        int quotient = 1;
        positiveDividend -= positiveDivisor;
        long tempDivisor = positiveDivisor;
        for (int i = 31; i >= 0; --i) {
            if ((tempDivisor << i) < 0 && (tempDivisor << i) > Integer.MAX_VALUE)
                continue;
            if ((tempDivisor << i) > positiveDividend)
                continue;
            positiveDividend = positiveDividend - (positiveDivisor << i);
            quotient += Math.pow(2, i);
            if (positiveDividend < positiveDivisor) {
                break;
            }
        }
        while (positiveDividend > positiveDivisor) {
            positiveDividend -= positiveDivisor;
            quotient++;
        }

        if(negative == -1){
            return ~(quotient + plusOne) + 1;
        }else{
            return (quotient + plusOne);
        }
    }
}
