package com.solutions.leetcode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
public class FindMedianFromDataStream {
    @Test
    public void test1() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
        System.out.println(medianFinder.result);
        //[null, null, null, 1.5, null, 2.0]
        List<String> expected = List.of(
                "null","null","null"
                ,"1.5","null"
                ,"2.0"
        );
        Assertions.assertEquals(expected.size(), medianFinder.result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), medianFinder.result.get(i));
        }
    }

    @Test
    public void test2() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(6);
        medianFinder.findMedian();
        medianFinder.addNum(10);
        medianFinder.findMedian();
        medianFinder.addNum(2);
        medianFinder.findMedian();
        medianFinder.addNum(6);
        medianFinder.findMedian();
        medianFinder.addNum(5);
        medianFinder.findMedian();
        medianFinder.addNum(0);
        medianFinder.findMedian();
        medianFinder.addNum(6);
        medianFinder.findMedian();
        medianFinder.addNum(3);
        medianFinder.findMedian();
        medianFinder.addNum(1);
        medianFinder.findMedian();
        medianFinder.addNum(0);
        medianFinder.findMedian();
        medianFinder.addNum(0);
        medianFinder.findMedian();
        List<String> expected = List.of(
                "null","null"
                ,"6.0","null"
                ,"8.0","null"
                ,"6.0","null"
                ,"6.0","null"
                ,"6.0","null"
                ,"5.5","null"
                ,"6.0","null"
                ,"5.5","null"
                ,"5.0","null"
                ,"4.0","null"
                ,"3.0"
        );
        System.out.println(medianFinder.result);
        System.out.println(expected);
        Assertions.assertEquals(expected.size(), medianFinder.result.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), medianFinder.result.get(i));
        }
    }
    @Test
    public void test3() {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(0);
        medianFinder.addNum(0);
        medianFinder.findMedian();
        List<String> expected = List.of(
                "null","null","null"
                ,"0.0"
        );
        System.out.println(medianFinder.result);
        System.out.println(expected);
        Assertions.assertEquals(expected.size(), medianFinder.result.size());

        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), medianFinder.result.get(i));
        }
    }
}
