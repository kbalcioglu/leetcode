package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.ListNode;

public class ListNodeUtils {

    public static boolean checkEqualsListNode(ListNode expected, ListNode result) {
        if (expected == null && result == null)
            return true;
        while (expected != null) {
            if (result == null)
                return false;
            if (expected.getVal() != result.getVal())
                return false;
            expected = expected.getNext();
            result = result.getNext();
        }
        return result == null;
    }

    public static ListNode generateListNode(int[] array) {
        ListNode head = null;
        for (int i = array.length - 1; i >= 0; i--) {
            if (head == null)
                head = new ListNode(array[i]);
            else {
                ListNode node = head;
                head = new ListNode(array[i]);
                head.setNext(node);
            }
        }
        return head;
    }
    public static void outputListNode(ListNode head) {
        ListNodeUtils.outputListNode(head,null);
    }
    public static void outputListNode(ListNode head, String title) {
        if (title != null && title.trim().length() > 0)
            System.out.println(title + " : ");
        while (head != null) {
            System.out.print(head.getVal());
            System.out.print(" --> ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}
