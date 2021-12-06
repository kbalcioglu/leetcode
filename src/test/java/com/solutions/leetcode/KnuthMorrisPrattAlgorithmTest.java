package com.solutions.leetcode;

import com.solutions.leetcode.utils.KnuthMorrisPrattAlgorithm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class KnuthMorrisPrattAlgorithmTest {
    @Test
    public void test_1() {
        String pattern = "aafad";
        String text = "uoıuquwyeıuaafadjqweqrtraafadertetete";
        KnuthMorrisPrattAlgorithm kmp = new KnuthMorrisPrattAlgorithm(pattern, text);
        List<Integer> expected = List.of(11, 24);
        var result = kmp.search();

        Assertions.assertEquals(expected.size(),result.size());
        for(int i = 0; i<result.size();i++){
            Assertions.assertEquals(expected.get(i),result.get(i));
        }
    }
}
