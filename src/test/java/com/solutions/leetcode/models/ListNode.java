
package com.solutions.leetcode.models;

public class ListNode {
    private int val;
    private ListNode next;

    public int getVal(){
        return this.val;
    }

    public ListNode getNext(){
        return this.next;
    }

    public ListNode setVal(int val){
        this.val = val;
        return this;
    }

    public ListNode setNext(ListNode next){
        this.next = next;
        return this;
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

