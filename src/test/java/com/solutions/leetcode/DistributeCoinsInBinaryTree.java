package com.solutions.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

//https://leetcode.com/problems/distribute-coins-in-binary-tree/
public class DistributeCoinsInBinaryTree {

    @Test
    public void test_0() {
        Integer[] array = {3, 0, 0};
        TreeNode root = createBinaryTree(array);
        int expected = 2;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_1() {
        Integer[] array = {0, 3, 0};
        TreeNode root = createBinaryTree(array);
        int expected = 3;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        Integer[] array = {1, 0, 2};
        TreeNode root = createBinaryTree(array);
        int expected = 2;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        Integer[] array = {1, 0, 0, null, 3};
        TreeNode root = createBinaryTree(array);
        int expected = 4;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        Integer[] array = {1, 1, 1, 0, 1, 2, 0, null, null, 3, null, null, 0};
        TreeNode root = createBinaryTree(array);
        int expected = 9;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    /*@Test
    public void test_5() {
        Integer[] array = {4, 0, null, null, 0, null, 0};
        TreeNode root = createBinaryTree(array);
        int expected = 6;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }*/

    @Test
    public void test_6() {
        Integer[] array = {4, 0, null, null, 0, null, null, null, null, null, 0};
        TreeNode root = createBinaryTree(array);
        int expected = 6;
        int result = distributeCoins(root);
        Assertions.assertEquals(expected, result);
    }

    private int totalMoves;

    public int distributeCoins(TreeNode root) {
        totalMoves = 0;
        if (root == null)
            return 0;
        dfsRecursive(root);

        return totalMoves;
    }

    private int dfsRecursive(TreeNode node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null) {
            if (node.val == 1)
                return 0;
            else{
                int x = 0;
                if (node.val < 1)
                    x = -1 * (Math.abs(node.val) + 1);
                else
                    x = node.val - 1;
                totalMoves += Math.abs(x);
                node.val = 1;
                return x;
            }
        }
        node.val += dfsRecursive(node.left);
        node.val += dfsRecursive(node.right);
        if (node.val == 1)
            return 0;
        else{
            int x = 0;
            if (node.val < 1)
                x = -1 * (Math.abs(node.val) + 1);
            else
                x = node.val - 1;
            totalMoves += Math.abs(x);
            node.val = 1;
            return x;
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode createBinaryTree(Integer[] array) {
        if (array == null || array.length == 0)
            return null;
        if (array[0] == null)
            return null;
        TreeNode root = null;
        root = appendNode(root, array, 0);
        return root;
    }

    private TreeNode appendNode(TreeNode node, Integer[] array, int index) {
        if (index >= array.length)
            return null;
        if (array[index] == null)
            return null;
        if (node == null)
            node = new TreeNode(array[index]);
        node.left = appendNode(node.left, array, (2 * index) + 1);
        node.right = appendNode(node.right, array, (2 * index) + 2);
        return node;
    }
}


