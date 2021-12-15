package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Objects;
import java.util.Set;

//https://leetcode.com/problems/jump-game-ii/
public class JumpGame2Test {

    @Test
    public void test_1() {
        int[] nums = {2, 3, 1, 1, 4};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        int[] nums = {2, 3, 0, 1, 4};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_3() {
        int[] nums = {2, 3, 4, 2, 1, 1, 0};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_4() {
        int[] nums = {2, 5, 3, 2, 1, 1, 0};
        int expected = 2;
        int result = jump(nums);
        Assertions.assertEquals(expected, result);
    }

    public int jump(int[] nums) {
        return iterative(nums);
    }

    private int iterative2(int[] nums) {
        int maxReach = 0;
        int currentReach = 0;
        int jumps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach == nums.length - 1) {
                jumps++;
                break;
            }
            if (i == currentReach) {
                jumps++;
                currentReach = maxReach;
            }
            if (currentReach == nums.length)
                break;
        }
        return jumps;
    }

    private int iterative(int[] nums) {
        int count = 0;
        int i = 0;
        int j = 0;
        while (j < nums.length - 1) {
            int t = j;
            while (i <= j) {
                int v = i + nums[i];
                if (v > t)
                    t = v;
                i++;
            }
            j = t;
            count++;
        }
        return count;
    }

    private int bfs(int[] nums) {
        LinkedList<Element> queue = new LinkedList<>();
        queue.offer(new Element(0, nums[0]));
        int lastIndex = nums.length - 1;
        Set<Element> offered = new HashSet<>();
        while (!queue.isEmpty()) {
            Element element = queue.poll();
            if (element.index == lastIndex)
                return element.moveCount;
            int maxJump = element.value;
            for (int i = 1; i <= maxJump; i++) {
                Element newElement = element.move(new Element(element.index + i, nums[element.index + i]));
                if (newElement.index == lastIndex)
                    return newElement.moveCount;
                if (offered.contains(newElement))
                    continue;
                offered.add(newElement);
                queue.offer(newElement);
            }
        }
        return -1;
    }

    static class Element {
        int index;
        int value;
        int moveCount;

        public Element(int index, int value) {
            this.index = index;
            this.value = value;
            this.moveCount = 0;
        }

        private Element(int index, int value, int moveCount) {
            this.index = index;
            this.value = value;
            this.moveCount = moveCount;
        }

        public Element move(Element e) {
            return new Element(e.index, e.value, this.moveCount + 1);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Element e = (Element) o;
            return index == e.index && value == e.value && moveCount == e.moveCount;
        }

        @Override
        public int hashCode() {
            return Objects.hash(index, value, moveCount);
        }
    }
}
