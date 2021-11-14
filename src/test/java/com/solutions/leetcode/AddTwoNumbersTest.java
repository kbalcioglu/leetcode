package com.solutions.leetcode;

import com.solutions.leetcode.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddTwoNumbersTest {
    @Test
    public void test_1() {
        ListNode l1 = this.generateListNode(342);
        ListNode l2 = this.generateListNode(465);
        ListNode expected = this.generateListNode(807);
        ListNode result = this.addTwoNumbers(l1, l2);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_2() {
        ListNode l1 = this.generateListNode(9999999);
        ListNode l2 = this.generateListNode(9999);
        ListNode expected = this.generateListNode(10009998);
        ListNode result = this.addTwoNumbers(l1, l2);
        Assertions.assertEquals(expected, result);

    }

    @Test
    public void test_3() {
        ListNode l1 = this.generateListNode(753865680);
        ListNode l2 = this.generateListNode(798580876);
        ListNode expected = this.generateListNode(1552446556);
        ListNode result = this.addTwoNumbers(l1, l2);
        Assertions.assertEquals(expected, result);

    }

    private ListNode generateListNode2(int val) {
        if (val == 0)
            return new ListNode(0);
        int s = val % 10;
        val -= s;
        ListNode l = new ListNode(s);
        int index = 2;
        while (val > 0) {
            int k = (int) Math.pow(10, index);
            s = val % k;
            val -= s;
            s = s / (int) Math.pow(10, index - 1);
            l = new ListNode(s, l);
            index++;
        }
        return l;
    }

    private ListNode generateListNode(int val) {
        if (val == 0)
            return new ListNode(0);
        String valStr = Integer.toString(val);
        ListNode l = new ListNode(Character.getNumericValue(valStr.charAt(0)));
        for (int i = 1; i < valStr.length(); i++) {
            l = new ListNode(Character.getNumericValue(valStr.charAt(i)), l);
        }
        return l;
    }

    private ListNode generateListNodeStr(StringBuilder sb) {
        ListNode l = new ListNode(Character.getNumericValue(sb.charAt(0)));
        for (int i = 1; i < sb.length(); i++) {
            l = new ListNode(Character.getNumericValue(sb.charAt(i)), l);
        }
        return l;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1.getVal() == 0 && l1.getNext() == null) {
            return l2;
        } else if (l2.getVal() == 0 && l2.getNext() == null) {
            return l1;
        }
        StringBuilder sb = new StringBuilder();
        int residual = 0;
        while (l1 != null && l2 != null) {
            int val = l1.getVal() + l2.getVal() + residual;
            residual = 0;
            if (val >= 10) {
                residual = val / 10;
                val = val - 10;
            }
            sb.insert(0, val);
            l1 = l1.getNext();
            l2 = l2.getNext();
        }
        while (l1 != null) {
            int val = l1.getVal() + residual;
            residual = 0;
            if (val >= 10) {
                residual = val / 10;
                val = val - 10;
            }
            sb.insert(0, val);
            l1 = l1.getNext();
        }
        while (l2 != null) {
            int val = l2.getVal() + residual;
            residual = 0;
            if (val >= 10) {
                residual = val / 10;
                val = val - 10;
            }
            sb.insert(0, val);
            l2 = l2.getNext();
        }
        if (residual > 0) {
            sb.insert(0, residual);
        }
        return generateListNodeStr(sb);
    }

}