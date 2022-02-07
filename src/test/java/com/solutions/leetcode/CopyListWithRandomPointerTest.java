package com.solutions.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class CopyListWithRandomPointerTest {
    public Node copyRandomList(Node head) {
        if(head == null)
            return null;

        Map<Node,Node> copyMap = new HashMap<>();
        copyMap.put(null,null);
        Node temp = head;
        while(temp != null){
            copyMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while(temp != null){
            Node copy = copyMap.get(temp);
            copy.next = copyMap.get(temp.next);
            copy.random = copyMap.get(temp.random);
            temp = temp.next;
        }
        return copyMap.get(head);
    }

    private static class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
        }
    }
}
