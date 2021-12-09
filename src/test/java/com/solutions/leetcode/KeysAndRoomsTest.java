package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

//https://leetcode.com/problems/keys-and-rooms/
public class KeysAndRoomsTest {
    // n rooms labeled 0 to n-1
    // all rooms locked. except 0
    // visit all rooms. can not enter locked room if you dont have key
    // when you visit a room you can find distinct keys in it. each key has no which room to unlock. can take all to unlock rooms
    // given an array rooms where rooms[i] is the keys you obtaion when you visit room i


    @Test
    public void test_1() {
        List<List<Integer>> rooms = List.of(
                List.of(1),
                List.of(2),
                List.of(3),
                List.of(3)
        );
        boolean expected = true;
        boolean result = canVisitAllRooms(rooms);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_2() {
        List<List<Integer>> rooms = List.of(
                List.of(1, 3),
                List.of(3, 0, 1),
                List.of(2),
                List.of(0)
        );
        boolean expected = false;
        boolean result = canVisitAllRooms(rooms);
        Assertions.assertEquals(expected, result);
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms == null || rooms.size() == 0)
            return true;
        Set<Integer> visited = new HashSet<>();
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int index = queue.poll();
            if(visited.contains(index))
                continue;
            visited.add(index);
            queue.addAll(rooms.get(index));
        }
        return visited.size() == rooms.size();
    }
}
