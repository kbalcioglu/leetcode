package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

// https://leetcode.com/problems/substring-with-concatenation-of-all-words/
public class SubstringConcatenationAllWordsTest {
    @Test
    public void test_1() {
        String s = "barfoothefoobarman";
        String[] words = {"foo", "bar"};
        List<Integer> expected = List.of(0, 9);
        List<Integer> result = this.findSubstring(s, words);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertEquals(true, expected.contains(i));
        }
    }

    @Test
    public void test_2() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "word"};
        List<Integer> expected = List.of();
        List<Integer> result = this.findSubstring(s, words);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertEquals(true, expected.contains(i));
        }
    }

    @Test
    public void test_3() {
        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo", "the"};
        List<Integer> expected = List.of(6, 9, 12);
        List<Integer> result = this.findSubstring(s, words);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertEquals(true, expected.contains(i));
        }
    }
    @Test
    public void test_4() {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word","good","best","good"};
        List<Integer> expected = List.of(8);
        List<Integer> result = this.findSubstring(s, words);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i : result) {
            Assertions.assertEquals(true, expected.contains(i));
        }
    }
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        Map<String, MapVal> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String w = words[i];
            map.putIfAbsent(w, new MapVal());
            map.get(w).incrementVal();
        }
        int wordLength = words[0].length();
        int totalWordLength = wordLength * words.length;
        boolean indexOk = true;
        Set<String> visited = new HashSet<>();
        for (String word : map.keySet()) {
            int index = s.indexOf(word);
            while (index >= 0 && index + totalWordLength <= s.length()) {
                indexOk = true;
                visited = new HashSet<>();
                String str = s.substring(index, index + totalWordLength);
                for (int j = 0; j < str.length(); j += wordLength) {
                    int end = j + wordLength;
                    String search = str.substring(j, end);
                    if (!visited.contains(search)) {
                        visited.add(search);
                        if (map.containsKey(search)) {
                            map.get(search).resetVal();
                        }
                    }
                    if (!map.containsKey(search)) {
                        indexOk = false;
                        break;
                    } else if (map.get(search).getVal() == 0) {
                        indexOk = false;
                        break;
                    } else {
                        map.get(search).decrementVal();
                    }
                }
                if (indexOk)
                    result.add(index);

                index = s.indexOf(word, index + 1);
            }
        }
        return result;
    }
}

class MapVal {
    AtomicInteger val;
    int immutableValue;

    MapVal() {
        this.immutableValue = 0;
        this.val = new AtomicInteger(0);
    }

    MapVal incrementVal() {
        this.immutableValue++;
        this.val.incrementAndGet();
        return this;
    }

    MapVal decrementVal() {
        this.val.decrementAndGet();
        return this;
    }

    int getVal() {
        return this.val.intValue();
    }

    MapVal resetVal() {
        this.val = new AtomicInteger(this.immutableValue);
        return this;
    }
}
