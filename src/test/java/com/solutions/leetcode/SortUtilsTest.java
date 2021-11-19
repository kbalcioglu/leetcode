package com.solutions.leetcode;

import com.solutions.leetcode.utils.SortUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
