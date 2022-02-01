package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.ListNode;

import java.util.List;

public final class ListNodeUtils {

    public static boolean checkEqualsListNode(ListNode expected, ListNode result) {
        if (expected == null && result == null)
            return true;
        while (expected != null) {
            if (result == null)
                return false;
            if (expected.val != result.val)
                return false;
            expected = expected.next;
            result = result.next;
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
            head.next = node;
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
            head.next = node;
        }
        return head;
    }

    public static String outputListNode(ListNode head) {
        return ListNodeUtils.outputListNode(head, null);
    }

    public static String outputListNode(ListNode head, String title) {
        StringBuilder sb = new StringBuilder();
        if (title != null && title.trim().length() > 0)
            System.out.println(title + " : ");
        while (head != null) {
            sb.append(head.val);
            sb.append(" --> ");
            head = head.next;
        }
        sb.append("null");
        return sb.toString();
    }

    public static ListNode reverseListNode(ListNode head) {
        if (head == null)
            return head;
        ListNode previous = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = previous;
            previous = head;
            head = next;
        }
        return previous;
    }

    public static int countListNode(ListNode head) {
        if (head == null)
            return 0;
        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    /*public static ListNode getMiddleNode(ListNode head) {
        if (head == null)
            return head;
        int count = ListNodeUtils.countListNode(head);
        int index = 0;
        ListNode pointer = head;
        while (index < count / 2) {
            pointer = pointer.next;
            index++;
        }
        return pointer;
    }*/

    public static ListNode getMiddleNode(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode appendValue(ListNode head, int new_data) {
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

    public static ListNode appendListNode(ListNode head, ListNode other) {
        while (other != null) {
            head = appendValue(head, other.val);
            other = other.next;
        }
        return head;
    }

    public static ListNode insertAfter(ListNode head, int new_data, int val) {
        if (head == null) {
            return new ListNode(new_data);
        }
        ListNode new_node = new ListNode(new_data);
        ListNode node = head;
        while (node != null) {
            if (node.val == val)
                break;
            node = node.next;
        }
        new_node.next = node.next;
        node.next = new_node;
        return node;
    }

    public static ListNode push(ListNode head, int new_data) {
        ListNode new_node = new ListNode(new_data);
        new_node.next = head;
        return new_node;
    }

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;

        int count = ListNodeUtils.countListNode(head);
        ListNode left = head;
        int index = 1;
        while (index < count/2){
            left = left.next;
            index++;
        }
        ListNode right = left.next;
        left.next = null;
        left = head;

        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);

    }

    private static ListNode merge(ListNode node1, ListNode node2) {
        ListNode result = new ListNode(Integer.MIN_VALUE);
        ListNode temp = result;
        while (node1 != null && node2 != null){
            if(node1.val < node2.val){
                temp.next = node1;
                node1 = node1.next;
            }else{
                temp.next = node2;
                node2 = node2.next;
            }
            temp = temp.next;
        }
        if(node1 != null){
            temp.next = node1;
        }
        if(node2 != null){
            temp.next = node2;
        }
        return result.next;
    }
}
