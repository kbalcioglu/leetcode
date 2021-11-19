package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.BINNode;

public class BINNodeUtils {
    private static int BIN_LENGTH = 12;

    public static void extendTree(BINNode tree, String bin) {
        bin = padRight(bin, '0');
        String[] chars = bin.split("");
        BINNode currentNode = tree;
        for (int i = 0; i < chars.length; i++) {
            int num = tryToParse(chars[i]);
            if (num < 0)
                throw new IllegalArgumentException("Given bin is incorrect");
            if (currentNode.getChildNode(num) == null) {
                currentNode.setChildNode(BINNode.newNode(num), num);
            }
            currentNode = currentNode.getChildNode(num);
        }
    }

    public static void extendTree(BINNode tree, String startBin, String endBin) {
        startBin = padRight(startBin, '0');
        endBin = padRight(endBin, '0');
        String[] startBinChars = startBin.split("");
        String[] endBinChars = endBin.split("");
        for (int i = 0; i < BIN_LENGTH; i++) {
            int startNum = tryToParse(startBinChars[i]);
            int endNum = tryToParse(endBinChars[i]);

        }
    }

    private static int tryToParse(String s) {
        try {
            return Integer.parseInt(s);
        } catch (Exception ex) {
            return -1;
        }
    }

    public static String padRight(String s, char padChar) {

        return String.format("%-" + BIN_LENGTH + "s", s).replace(' ', padChar);
    }

    public static String padRight(String s, int count, char padChar) {

        return String.format("%-" + count + "s", s).replace(' ', padChar);
    }
}
