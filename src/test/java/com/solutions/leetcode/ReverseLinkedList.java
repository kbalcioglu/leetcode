package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    @Test
    public void test_1() {
        int[] array = {10, 8, 5, 1, 11};
        int[] expectedArray = {11, 1, 5, 8, 10};
        ListNode head = ListNodeUtils.generateListNode(array);
        ListNodeUtils.outputListNode(head, "given");
        ListNode expected = ListNodeUtils.generateListNode(expectedArray);
        ListNodeUtils.outputListNode(expected, "expected");
        ListNode result = ListNodeUtils.reverseListNode(head);
        ListNodeUtils.outputListNode(result,"result");
        Assertions.assertTrue(ListNodeUtils.checkEqualsListNode(expected, result));
    }

}

