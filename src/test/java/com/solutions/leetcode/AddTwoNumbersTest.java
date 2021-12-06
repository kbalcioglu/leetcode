package com.solutions.leetcode;

import com.solutions.leetcode.models.*;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/add-two-numbers/
public class AddTwoNumbersTest {
    @Test
    public void test_0() {
        int[] arr1 = {2, 4, 3};
        int[] arr2 = {5, 6, 4};
        int[] expectedArr = {7, 0, 8};
        ListNode l1 = ListNodeUtils.generateListNode(arr1);
        ListNode l2 = ListNodeUtils.generateListNode(arr2);
        String expected = ListNodeUtils.outputListNode(ListNodeUtils.generateListNode(expectedArr));
        String result = ListNodeUtils.outputListNode(this.addTwoNumbers(l1, l2));
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_2() {
        int[] arr1 = {9, 9, 9, 9, 9, 9, 9};
        int[] arr2 = {9, 9, 9, 9};
        int[] expectedArr = {8, 9, 9, 9, 0, 0, 0, 1};
        ListNode l1 = ListNodeUtils.generateListNode(arr1);
        ListNode l2 = ListNodeUtils.generateListNode(arr2);
        String expected = ListNodeUtils.outputListNode(ListNodeUtils.generateListNode(expectedArr));
        String result = ListNodeUtils.outputListNode(this.addTwoNumbers(l1, l2));
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_3() {
        int[] arr1 = {2, 4, 9};
        int[] arr2 = {5, 6, 4, 9};
        int[] expectedArr = {7, 0, 4, 0, 1};
        ListNode l1 = ListNodeUtils.generateListNode(arr1);
        ListNode l2 = ListNodeUtils.generateListNode(arr2);
        String expected = ListNodeUtils.outputListNode(ListNodeUtils.generateListNode(expectedArr));
        String result = ListNodeUtils.outputListNode(this.addTwoNumbers(l1, l2));
        Assertions.assertEquals(expected, result);

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;

        int residual = 0;
        while (l1 != null && l2 != null) {
            int k = l1.val + l2.val + residual;
            residual = 0;
            if (k >= 10) {
                k = k - 10;
                residual = 1;
            }
            l1 = l1.next;
            l2 = l2.next;
            result = ListNodeUtils.appendValue(result, k);
        }
        if (l1 == null) {
            while (l2 != null) {
                int k = l2.val + residual;
                residual = 0;
                if (k >= 10) {
                    k = k - 10;
                    residual = 1;
                }
                l2 = l2.next;
                result = ListNodeUtils.appendValue(result, k);
            }
        } else if (l2 == null) {
            while (l1 != null) {
                int k = l1.val + residual;
                residual = 0;
                if (k >= 10) {
                    k = k - 10;
                    residual = 1;
                }
                l1 = l1.next;
                result = ListNodeUtils.appendValue(result, k);
            }
        }
        if (residual > 0)
            result = ListNodeUtils.appendValue(result, residual);
        return result;
    }

}