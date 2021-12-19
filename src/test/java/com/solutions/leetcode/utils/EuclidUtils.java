package com.solutions.leetcode.utils;

public class EuclidUtils {

    /**
     * gcd also highest common factor (hcf)
     */
    public static int greatestCommonDivisor(int x, int y) {
        if (x == y)
            return x;
        int a = Math.max(x, y);
        int b = Math.min(x, y);
        if (b == 0)
            return a;
        int r = a % b;
        return greatestCommonDivisor(b, r);
    }

    public static int lowestCommonMultiple(int x, int y) {
        if (x == y)
            return x;
        return Math.abs(x * y) / greatestCommonDivisor(x, y);
    }

}
