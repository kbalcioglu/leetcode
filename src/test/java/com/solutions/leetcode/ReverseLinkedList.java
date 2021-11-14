package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    @Test
    public void test_1(){
        ListNode head = new ListNode(10);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(11);
        node3.setNext(node4);
        node2.setNext(node3);
        head.setNext(node2);
        this.outputListNode(head);
        ListNode reverse = this.reverseList(head);
        this.outputListNode(reverse);
    }

    public ListNode reverseList(ListNode head){
        if(head == null)
            return head;
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;
        while (current != null){
            next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }
        return previous;
    }
    private void outputListNode(ListNode head){
        while (head != null){
            System.out.print(head.getVal());
            System.out.print(" --> ");
            head = head.getNext();
        }
        System.out.println("null");
    }
}

