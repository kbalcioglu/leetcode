package com.solutions.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class MedianFinder {
    private LinkedList<Integer> list;
    public List<String> result;

    /**
     * initialize your data structure here.
     */
    public MedianFinder() {
        list = new LinkedList<>();
        result = new ArrayList<>();
        result.add("null");
    }

    public void addNum(int num) {
        if (list.size() == 0) {
            list.add(num);
        } else if (list.get(0) >= num) {
            list.addFirst(num);
        } else if (list.get(list.size() - 1) <= num) {
            list.addLast(num);
        } else if (list.size() > 1) {
            int h1Start = 0;
            int h2End = list.size() - 1;
            int h1End = ((h2End + h1Start) / 2);
            int h2Start = h1End + 1;
            while (true) {
                int h1E = list.get(h1End);
                int h2S = list.get(h2Start);
                if (h1E <= num && h2S >= num) {
                    list.add(h2Start, num);
                    break;
                } else if (h1E > num) {
                    int m = ((h1End + h1Start) / 2);
                    h2End = h1End;
                    h1End = m;
                    h2Start = m + 1;
                } else if (h2S < num) {
                    int m = (h2End + h2Start) / 2;
                    h1Start = h2Start;
                    h1End = m;
                    h2Start = m + 1;
                }
            }
        }
        result.add("null");
    }

    public double findMedian() {
        double median = 0;
        int size = list.size();
        if (size % 2 == 1) {
            int m = ((size + 1) / 2) - 1;
            median = list.get(m);
        } else {
            int min = Math.floorDiv((size + 1), 2) - 1;
            double minVal = list.get(min);
            int max = min + 1;
            double maxVal = list.get(max);
            median = (minVal + maxVal) / 2;
        }
        result.add(Double.toString(median));
        return median;
    }

    public void addNum2(int num){
        list.add(num);
        result.add("null");
    }
    public double findMedian2() {
        Collections.sort(list);
        double median = 0;
        int size = list.size();
        if (size % 2 == 1) {
            int m = ((size + 1) / 2) - 1;
            median = list.get(m);
        } else {
            int min = Math.floorDiv((size + 1), 2) - 1;
            double minVal = list.get(min);
            int max = min + 1;
            double maxVal = list.get(max);
            median = (minVal + maxVal) / 2;
        }
        result.add(Double.toString(median));
        return median;
    }
}
