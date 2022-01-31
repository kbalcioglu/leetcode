package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.BinaryTreeNode;

import java.util.*;
import java.util.stream.Collectors;

public final class BSTUtils {

    private BSTUtils() {

    }

    public static boolean isValidBST(final BinaryTreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // DFS
    public static boolean isValidBST(final BinaryTreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.getVal() <= min || node.getVal() >= max)
            return false;

        return isValidBST(node.getLeft(), min, node.getVal()) && isValidBST(node.getRight(), node.getVal(), max);
    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int val) {
        if (root == null) {
            return new BinaryTreeNode(val);
        } else {
            BinaryTreeNode cur;
            if (val <= root.getVal()) {
                cur = insert(root.getLeft(), val);
                root.setLeft(cur);
            } else {
                cur = insert(root.getRight(), val);
                root.setRight(cur);
            }
            return root;
        }
    }

    public static BinaryTreeNode deserialize(String s) {
        if (s == null || s.length() == 0)
            return null;
        List<String> list = new ArrayList<>();
        String[] arr = s.split(",");
        for (String x : arr) {
            list.add(x);
        }
        int k = 0;
        int m = 0;
        while (true) {
            m += (int) Math.pow(2, k);
            if (m >= list.size())
                break;
            k++;
        }
        for (int i = list.size(); i < m; i++) {
            list.add("null");
        }
        int index = 1;
        Queue<BinaryTreeNode> q = new LinkedList<>();
        BinaryTreeNode node = new BinaryTreeNode(Integer.parseInt(list.get(0)));
        q.offer(node);
        while (!q.isEmpty() && index < m) {
            BinaryTreeNode current = q.poll();
            if (!list.get(index).equals("null")) {
                current.setLeft(new BinaryTreeNode(Integer.parseInt(list.get(index))));
                q.offer(current.getLeft());
            }
            index++;
            if (!list.get(index).equals("null")) {
                current.setRight(new BinaryTreeNode(Integer.parseInt(list.get(index))));
                q.offer(current.getRight());
            }
            index++;
        }

        return node;
    }

    public static String serialize(final BinaryTreeNode root) {
        if (root == null)
            return "";
        List<String> list = new ArrayList<>();
        Queue<BinaryTreeNode> currentlevel = new LinkedList<>();
        Queue<BinaryTreeNode> nextlevel = new LinkedList<>();
        currentlevel.add(root);
        while (!currentlevel.isEmpty()) {
            BinaryTreeNode temp = currentlevel.poll();
            if (temp.getVal() == -999999999) {
                list.add("null");
            } else {
                list.add(String.valueOf(temp.getVal()));
                if (temp.getLeft() != null)
                    nextlevel.add(temp.getLeft());
                else
                    nextlevel.add(new BinaryTreeNode(-999999999));
                if (temp.getRight() != null)
                    nextlevel.add(temp.getRight());
                else
                    nextlevel.add(new BinaryTreeNode(-999999999));
            }
            if (currentlevel.isEmpty()) {
                Queue<BinaryTreeNode> t = currentlevel;
                currentlevel = nextlevel;
                nextlevel = t;
            }
        }
        while (true) {
            if (list.get(list.size() - 1).equals("null"))
                list.remove(list.size() - 1);
            else
                break;
        }
        return String.join(",", list);
    }

    public static List<BinaryTreeNode> findDuplicateSubtrees(final BinaryTreeNode root) {
        Set<BinaryTreeNode> result = new HashSet<>();
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<BinaryTreeNode> exists = new HashSet<>();
        while (!queue.isEmpty()) {
            BinaryTreeNode current = queue.poll();
            if (exists.contains(current)) {
                result.add(current);
            } else {
                exists.add(current);
            }
            if (current.getLeft() != null)
                queue.offer(current.getLeft());
            if (current.getRight() != null)
                queue.offer(current.getRight());

        }

        return result.stream().collect(Collectors.toList());
    }
}
