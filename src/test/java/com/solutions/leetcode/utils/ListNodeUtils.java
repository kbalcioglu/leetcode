package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.ListNode;

import java.util.List;

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

    public static ListNode generateListNode(List<Integer> given) {
        if (given == null || given.size() == 0)
            return null;
        int lastIndex = given.size() - 1;
        ListNode head = new ListNode(given.get(lastIndex));
        lastIndex--;
        for (int i = lastIndex; i >= 0; i--) {
            ListNode node = head;
            head = new ListNode(given.get(i));
            head.setNext(node);
        }
        return head;
    }

    public static ListNode generateListNode(int[] given) {
        if (given == null || given.length == 0)
            return null;
        int lastIndex = given.length - 1;
        ListNode head = new ListNode(given[lastIndex]);
        lastIndex--;
        for (int i = lastIndex; i >= 0; i--) {
            ListNode node = head;
            head = new ListNode(given[i]);
            head.setNext(node);
        }
        return head;
    }

    public static void outputListNode(ListNode head) {
        ListNodeUtils.outputListNode(head, null);
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

    public static ListNode reverseListNode(ListNode head) {
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
