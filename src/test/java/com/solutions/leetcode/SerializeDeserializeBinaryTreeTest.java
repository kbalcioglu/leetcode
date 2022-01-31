package com.solutions.leetcode;

import com.solutions.leetcode.models.BinaryTreeNode;
import com.solutions.leetcode.utils.BSTUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

// TODO : yapamadım !!
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBinaryTreeTest {
    @Test
    public void test_1() {
        String given = "1,2,3,4,5,6,7,8";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_2() {
        String given = "1,2,3,null,null,4,5";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_3() {
        String given = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_4() {
        String given = "1,2,3,null,null,4,5,6,7,8,9,null,null,11,12";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_5() {
        String given = "1";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_6() {
        String given = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";

        BinaryTreeNode node = BSTUtils.deserialize(given);
        String result = BSTUtils.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_7() {
        String given = "2,1,1";

        List<BinaryTreeNode> expected = List.of(
                new BinaryTreeNode(1)
        );
        BinaryTreeNode root = BSTUtils.deserialize(given);
        List<BinaryTreeNode> duplicates = BSTUtils.findDuplicateSubtrees(root);
        Assertions.assertEquals(expected, duplicates);
    }

    @Test
    public void test_8() {
        String given = "1,2,3,4,null,2,4,null,null,4";

        BinaryTreeNode node = BSTUtils.deserialize("2,4");
        List<BinaryTreeNode> expected = List.of(
                node,
                new BinaryTreeNode(4)
        );
        BinaryTreeNode root = BSTUtils.deserialize(given);
        List<BinaryTreeNode> duplicates = BSTUtils.findDuplicateSubtrees(root);
        Assertions.assertEquals(expected, duplicates);
    }
}

