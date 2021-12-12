package com.solutions.leetcode;


import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


//https://leetcode.com/problems/swap-nodes-in-pairs/
public class SwapNodesInPairsTest {

    @Test
    public void test_1() {
        ListNode head = null;
        head = ListNodeUtils.push(head, 4);
        head = ListNodeUtils.push(head, 3);
        head = ListNodeUtils.push(head, 2);
        head = ListNodeUtils.push(head, 1);


        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 3);
        expected = ListNodeUtils.push(expected, 4);
        expected = ListNodeUtils.push(expected, 1);
        expected = ListNodeUtils.push(expected, 2);

        ListNode result = swapPairs(head);

        var expectedStr = ListNodeUtils.outputListNode(expected);
        var resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }
    @Test
    public void test_2() {
        ListNode head = null;
        ListNode expected = null;
        ListNode result = swapPairs(head);

        var expectedStr = ListNodeUtils.outputListNode(expected);
        var resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    @Test
    public void test_3() {
        ListNode head = null;
        head = ListNodeUtils.push(head, 1);

        ListNode expected = null;
        expected = ListNodeUtils.push(expected, 1);

        ListNode result = swapPairs(head);

        var expectedStr = ListNodeUtils.outputListNode(expected);
        var resultStr = ListNodeUtils.outputListNode(result);
        Assertions.assertEquals(expectedStr, resultStr);
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null)
            return head;
        ListNode result = null;

        ListNode current = head;

        while (current != null) {
            ListNode node1 = current;
            current = current.next;
            ListNode node2 = null;
            if (current != null) {
                node2 = current;
                current = current.next;
            }
            node1.next = null;
            if (node2 == null) {
                result = appendListNode(result, node1);
                break;
            }
            node2.next = node1;
            result = appendListNode(result, node2);
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
        while (last.next != null)
            last = last.next;
        last.next = new_node;
        return head;
    }

    private ListNode appendListNode(ListNode head, ListNode other) {
        while (other != null) {
            head = appendValue(head, other.val);
            other = other.next;
        }
        return head;
    }
}
