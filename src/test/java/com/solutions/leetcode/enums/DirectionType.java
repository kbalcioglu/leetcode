package com.solutions.leetcode.enums;

public enum DirectionType {
    LEFT(new int[]{0, -1}),
    RIGHT(new int[]{0, 1}),
    UP(new int[]{-1, 0}),
    DOWN(new int[]{1, 0});

    private final int[] value;

    DirectionType(int[] value) {
        this.value = value;
    }

    public int[] getValue(){
        return this.value;
    }
}
