package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/remove-nth-node-from-end-of-list/
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void test_1() {
        int n = 2;
        ListNode head = null;
        head = ListNodeUtils.push(head, 5);
        head = ListNodeUtils.push(head, 4);
        head = ListNodeUtils.push(head, 3);
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);


        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 5);
        expected = ListNodeUtils.push(expected, 3);
        expected = ListNodeUtils.push(expected, 2);
        expected = ListNodeUtils.push(expected, 1);

        ListNode result = removeNthFromEnd(head, n);

        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_2() {
        int n = 1;
        ListNode head = null;
        ListNode expected = null;
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_3() {
        int n = 1;
        ListNode head = null;
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_4() {
        int n = 2;
        ListNode head = null;
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 1);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_5() {
        int n = 1;
        ListNode head = null;
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 1);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_6() {
        int n = 2;
        ListNode head = null;
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 2);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_7() {
        int n = 3;
        ListNode head = null;
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 2);
        expected = ListNodeUtils.push(expected, 1);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_8() {
        int n = 1;
        ListNode head = null;
        head = ListNodeUtils.push(head, 3);
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 2);
        expected = ListNodeUtils.push(expected, 1);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_9() {
        int n = 2;
        ListNode head = null;
        head = ListNodeUtils.push(head, 3);
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 3);
        expected = ListNodeUtils.push(expected, 1);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_10() {
        int n = 3;
        ListNode head = null;
        head = ListNodeUtils.push(head, 3);
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);
        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 3);
        expected = ListNodeUtils.push(expected, 2);
        ListNode result = removeNthFromEnd(head, n);
        String expectedStr = ListNodeUtils.outputListNode(expected);
        String resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int count = ListNodeUtils.countListNode(head);
        if (count < n)
            return head;
        if (count == 1 && n == 1)
            return null;
        int index = count - n;

        // if nth node is the first node
        if (index == 0) {
            head = head.next;
            return head;
        }

        ListNode current = head;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        // if nth node is the last node
        if(n == 1){
            current.next = null;
            return head;
        }

        if(current != null && current.next != null){
            ListNode deleteNode = current.next;
            if(deleteNode.next != null){
                current.next = deleteNode.next;
            }
        }

        return head;
    }


}
