package com.solutions.leetcode;

import com.solutions.leetcode.utils.Trie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Set;

public class TrieTest {
    @Test
    public void test_insert_1() {
        Trie trie = new Trie(false);
        trie.insert("apple");
        trie.insert("approve");
        trie.insert("bee");
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        Assertions.assertFalse(trie.search("be"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertFalse(trie.search("try00"));
    }

    @Test
    public void test_insert_2() {
        var given = Set.of("apple", "approve", "bee");
        Trie trie = new Trie(given);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        Assertions.assertFalse(trie.search("be"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertFalse(trie.search("try00"));
    }

    @Test
    public void test_insert_3() {
        String[] given = {"apple", "approve", "bee"};
        Trie trie = new Trie(given);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        Assertions.assertFalse(trie.search("be"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertFalse(trie.search("try00"));
    }

    @Test
    public void test_insert_4() {
        String[] given = {"apple", "approve", "bee"};
        Trie trie = new Trie(given);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        Assertions.assertFalse(trie.search("be"));
        Assertions.assertFalse(trie.search("app"));
        Assertions.assertFalse(trie.search("try00"));
        Assertions.assertFalse(trie.search("APPLE"));
        Assertions.assertFalse(trie.search("APPROVE"));
        Assertions.assertFalse(trie.search("BEE"));
    }

    @Test
    public void test_insert_5() {
        String[] given = {"APPLE", "APPROVE", "BEE"};
        Trie trie = new Trie(given, true);
        Assertions.assertTrue(trie.search("APPLE"));
        Assertions.assertTrue(trie.search("APPROVE"));
        Assertions.assertTrue(trie.search("BEE"));
        Assertions.assertFalse(trie.search("BE"));
        Assertions.assertFalse(trie.search("APP"));
        Assertions.assertFalse(trie.search("TRY"));
        Assertions.assertFalse(trie.search("apple"));
        Assertions.assertFalse(trie.search("approve"));
        Assertions.assertFalse(trie.search("bee"));
    }

    @Test
    public void test_longest_common_prefix_1() {
        String[] array = {"apple", "approve", "bee"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        String given = "appeal";
        String expected = "app";
        String result = trie.longestCommonPrefix(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_longest_common_prefix_2() {
        String[] array = {"apple", "approve", "bee"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("bee"));
        String given = "be";
        String expected = "be";
        String result = trie.longestCommonPrefix(given);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_longest_common_prefix_3() {
        String[] array = {"apple", "approve", "appeal"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("appeal"));
        String expected = "app";
        String result = trie.longestCommonPrefix();
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_longest_common_prefix_4() {
        String[] array = {"apple", "approve", "appeal", "bee"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("apple"));
        Assertions.assertTrue(trie.search("approve"));
        Assertions.assertTrue(trie.search("appeal"));
        Assertions.assertTrue(trie.search("bee"));
        String expected = "";
        String result = trie.longestCommonPrefix();
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_autocomplete_1() {
        String[] array = {"april", "adam", "daniel", "tony", "michael", "chris", "madonna"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("april"));
        Assertions.assertTrue(trie.search("adam"));
        Assertions.assertTrue(trie.search("daniel"));
        Assertions.assertTrue(trie.search("tony"));
        Assertions.assertTrue(trie.search("michael"));
        Assertions.assertTrue(trie.search("chris"));
        Assertions.assertTrue(trie.search("madonna"));

        List<String> expected = List.of("adam","april");
        List<String> result = trie.startsWithPrefix("a");
        Assertions.assertEquals(expected, result);
    }
    @Test
    public void test_autocomplete_2() {
        String[] array = {"april", "adam", "daniel", "tony", "michael", "chris", "madonna"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("april"));
        Assertions.assertTrue(trie.search("adam"));
        Assertions.assertTrue(trie.search("daniel"));
        Assertions.assertTrue(trie.search("tony"));
        Assertions.assertTrue(trie.search("michael"));
        Assertions.assertTrue(trie.search("chris"));
        Assertions.assertTrue(trie.search("madonna"));

        List<String> expected = List.of();
        List<String> result = trie.startsWithPrefix("k");
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void test_sort_1() {
        String[] array = {"april", "adam", "daniel", "tony", "michael", "chris", "madonna"};
        Trie trie = new Trie(array);
        Assertions.assertTrue(trie.search("april"));
        Assertions.assertTrue(trie.search("adam"));
        Assertions.assertTrue(trie.search("daniel"));
        Assertions.assertTrue(trie.search("tony"));
        Assertions.assertTrue(trie.search("michael"));
        Assertions.assertTrue(trie.search("chris"));
        Assertions.assertTrue(trie.search("madonna"));

        List<String> expected = List.of("adam","april","chris","daniel","madonna","michael","tony");
        List<String> result = trie.sort();
        Assertions.assertEquals(expected, result);
    }
}
