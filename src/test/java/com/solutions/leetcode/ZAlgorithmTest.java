package com.solutions.leetcode;

import com.solutions.leetcode.utils.ZAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ZAlgorithmTest {
    @Test
    public void test_1() {
        String pattern = "aac";
        String text = "aacaaccaaceeeaac!";
        ZAlgorithm zAlgorithm = new ZAlgorithm(text, pattern);
        List<Integer> expected = List.of(0, 3, 7, 13);
        var result = zAlgorithm.search();

        Assertions.assertEquals(expected.size(),result.size());
        for(int i = 0; i<result.size();i++){
            Assertions.assertEquals(expected.get(i),result.get(i));
        }
    }
}
