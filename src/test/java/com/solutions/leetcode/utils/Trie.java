package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.TrieConstants;
import com.solutions.leetcode.models.TrieNode;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Trie {
    private TrieNode root;
    private final boolean isUpperCase;
    private int lcpIndex;

    public Trie() {
        this.isUpperCase = false;
        this.root = new TrieNode(TrieConstants.START_CHAR);
    }

    public Trie(boolean isUpperCase) {
        this.isUpperCase = isUpperCase;
        this.root = new TrieNode(TrieConstants.START_CHAR);
    }

    public Trie(String[] stringArray, boolean isUpperCase) {
        this.isUpperCase = isUpperCase;
        this.root = new TrieNode(TrieConstants.START_CHAR);
        for (String value : stringArray) {
            this.insert(value);
        }
    }

    public Trie(String[] stringArray) {
        this.isUpperCase = false;
        this.root = new TrieNode(TrieConstants.START_CHAR);
        for (String value : stringArray) {
            this.insert(value);
        }
    }

    public Trie(Collection<String> stringList) {
        this.isUpperCase = false;
        this.root = new TrieNode(TrieConstants.START_CHAR);
        for (String value : stringList) {
            this.insert(value);
        }
    }

    public Trie(Collection<String> stringList, boolean isUpperCase) {
        this.isUpperCase = isUpperCase;
        this.root = new TrieNode(TrieConstants.START_CHAR);
        for (String value : stringList) {
            this.insert(value);
        }
    }

    private char getInitialChar() {
        if (isUpperCase)
            return TrieConstants.UPPER_CASE_LETTER_INITIAL;
        return TrieConstants.LOWER_CASE_LETTER_INITIAL;
    }

    public TrieNode getTrie() {
        return this.root;
    }

    /**
     * inserts new key to the trie
     */
    public void insert(String key) {
        if (StringUtils.isBlank(key))
            return;
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = key.charAt(i) - this.getInitialChar();
            if (current.getChild(index) == null) {
                current.setChild(new TrieNode(c), index);
            }
            current = current.getChild(index);
        }
        current.setLeaf();

    }

    /**
     * Checks if given key exists in trie
     */
    public boolean search(String key) {
        if (StringUtils.isBlank(key))
            return false;
        TrieNode current = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            int index = key.charAt(i) - this.getInitialChar();
            if (current.getChild(index) == null) {
                return false;
            }
            current = current.getChild(index);
        }
        if (current.isLeaf())
            return true;
        return false;
    }

    /**
     * Returns longest common prefix of the trie
     */
    public String longestCommonPrefix() {
        if (root == null)
            return null;
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;
        while (numberOfChildren(current) == 1 && !current.isLeaf()) {
            current = current.getChild(lcpIndex);
            sb.append(current.getCharacter());
        }

        return sb.toString();
    }

    private int numberOfChildren(TrieNode node) {
        int numberOfChildren = 0;
        for (int i = 0; i < TrieConstants.ALPHABET_SIZE; i++) {
            if (node.getChild(i) != null) {
                numberOfChildren++;
                lcpIndex = i;
            }
            if (numberOfChildren > 1)
                break;
        }
        return numberOfChildren;
    }

    /**
     * Returns longest common prefix with the given compare value in the trie
     */
    public String longestCommonPrefix(String compareValue) {
        if (root == null)
            return null;
        if (StringUtils.isBlank(compareValue))
            return null;
        StringBuilder sb = new StringBuilder();
        TrieNode current = root;
        for (int i = 0; i < compareValue.length(); i++) {
            char c = compareValue.charAt(i);
            int index = compareValue.charAt(i) - this.getInitialChar();
            if (current.getChild(index) == null) {
                break;
            }
            sb.append(c);
            current = current.getChild(index);
        }
        return sb.toString();
    }

    /**
     * Returns sorted keys in the trie
     */
    public List<String> sort() {
        return this.startsWithPrefix("");
    }

    /**
     * Returns all the keys starting with given prefix
     */
    public List<String> startsWithPrefix(String prefix) {
        List<String> returnList = new ArrayList<>();
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - this.getInitialChar();
            if (current.getChild(index) == null) {
                return returnList;
            }
            current = current.getChild(index);
        }
        StringBuilder sb = new StringBuilder(prefix);
        collect(current, sb, returnList);
        return returnList;
    }

    // DFS
    private void collect(TrieNode node, StringBuilder prefix, List<String> returnList) {
        if (node == null)
            return;
        if (node.isLeaf()) {
            returnList.add(prefix.toString());
            return;
        }
        for (TrieNode child : node.getChildren()) {
            if (child == null)
                continue;
            StringBuilder sb = new StringBuilder(prefix);
            collect(child, sb.append(child.getCharacter()), returnList);
        }
    }
}
