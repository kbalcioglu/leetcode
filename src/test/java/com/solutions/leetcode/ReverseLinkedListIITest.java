package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-linked-list-ii/
public class ReverseLinkedListIITest {
    @Test
    public void test_1() {
        int left = 3;
        int right = 7;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {1, 2, 7, 6, 5, 4, 3, 8, 9};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head, "given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected, "expected");
        ListNode result = this.reverseBetween(head, left, right);
        ListNodeUtils.outputListNode(result, "result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

    @Test
    public void test_2() {
        int left = 1;
        int right = 7;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {7, 6, 5, 4, 3, 2, 1, 8, 9};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head, "given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected, "expected");
        ListNode result = this.reverseBetween(head, left, right);
        ListNodeUtils.outputListNode(result, "result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

    @Test
    public void test_3() {
        int left = 1;
        int right = 9;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head, "given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected, "expected");
        ListNode result = this.reverseBetween(head, left, right);
        ListNodeUtils.outputListNode(result, "result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

    @Test
    public void test_4() {
        int left = 5;
        int right = 9;
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] expectedArray = {1, 2, 3, 4, 9, 8, 7, 6, 5};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head, "given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected, "expected");
        ListNode result = this.reverseBetween(head, left, right);
        ListNodeUtils.outputListNode(result, "result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

    /**
     * left,right are positions -> reverse between these positions
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return head;
        if (right < left)
            return head;

        ListNode result = null;
        ListNode middle = null;

        int index = 1;
        while (head != null) {
            if (index < left) {
                result = ListNodeUtils.appendValue(result, head.val);
                head = head.next;
            } else if (index > right) {
                middle = ListNodeUtils.appendValue(middle, head.val);
                head = head.next;
            } else {
                ListNode next = head.next;
                head.next = middle;
                middle = head;
                head = next;
            }
            index++;
        }
        result = ListNodeUtils.appendListNode(result, middle);
        return result;
    }

}
