package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBSTTest {
    @Test
    public void test_1() {
        TreeNode root = new TreeNode(2147483647);
        boolean result = isValidBST(root);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3);
        TreeNode node6 = new TreeNode(12);
        node1.left = node3;
        node1.right = node4;
        root.left = node1;
        node2.left = node5;
        node2.right = node6;
        root.right = node2;
        boolean result = isValidBST(root);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_3() {
        TreeNode root = new TreeNode(2);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        boolean result = isValidBST(root);
        Assertions.assertFalse(result);
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null)
            return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    // DFS
    public boolean isValidBST(TreeNode node, long min, long max) {
        if (node == null)
            return true;
        if (node.val <= min || node.val >= max)
            return false;

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }
}
