package com.solutions.leetcode;

import com.solutions.leetcode.models.BinaryTreeNode;

import java.util.*;

public class BinaryTreeLevelOrderTraversalTest {

    public List<List<Integer>> levelOrder(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<Integer> list = new ArrayList<>();
        List<BinaryTreeNode> childList = new ArrayList<>();

        while(!queue.isEmpty()){
            BinaryTreeNode node = queue.poll();
            list.add(node.getVal());
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
            }
        }
        return result;
    }

    public List<List<Integer>> levelOrder2(BinaryTreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> levelList = new ArrayList<>();
            for(int i = 0; i< size;i++){
                BinaryTreeNode node = queue.poll();
                if(node != null){
                    levelList.add(node.getVal());
                    queue.offer(node.getLeft());
                    queue.offer(node.getRight());
                }
            }
            if(levelList.size()>0)
                result.add(levelList);
        }
        return result;
    }
}
