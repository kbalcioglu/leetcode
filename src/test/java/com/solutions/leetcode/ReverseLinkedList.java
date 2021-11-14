package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    @Test
    public void test_1(){
        ListNode head = this.getTest1Head();
        ListNode expected = this.getTest1Expected();
        ListNode result = this.reverseList(head);
        this.outputListNode(head);
        this.outputListNode(result);
        this.assertListNodes(expected,result);
    }

    private boolean assertListNodes(ListNode expected,ListNode result){
        if(expected == null && result == null)
            return true;
        while (expected != null){
            if(result == null)
                return false;
            if(expected.getVal() != result.getVal())
                return false;
            expected = expected.getNext();
            result = result.getNext();
        }
        return result == null;
    }

    private ListNode getTest1Head(){
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(11);
        node3.setNext(node4);
        node2.setNext(node3);
        node1.setNext(node2);
        return node1;
    }

    private ListNode getTest1Expected(){
        ListNode node1 = new ListNode(10);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(11);
        node2.setNext(node1);
        node3.setNext(node2);
        node4.setNext(node3);
        return node4;
    }
    public ListNode reverseList(ListNode head){
        if(head == null)
            return head;
        ListNode previous = null;
        while (head != null){
            ListNode next = head.getNext();
            head.setNext(previous);
            previous = head;
            head = next;
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

