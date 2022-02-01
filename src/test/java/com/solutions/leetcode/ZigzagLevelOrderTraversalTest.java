package com.solutions.leetcode;

import com.solutions.leetcode.models.BinaryTreeNode;

import java.util.*;

public class ZigzagLevelOrderTraversalTest {
    public List<List<Integer>> zigzagLevelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isReversed = true;

        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i< size;i++){
                BinaryTreeNode node = queue.poll();
                if(node != null){
                    if(isReversed)
                        levelList.add(node.getVal());
                    else
                        levelList.add(0,node.getVal());

                    queue.offer(node.getLeft());
                    queue.offer(node.getRight());
                }
            }
            isReversed = !isReversed;

            if(levelList.size()>0)
                result.add(levelList);
        }
        return result;
    }

    public List<List<Integer>> zigzagLevelOrder2(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        List<BinaryTreeNode> childList = new ArrayList<>();

        boolean isReversed = true;
        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            if(isReversed)
                list.add(node.getVal());
            else
                list.add(0,node.getVal());

            if(node.getLeft() != null)
                childList.add(node.getLeft());

            if(node.getRight() != null)
                childList.add(node.getRight());

            if(queue.isEmpty()){
                result.add(list);
                list = new ArrayList<>();
                while(childList.size()>0){
                    queue.offer(childList.get(0));
                    childList.remove(0);
                }
                isReversed = !isReversed;
            }
        }
        return result;
    }
}
