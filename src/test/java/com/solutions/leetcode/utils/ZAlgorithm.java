package com.solutions.leetcode.utils;

import java.util.ArrayList;
import java.util.List;

public class ZAlgorithm {
    private final String text;
    private final String pattern;
    private final String patternText;
    private final int[] zTable;
    private final int n;

    public ZAlgorithm(String text, String pattern) {
        this.text = text;
        this.pattern = pattern;
        this.patternText = pattern + text;
        this.n = this.patternText.length();
        this.zTable = new int[this.patternText.length()];
    }

    public List<Integer> search() {
        List<Integer> foundPatternIndex = new ArrayList<>();
        constructTable();
        for (int i = 0; i < zTable.length; i++) {
            if (zTable[i] >= pattern.length()) {
                foundPatternIndex.add(i - pattern.length());
            }
        }
        return foundPatternIndex;
    }

    private void constructTable() {
        int leftIndex = 0;
        int rightIndex = 0;
        for (int k = 1; k < n; k++) {
            // outside the scope of z box
            if (k > rightIndex) {
                int matchCounter = 0;
                while (k + matchCounter < n && patternText.charAt(matchCounter) == patternText.charAt(k + matchCounter)) {
                    matchCounter++;
                }
                this.zTable[k] = matchCounter;
                leftIndex = k;
                rightIndex = k + matchCounter - 1;
            } else {
                // k is with in z box
                int p = k - leftIndex;
                if (zTable[p] < rightIndex - k + 1) {
                    zTable[k] = zTable[p];
                } else {
                    int i = rightIndex + 1;
                    while (i < n && patternText.charAt(i) == patternText.charAt(i - k)) {
                        i++;
                    }
                    zTable[k] = i - k;
                    leftIndex = k;
                    rightIndex = i - 1;
                }
            }
        }
    }
}
