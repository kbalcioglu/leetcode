package com.solutions.leetcode.models;

import java.util.Objects;

public class BinGap {
    private String start;
    private String end;
    private int size;

    public BinGap(String start, String end) {
        this.size = Math.max(start.length(), end.length());
        this.start = start;
        this.end = end;
        this.start = this.padRight(start, this.size, '0');
        this.end = this.padRight(end, this.size, '0');
    }
    public int getSize() {
        return this.size;
    }
    public String getStart() {
        return this.start;
    }

    public String getEnd() {
        return this.end;
    }

    public int getStartIndexValue(int index) {
        return this.start.charAt(index) - '0';
    }

    public int getEndIndexValue(int index) {
        return this.end.charAt(index) - '0';
    }

    private String padRight(String s, int count, char padChar) {
        return String.format("%-" + count + "s", s).replace(' ', padChar);
    }

    @Override
    public String toString() {
        return "BinGap => start : " + start +  " || end : " + end;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BinGap binGap = (BinGap) o;
        return Objects.equals(getStart(), binGap.getStart()) &&
                Objects.equals(getEnd(), binGap.getEnd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStart(), getEnd());
    }
}
