package com.solutions.leetcode;

import com.solutions.leetcode.models.*;
import com.solutions.leetcode.utils.BINNodeUtils;
import org.junit.jupiter.api.Test;

public class BINNodeUtilsTest {
    @Test
    public void test_1() {
        BINNode tree = BINNode.initialTree();
        String bin = "1243";
        BINNodeUtils.extendTree(tree, bin);
        bin = "1234567890123";
        BINNodeUtils.extendTree(tree, bin);
        bin = "4325235235235";
        BINNodeUtils.extendTree(tree, bin);
        bin = "438298382929";
        BINNodeUtils.extendTree(tree, bin);
        bin = "438398382929";
        BINNodeUtils.extendTree(tree, bin);
        bin = "438498382929";
        BINNodeUtils.extendTree(tree, bin);
        bin = "438432482929";
        BINNodeUtils.extendTree(tree, bin);
        System.out.println(tree);
    }
}
