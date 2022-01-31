package com.solutions.leetcode.utils;

import java.util.Arrays;
import java.util.Comparator;

public class StringUtils {

    public void sortIntArrayLexicographically(Integer[] nums) {
        sortIntArrayLexicographically(nums, false);
    }

    public void sortIntArrayLexicographically(Integer[] nums,boolean desc) {
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int multiply = 1;
                if(desc)
                    multiply = -1;
                String s1 = String.valueOf(o1);
                String s2 = String.valueOf(o2);
                return multiply * lexicographicCompare(s1,s2);
            }
        });
    }

    public static int lexicographicCompare(String str1, String str2) {
        for (int i = 0; i < str1.length() && i < str2.length(); i++) {
            if ((int) str1.charAt(i) == (int) str2.charAt(i)) {
                continue;
            } else {
                return (int) str1.charAt(i) - (int) str2.charAt(i);
            }
        }
        if (str1.length() == str2.length())
            return 0;
        else {
            Long i1 = (Long.parseLong(str1 + str2));
            Long i2 = (Long.parseLong(str2 + str1));
            return (int)(i1 - i2);
        }
    }

    public static String padRight(Object s, int count, char padChar) {
        return String.format("%-" + count + "s", s).replace(' ', padChar);
    }

    public static String padLeft(Object s, int count, char padChar) {
        return String.format("%" + count + "s", s).replace(' ', padChar);
    }
    public static String removeLeadingZeros(String str1){
        return str1.replaceFirst("^0+(?!$)", "");
    }
}
