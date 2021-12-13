package com.solutions.leetcode;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

//https://leetcode.com/problems/word-break/
public class WordBreakTest {

    @Test
    public void test_1() {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_2() {
        String s = "applepenapple";
        List<String> wordDict = List.of("apple", "pen");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    @Test
    public void test_3() {
        String s = "catsandog";
        List<String> wordDict = List.of("cats", "sand", "and", "cat", "dog");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertFalse(result);
    }

    @Test
    public void test_4() {
        String s = "aaaaaaa";
        List<String> wordDict = List.of("aaaa", "aaa");
        boolean result = wordBreak(s, wordDict);
        Assertions.assertTrue(result);
    }

    // valid -> faster then %5
    public boolean wordBreak2(String s, List<String> wordDict) {
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(s);
        Set<String> offered = new HashSet<>();
        offered.add(s);
        boolean result = false;
        while (!queue.isEmpty()) {
            String check = queue.poll();
            int n = check.length();
            for (String word : wordDict) {
                if (word.length() > check.length())
                    continue;
                String start = check.substring(0, word.length());
                String end = check.substring(n - word.length(), n);
                if (start.equals(word)) {
                    String next = check.substring(word.length());
                    if(next.equals("")){
                        result = true;
                        break;
                    }
                    if (!offered.contains(next)) {
                        queue.offer(next);
                        offered.add(next);
                    }
                }
                if (end.equals(word)) {
                    String next = check.substring(0, n - word.length());
                    if(next.equals("")){
                        result = true;
                        break;
                    }
                    if (!offered.contains(next)) {
                        queue.offer(next);
                        offered.add(next);
                    }
                }
            }
        }
        return result;
    }

    // valid -> faster then %99
    public boolean wordBreak(String s, List<String> wordDict) {

        TrieNode root = new TrieNode();
        for(var word : wordDict){
            root = insert(root, word,0);
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;

        for( int i = 0 ; i < dp.length; i++){
            if(dp[i]!=1) continue;
            TrieNode temp = root;
            int j = i;

            while( j < s.length() && temp.next[s.charAt(j)- 'a' ] !=null ){
                temp = temp.next[s.charAt(j)- 'a' ] ;
                j++;
                if(temp.isWord){
                    dp[j] = 1;
                    if(j== s.length()) return true;
                }
            }
        }
        return false;
    }
    TrieNode insert(TrieNode node, String word, int d){
        if(node == null) node = new TrieNode();
        if( d == word.length()){
            node.isWord = true;
            return node;
        }
        char ch = word.charAt(d);
        node.next[ch -'a'] = insert(node.next[ch - 'a'], word, d+1);
        return node;
    }
    static class TrieNode{
        boolean isWord;
        TrieNode[] next = new TrieNode[26];
    }
}
