package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class MostFrequentSubtreeSumTest {
    /*
    Given the root of a binary tree, return the most frequent subtree sum.
    If there is a tie, return all the values with the highest frequency in any order.

    The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at that node
    (including the node itself).
        5                                           4
       / \                                         / \
      2  -3                                       2  -4
      rootVal   = 5 + 2 - 3 = 4                 rootVal     = 4 + 2 -4 = 2
      leftVal   = 2                             leftVal     = 2
      rightVal  = -3                            rightVal    = -4
      result [4,2,-3]                           result = 2 (2nin frequency = 2 -4 1 olduğun için sadece 2)
    */
    private void assertion(int[] expected, int[] result) {
        Assertions.assertEquals(expected.length, result.length);
        List<Integer> expectedList = new ArrayList<>();
        for (int i = 0; i < expected.length; i++) {
            expectedList.add(expected[i]);
        }
        for (int i = 0; i < expected.length; i++) {
            Assertions.assertEquals(true,expectedList.contains(result[i]));
        }
    }

    @Test
    public void test_s1() {
        TreeNode root = this.createTree1();
        int[] result = this.findFrequentTreeSum(root);
        int[] expected = {4, 2, -3};
        assertion(expected,result);
    }

    @Test
    public void test_s2() {
        TreeNode root = this.createTree2();
        int[] result = this.findFrequentTreeSum(root);
        int[] expected = {2};
        assertion(expected,result);
    }

    public void insertValueToFrequencyMap(Map<Integer, Integer> valueFrequencyMap, int val) {
        int f = 1;
        if (valueFrequencyMap.containsKey(val)) {
            f = valueFrequencyMap.get(val) + 1;
            valueFrequencyMap.remove(val);
        }
        valueFrequencyMap.put(val, f);
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer, Integer> valueFrequencyMap = new HashMap<>();
        findFrequentTreeSumRec(valueFrequencyMap, root);
        int maxF = 0;
        List<Integer> resultList = new ArrayList<>();
        for (int val : valueFrequencyMap.keySet()) {
            int f = valueFrequencyMap.get(val);
            if (f > maxF) {
                resultList = new ArrayList<>();
                resultList.add(val);
                maxF = f;
            } else if (f == maxF) {
                resultList.add(val);
            }
        }
        if (resultList.size() > 0) {
            int[] result = new int[resultList.size()];
            for (int i = 0; i < resultList.size(); i++) {
                result[i] = resultList.get(i);
            }
            return result;
        }
        int[] result = new int[resultList.size()];
        return result;
    }

    public int findFrequentTreeSumRec(Map<Integer, Integer> valueFrequencyMap, TreeNode node) {
        if (node == null)
            return 0;
        int left = findFrequentTreeSumRec(valueFrequencyMap, node.left);
        int right = findFrequentTreeSumRec(valueFrequencyMap, node.right);
        int total = node.val + left + right;
        insertValueToFrequencyMap(valueFrequencyMap, total);
        return total;
    }

    private TreeNode createTree1() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-3);
        return node;
    }

    private TreeNode createTree2() {
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(2);
        node.right = new TreeNode(-5);
        return node;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        int nodeSum() {
            int leftVal = this.left != null ? this.left.val : 0;
            int rightVal = this.right != null ? this.right.val : 0;
            return this.val + leftVal + rightVal;
        }
    }

}
