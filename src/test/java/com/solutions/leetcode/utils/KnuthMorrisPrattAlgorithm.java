package com.solutions.leetcode.utils;

import java.util.*;

public class KnuthMorrisPrattAlgorithm {
    private static class PartialMatchingElement {
        private final char character;
        private int value;

        PartialMatchingElement(char character) {
            this.character = character;
            this.value = 0;
        }

        char getCharacter() {
            return character;
        }

        int getValue() {
            return value;
        }

        void setValue(int value) {
            this.value = value;
        }
    }

    private static class PartialMatchingTable {
        private final int size;
        private final String pattern;
        private final int[] partialMatchingTable;

        PartialMatchingTable(String pattern) {
            this.size = pattern.length();
            this.pattern = pattern;
            this.partialMatchingTable = new int[pattern.length()];
            int i = 1;
            int prefixCounter = 0;

            while (i < pattern.length()) {
                if (pattern.charAt(i) == pattern.charAt(prefixCounter)) {
                    prefixCounter++;
                    this.partialMatchingTable[i] = prefixCounter;
                    i++;
                } else if (prefixCounter != 0) {
                    prefixCounter = this.partialMatchingTable[prefixCounter - 1];
                } else {
                    this.partialMatchingTable[i] = 0;
                    i++;
                }
            }
        }


        String getPattern() {
            return pattern;
        }

        int getValue(int index) {
            return partialMatchingTable[index];
        }

        int getSize() {
            return size;
        }

        char getChar(int index) {
            return this.pattern.charAt(index);
        }
    }

    private final String text;
    private final PartialMatchingTable partialMatchingTable;

    /**
     * pattern => pattern to search
     */
    public KnuthMorrisPrattAlgorithm(String pattern, String text) {
        this.text = text;
        this.partialMatchingTable = new PartialMatchingTable(pattern);
    }

    /**
     * text that we will check our pattern
     */
    public  List<Integer> search() {
        List<Integer> foundPatternIndex = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < text.length() && j < partialMatchingTable.getSize()) {
            if (text.charAt(i) == partialMatchingTable.getChar(j)) {
                i++;
                j++;
            }
            // found value
            if (j == partialMatchingTable.getSize()) {
                foundPatternIndex.add(i - j);
                j = partialMatchingTable.getValue(j - 1);
            }
            if (i < text.length() && text.charAt(i) != partialMatchingTable.getChar(j)) {
                if (j != 0)
                    j = partialMatchingTable.getValue(j - 1);
                else
                    i++;
            }
        }
        return foundPatternIndex;
    }

}
