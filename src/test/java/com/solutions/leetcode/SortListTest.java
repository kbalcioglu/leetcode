package com.solutions.leetcode;

import com.solutions.leetcode.models.ListNode;
import com.solutions.leetcode.utils.ListNodeUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SortListTest {

    @Test
    public void test_1() {
        int[] arr = {4, 3, 2, 1};
        ListNode head = ListNodeUtils.generateListNode(arr);
        int[] expectedArr = {1, 2, 3, 4};
        ListNode expectedHead = ListNodeUtils.generateListNode(expectedArr);

        head = ListNodeUtils.mergeSort(head);

        String result = ListNodeUtils.outputListNode(head);
        String expected = ListNodeUtils.outputListNode(expectedHead);

        Assertions.assertEquals(expected, result);
    }
}
