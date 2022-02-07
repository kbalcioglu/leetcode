package com.solutions.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class CourseScheduleTest {
    @Test
    public void test_1() {
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        boolean expected = true;
        boolean result = canFinish(numCourses,prerequisites);
        Assertions.assertEquals(expected, result);
    }
    private Set<Integer> visited;
    Map<Integer,List<Integer>> preMap;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        preMap = new HashMap<>();
        for(int i = 0; i < numCourses; i++){
            preMap.put(i,new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++){
            List<Integer> list = preMap.get(prerequisites[i][0]);
            list.add(prerequisites[i][1]);
        }

        visited = new HashSet<>();
        for(int i = 0; i < numCourses; i++){
            if(!dfs(i))
                return false;
        }
        return true;
    }

    private boolean dfs(int course){
        if(visited.contains(course))
            return false;
        if(preMap.get(course).size() == 0)
            return true;

        visited.add(course);
        for(int c : preMap.get(course)){
            if(!dfs(c)){
                return false;
            }
        }
        visited.remove(course);
        preMap.put(course,new ArrayList<>());
        return true;
    }
}
