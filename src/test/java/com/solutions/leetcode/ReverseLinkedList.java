package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    @Test
    public void test_1() {
        int[] array = {10, 8, 1, 11};
        int[] expectedArray = {11, 1, 8, 10};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head,"given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected,"expected");
        ListNode result = this.reverseList(head);
        ListNodeUtils.outputListNode(result,"result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.getNext();
            head.setNext(previous);
            previous = head;
            head = next;
        }
        return previous;
    }
}

