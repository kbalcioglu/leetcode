package com.solutions.leetcode;

import com.solutions.leetcode.enums.SortType;
import com.solutions.leetcode.utils.SortUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

public class SortUtilsTest {

    private void displayArray(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            if (i > 0)
                sb.append(",");
            sb.append(array[i]);
        }
        System.out.println(sb.toString());
    }

    @Test
    public void testBubbleSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.bubbleSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testBubbleSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.bubbleSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.selectionSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testSelectionSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.selectionSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.insertionSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testInsertionSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.insertionSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testShellSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.shellSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testShellSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.shellSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.mergeSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testMergeSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.mergeSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortAsc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {-48, -22, -15, 1, 4, 7, 9, 12, 20, 35, 36, 55, 124};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.quickSortAsc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testQuickSortDesc() {
        int[] array = {20, 35, -15, 7, 55, 1, -22, -48, 124, 12, 4, 36, 9};
        int[] expected = {124, 55, 36, 35, 20, 12, 9, 7, 4, 1, -15, -22, -48};
        System.out.println("Given : ");
        displayArray(array);
        SortUtils.quickSortDesc(array);
        System.out.println("Expected : ");
        displayArray(expected);
        System.out.println("Result : ");
        displayArray(array);
        Assertions.assertArrayEquals(expected, array);
    }

    @Test
    public void testCompare() {
        try {
            Thread.sleep(50);
            int[] array = generateRandomArray(9000);
            for (SortType sortType : SortType.values()) {
                Thread.sleep(10);
                int[] given = array;
                long start = System.currentTimeMillis();
                sortAsc(sortType, array);
                long elapsed = System.currentTimeMillis() - start;
                System.out.println(String.format("ASC SortType : %s - elapsed : %s", sortType, elapsed));
            }
            for (SortType sortType : SortType.values()) {
                Thread.sleep(10);
                int[] given = array;
                long start = System.currentTimeMillis();
                sortDesc(sortType, array);
                long elapsed = System.currentTimeMillis() - start;
                System.out.println(String.format("DESC SortType : %s - elapsed : %s", sortType, elapsed));
            }
        } catch (Throwable th) {
            System.out.println(th.getMessage());
        }
    }

    private void sortAsc(SortType sortType, int[] array) {
        switch (sortType) {
            case BUBBLE:
                SortUtils.bubbleSortAsc(array);
                break;
            case SELECTION:
                SortUtils.selectionSortAsc(array);
                break;
            case INSERTION:
                SortUtils.insertionSortAsc(array);
                break;
            case SHELL:
                SortUtils.shellSortAsc(array);
                break;
            case MERGE:
                SortUtils.mergeSortAsc(array);
                break;
            case QUICK:
                SortUtils.quickSortAsc(array);
                break;
        }
    }

    private void sortDesc(SortType sortType, int[] array) {
        switch (sortType) {
            case BUBBLE:
                SortUtils.bubbleSortDesc(array);
                break;
            case SELECTION:
                SortUtils.selectionSortDesc(array);
                break;
            case INSERTION:
                SortUtils.insertionSortDesc(array);
                break;
            case SHELL:
                SortUtils.shellSortDesc(array);
                break;
            case MERGE:
                SortUtils.mergeSortDesc(array);
                break;
            case QUICK:
                SortUtils.quickSortDesc(array);
                break;
        }
    }

    private int[] generateRandomArray(int count) {
        Random random = new Random();
        int[] array = new int[count];
        int i = 0;
        while (i < count) {
            int number = random.nextInt(Integer.MAX_VALUE - 0) + 0;
            array[i++] = number;
        }
        return array;
    }
}
