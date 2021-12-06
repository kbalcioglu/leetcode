package com.solutions.leetcode.utils;

import java.util.*;

public final class StringOperations {

    private StringOperations() {

    }

    // O(n)
    public static String revertString(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--) {
            sb.append(text.charAt(i));
        }
        return sb.toString();
    }

    // O(n)
    public static List<String> getSuffixes(String text) {
        List<String> suffixList = new ArrayList<>();
        for (int i = text.length() - 1; i >= 0; i--) {
            suffixList.add(text.substring(i));
        }
        return suffixList;
    }

    // O(n)
    public static List<String> getPrefixes(String text) {
        List<String> prefixList = new ArrayList<>();
        for (int i = 1; i <= text.length(); i++) {
            prefixList.add(text.substring(0, i));
        }
        return prefixList;
    }

    // O(n)
    public static String longestCommonPrefix(String text1, String text2) {
        int commonLength = Math.min(text1.length(), text2.length());
        for (int i = 0; i < commonLength; i++) {
            if (text1.charAt(i) != text2.charAt(i)) {
                return text1.substring(0, i);
            }
        }
        return text1.substring(0, commonLength);
    }

    public static String longestRepeatedSubstring(String text) {
        List<String> suffixes = getSuffixes(text); // O(n);
        Collections.sort(suffixes); // O(n log n) -> merge sort;
        String longestRepeatedSubstring = "";
        for (int i = 0; i < text.length() - 1; i++) { // O(n)
            String temp = longestCommonPrefix(suffixes.get(i), suffixes.get(i + 1)); // O(n)
            if (temp.length() > longestRepeatedSubstring.length()) {
                longestRepeatedSubstring = temp;
            }
        }
        return longestRepeatedSubstring;
    }

    public static int longestSubstringWithoutRepeat(String s) {
        if (s == null || s.length() == 0)
            return 0;
        if(s.length() == 1)
            return 1;
        Map<Character, Integer> chars = new HashMap<>();
        int maxLength = 1;
        int i = 0;
        int j = 1;
        chars.put(s.charAt(i),i);
        while (i < s.length()
                && j < s.length()
                && i <= j
                && (s.length() - i > maxLength)) {
            char c = s.charAt(j);

            if (!chars.containsKey(c)) {
                chars.put(c, j);
                j++;
            } else {
                i = chars.get(c) + 1;
                j = i + 1;
                chars = new HashMap<>();
                chars.put(s.charAt(i),i);
            }
            maxLength = Math.max(maxLength, s.substring(i, j).length());
        }


        return maxLength;
    }
}
