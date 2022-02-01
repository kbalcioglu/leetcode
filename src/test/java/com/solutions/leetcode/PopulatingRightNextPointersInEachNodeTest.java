package com.solutions.leetcode;

import java.util.*;

public class PopulatingRightNextPointersInEachNodeTest {
    public PointerNode connect(PointerNode root) {
        if(root == null)
            return root;

        Queue<PointerNode> queue = new LinkedList<>();
        queue.offer(root);

        List<PointerNode> childList = new ArrayList<>();

        while(!queue.isEmpty()){
            PointerNode node = queue.poll();
            if(node.left != null)
                childList.add(node.left);
            if(node.right != null)
                childList.add(node.right);
            if(queue.isEmpty() && childList.size()>0){
                queue.offer(childList.get(0));
                for(int i = 1; i< childList.size();i++){
                    queue.offer(childList.get(i));
                    childList.get(i-1).next = childList.get(i);
                }
                childList = new ArrayList<>();
            }
        }
        return root;
    }

    static class PointerNode{
        public int val;
        public PointerNode left;
        public PointerNode right;
        public PointerNode next;

        public PointerNode() {}

        public PointerNode(int _val) {
            val = _val;
        }

        public PointerNode(int _val, PointerNode _left, PointerNode _right, PointerNode _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }
}
