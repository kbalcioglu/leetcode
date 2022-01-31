package com.solutions.leetcode;

import com.solutions.leetcode.models.BinaryTreeNode;
import com.solutions.leetcode.utils.BSTUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidateBSTTest {
    @Test
    public void test_1() {
        BinaryTreeNode root = new BinaryTreeNode(2147483647);
        boolean result = BSTUtils.isValidBST(root);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        BinaryTreeNode root = new BinaryTreeNode(5);
        BinaryTreeNode node1 = new BinaryTreeNode(3);
        BinaryTreeNode node2 = new BinaryTreeNode(8);
        BinaryTreeNode node3 = new BinaryTreeNode(1);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node5 = new BinaryTreeNode(3);
        BinaryTreeNode node6 = new BinaryTreeNode(12);
        node1.setLeft(node3);
        node1.setRight(node4);
        root.setLeft(node1);
        node2.setLeft(node5);
        node2.setRight(node6);
        root.setRight(node2);
        boolean result = BSTUtils.isValidBST(root);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_3() {
        BinaryTreeNode root = new BinaryTreeNode(2);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        root.setLeft(node1);
        root.setRight(node2);
        boolean result = BSTUtils.isValidBST(root);
        Assertions.assertFalse(result);
    }
}
