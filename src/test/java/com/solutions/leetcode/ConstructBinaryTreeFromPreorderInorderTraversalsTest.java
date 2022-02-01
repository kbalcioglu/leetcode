package com.solutions.leetcode;

import com.solutions.leetcode.models.BinaryTreeNode;

import java.util.Arrays;

public class ConstructBinaryTreeFromPreorderInorderTraversalsTest {
    public BinaryTreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0)
            return null;

        BinaryTreeNode root = new BinaryTreeNode(preorder[0]);
        int mid;
        for (mid = 0; mid < inorder.length; mid++) {
            if (inorder[mid] == preorder[0])
                break;
        }

        root.setLeft(buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid)));
        root.setRight(buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, inorder.length)));
        return root;
    }
}
