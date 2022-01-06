package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PartitionListTest {
    @Test
    public void test_1() {
        int[] givenArr = {1, 4, 3, 2, 5, 2};
        ListNode head = null;
        for (int i : givenArr) {
            head = appendValue(head, i);
        }
        ListNode result = partition(head, 3);
        String expected = "1 --> 2 --> 2 --> 4 --> 3 --> 5 --> null";
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expected, resultStr);
    }

    @Test
    public void test_2() {
        int[] givenArr = {4, 3, 1, 2, 5, 2};
        ListNode head = null;
        for (int i : givenArr) {
            head = appendValue(head, i);
        }
        ListNode result = partition(head, 3);
        String expected = "1 --> 2 --> 2 --> 4 --> 3 --> 5 --> null";
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expected, resultStr);
    }

    @Test
    public void test_3() {
        int[] givenArr = {1, 4, 3, 0, 2, 5, 2};
        ListNode head = null;
        for (int i : givenArr) {
            head = appendValue(head, i);
        }
        ListNode result = partition(head, 3);
        String expected = "1 --> 0 --> 2 --> 2 --> 4 --> 3 --> 5 --> null";
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expected, resultStr);
    }

    @Test
    public void test_4() {
        int[] givenArr = {2,1};
        ListNode head = null;
        for (int i : givenArr) {
            head = appendValue(head, i);
        }
        ListNode result = partition(head, 2);
        String expected = "1 --> 2 --> null";
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expected, resultStr);
    }
    public ListNode partition(ListNode head, int x) {
        if(head == null)
            return null;
        ListNode result = new ListNode(0);
        ListNode left = result;
        ListNode rest = new ListNode(0);
        ListNode right = rest;

        while (head != null) {
            int i = head.val;
            if (i < x) {
                left.next = new ListNode(i);
                left = left.next;
            } else {
                right.next = new ListNode(i);
                right = right.next;
            }
            head = head.next;
        }
        left.next = rest.next;
        result = result.next;
        return result;
    }
    public ListNode partition2(ListNode head, int x) {
        ListNode result = null;
        while (head != null) {
            int i = head.val;
            if (i < x) {
                result = insert(result, i, x);
            } else {
                result = appendValue(result, i);
            }
            head = head.next;
        }
        return result;
    }

    private ListNode appendValue(ListNode head, int new_data) {
        ListNode new_node = new ListNode(new_data);
        if (head == null) {
            head = new ListNode(new_data);
            return head;
        }
        new_node.next = null;
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = new_node;
        return head;
    }

    private ListNode insert(ListNode head, int new_data, int val) {
        if (head == null) {
            return new ListNode(new_data);
        }
        ListNode new_node = new ListNode(new_data);
        ListNode node = head;
        ListNode prev = null;
        while (node != null) {
            if (node.val < val) {
                prev = node;
                node = node.next;
            } else
                break;
        }
        new_node.next = node;
        if (prev != null) {
            prev.next = new_node;
        } else {
            head = new_node;
        }
        return head;
    }
}
