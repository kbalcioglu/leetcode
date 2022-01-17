package com.solutions.leetcode.utils;

public class SearchUtils {
    /**
     * arr must be sorted
     */
    public static int binarySearch(int[] arr, int x) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (arr[m] == x)
                return m;
            else if (arr[m] > x) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        if (l == r && arr[l] == x) {
            return l;
        }
        return -1;
    }

    /**
     * arr must be sorted
     */
    public static int jumpSearch(int[] arr, int x) {
        if (arr.length == 0)
            return -1;
        else if (arr[0] == x)
            return 0;
        else if (arr[arr.length - 1] == x)
            return arr.length - 1;
        int n = arr.length;
        int step = (int) Math.sqrt(n);
        int next = step;
        int prev = 0;
        while (arr[Math.min(next, n) - 1] < x) {
            prev = next;
            next += step;
            if (prev >= n)
                return -1;
        }
        for (int i = prev; i < next; i++) {
            if (arr[i] == x)
                return i;
        }
        return -1;
    }
}
