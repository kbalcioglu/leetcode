package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.SuffixTreeNode;

import java.util.*;
import java.util.stream.Collectors;

public class SuffixTree {
    private static final String STARTING_CHAR = "*";
    private static final String WORD_TERMINATION = "$";
    private static final int POSITION_UNDEFINED = -1;
    private SuffixTreeNode root;
    private final String word;
    private final Map<String, Integer> suffixes;

    public SuffixTree(String word) {
        this.word = word;
        this.root = new SuffixTreeNode(STARTING_CHAR, POSITION_UNDEFINED);
        this.suffixes = getSuffixes(word);
        for (String suffix : suffixes.keySet()) {
            addSuffix(suffix, suffixes.get(suffix));
        }
    }
    private Map<String, Integer> getSuffixes(String text) {
        Map<String, Integer> suffixList = new LinkedHashMap<>();
        for (int i = text.length() - 1; i >= 0; i--) {
            suffixList.put(text.substring(i), i);
        }
        return suffixList;
    }
    public List<String> searchText(String pattern) {
        List<String> result = new ArrayList<>();
        List<SuffixTreeNode> nodes = getAllNodesInTraversePath(pattern, root, false);

        if (nodes.size() > 0) {
            SuffixTreeNode lastNode = nodes.get(nodes.size() - 1);
            if (lastNode != null) {
                List<Integer> positions = getPositions(lastNode);
                positions = positions.stream()
                        .sorted()
                        .collect(Collectors.toList());
                positions.forEach(m -> result.add((markPatternInText(m, pattern))));
            }
        }
        return result;
    }
    private List<Integer> getPositions(SuffixTreeNode node) {
        List<Integer> positions = new ArrayList<>();
        if (node.getText().endsWith(WORD_TERMINATION)) {
            positions.add(node.getPosition());
        }
        for (int i = 0; i < node.getChildren().size(); i++) {
            positions.addAll(getPositions(node.getChildren().get(i)));
        }
        return positions;
    }
    private String markPatternInText(Integer startPosition, String pattern) {
        String matchingTextLHS = word.substring(0, startPosition);
        String matchingText = word.substring(startPosition, startPosition + pattern.length());
        String matchingTextRHS = word.substring(startPosition + pattern.length());
        return matchingTextLHS + "[" + matchingText + "]" + matchingTextRHS;
    }

    private void addSuffix(String suffix, int position) {
        List<SuffixTreeNode> nodes = getAllNodesInTraversePath(suffix, root, true);
        if (nodes.size() == 0) {
            addChildNode(root, suffix, position);
        } else {
            SuffixTreeNode lastNode = nodes.remove(nodes.size() - 1);
            String newText = suffix;
            if (nodes.size() > 0) {
                String existingSuffixUptoLastNode = nodes.stream()
                        .map(a -> a.getText())
                        .reduce("", String::concat);
                newText = newText.substring(existingSuffixUptoLastNode.length());
            }
            extendNode(lastNode, newText, position);
        }
    }

    private void addChildNode(SuffixTreeNode parentNode, String text, int index) {
        parentNode.getChildren().add(new SuffixTreeNode(text, index));
    }

    private void extendNode(SuffixTreeNode node, String newText, int position) {
        String currentText = node.getText();
        String commonPrefix = getLongestCommonPrefix(currentText, newText);

        if (commonPrefix != currentText) {
            String parentText = currentText.substring(0, commonPrefix.length());
            String childText = currentText.substring(commonPrefix.length());
            splitNodeToParentAndChild(node, parentText, childText);
        }

        String remainingText = newText.substring(commonPrefix.length());
        addChildNode(node, remainingText, position);
    }
    private String getLongestCommonPrefix(String str1, String str2) {
        int compareLength = Math.min(str1.length(), str2.length());
        for (int i = 0; i < compareLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                return str1.substring(0, i);
            }
        }
        return str1.substring(0, compareLength);
    }

    private void splitNodeToParentAndChild(SuffixTreeNode parentNode, String parentNewText, String childNewText) {
        SuffixTreeNode childNode = new SuffixTreeNode(childNewText, parentNode.getPosition());

        if (parentNode.getChildren().size() > 0) {
            while (parentNode.getChildren().size() > 0) {
                childNode.getChildren()
                        .add(parentNode.getChildren().remove(0));
            }
        }

        parentNode.getChildren().add(childNode);
        parentNode.setText(parentNewText);
        parentNode.setPosition(POSITION_UNDEFINED);
    }

    private List<SuffixTreeNode> getAllNodesInTraversePath(String pattern, SuffixTreeNode startNode, boolean isAllowPartialMatch) {
        List<SuffixTreeNode> nodes = new ArrayList<>();
        for (int i = 0; i < startNode.getChildren().size(); i++) {
            SuffixTreeNode currentNode = startNode.getChildren().get(i);
            String nodeText = currentNode.getText();
            if (pattern.charAt(0) == nodeText.charAt(0)) {
                if (isAllowPartialMatch && pattern.length() <= nodeText.length()) {
                    nodes.add(currentNode);
                    return nodes;
                }

                int compareLength = Math.min(nodeText.length(), pattern.length());
                for (int j = 1; j < compareLength; j++) {
                    if (pattern.charAt(j) != nodeText.charAt(j)) {
                        if (isAllowPartialMatch) {
                            nodes.add(currentNode);
                        }
                        return nodes;
                    }
                }

                nodes.add(currentNode);
                if (pattern.length() > compareLength) {
                    List<SuffixTreeNode> nodes2 = getAllNodesInTraversePath(pattern.substring(compareLength),
                            currentNode, isAllowPartialMatch);
                    if (nodes2.size() > 0) {
                        nodes.addAll(nodes2);
                    } else if (!isAllowPartialMatch) {
                        nodes.add(null);
                    }
                }
                return nodes;
            }
        }
        return nodes;
    }

}
