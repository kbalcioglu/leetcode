package com.solutions.leetcode.utils;

import com.solutions.leetcode.models.BINNode;
import com.solutions.leetcode.models.BinConstants;
import com.solutions.leetcode.models.BinGap;

import java.util.ArrayList;
import java.util.List;

public class BinTrie {
    private final BINNode root;

    public BinTrie() {
        this.root = new BINNode(BinConstants.START_CHAR);
    }

    public void insert(String start, String end, String cardType) {
        BinGap initialGap = new BinGap(start, end);
        List<BinGap> gaps = this.splitToGaps(initialGap);

        for (BinGap gap : gaps) {
            this.insert(gap, cardType);
        }

    }

    private void insert(BinGap gap, String cardType) {
        BINNode current = root;
        for (int i = 0; i < gap.getSize(); i++) {
            int startIndex = gap.getStartIndexValue(i);
            int endIndex = gap.getEndIndexValue(i);

            if (startIndex == endIndex) {
                if (current.getChild(startIndex) == null) {
                    current.setChild(new BINNode(startIndex), startIndex);
                }
                current = current.getChild(startIndex);
                if(i == gap.getSize()-1){
                    current.setAllFromHere();
                    current.setCardType(cardType);
                }
            } else if (startIndex == 0 && endIndex == 9) {
                current.setCardType(cardType);
                current.setAllFromHere();
                break;
            } else if (startIndex < endIndex) {
                for (int k = startIndex; k <= endIndex; k++) {
                    this.add(current, k, cardType);
                }
            }
        }
    }

    private void add(BINNode node, int index, String cardType) {
        if (node.getChild(index) == null) {
            node.setChild(new BINNode(index), index);
        }
        node = node.getChild(index);
        node.setCardType(cardType);
        node.setAllFromHere();
    }

    public String search(String binNumber) {
        BINNode searchNode = root;
        for (int i = 0; i < binNumber.length(); i++) {
            var index = binNumber.charAt(i) - '0';
            if (searchNode.getChild(index) != null) {
                searchNode = searchNode.getChild(index);
                continue;
            }else if(searchNode.isAllFromHere()){
                return searchNode.getCardType();
            }else{
                break;
            }
        }
        return null;
    }


    public List<BinGap> splitToGaps(BinGap initialGap) {
        List<BinGap> gaps = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        if(initialGap.getStart().equals(initialGap.getEnd())){
            gaps.add(initialGap);
            return gaps;
        }
        int i;
        for (i = 0; i < initialGap.getSize(); i++) {
            if (initialGap.getStartIndexValue(i) == initialGap.getEndIndexValue(i)) {
                sb.append(initialGap.getStartIndexValue(i));
                continue;
            }
            break;
        }
        int count = initialGap.getSize() - sb.length();
        String s;
        String e;
        if (initialGap.getStartIndexValue(i) == 0 && initialGap.getEndIndexValue(i) == 9) {
            s = sb.toString() + this.padRight("", count, '0');
            e = sb.toString() + this.padRight("", count, '9');
            if (s.equals(initialGap.getStart()) && e.equals(initialGap.getEnd())){
                gaps.add(new BinGap(s, e));
                return gaps;
            }
        }
        for (int k = initialGap.getStartIndexValue(i); k <= initialGap.getEndIndexValue(i); k++) {
            if (k == initialGap.getStartIndexValue(i)) {
                s = initialGap.getStart().substring(sb.length());
                e = this.padRight(k, count, '9');
                var firstGaps = splitToGaps( new BinGap(sb.toString() + s, sb.toString() + e));
                gaps.addAll(firstGaps);
            } else if (k == initialGap.getEndIndexValue(i)) {
                s = this.padRight(k, count, '0');
                e = initialGap.getEnd().substring(sb.length());
                var lastGaps = splitToGaps( new BinGap(sb.toString() + s, sb.toString() + e));
                gaps.addAll(lastGaps);
            } else {
                s = this.padRight(k, count, '0');
                e = this.padRight(k, count, '9');
                gaps.add(new BinGap(sb.toString() + s, sb.toString() + e));
            }
        }
        return gaps;
    }

    public void printGaps(List<BinGap> gaps) {
        System.out.println();
        System.out.println("*********** GAPS ***********");
        System.out.println();
        for (BinGap gap : gaps) {
            System.out.println(gap.toString());
        }
        System.out.println();
        System.out.println("********* GAPS END *********");
        System.out.println();
    }

    public BINNode getTrie() {
        return root;
    }

    private String padRight(String s, int count, char padChar) {
        return String.format("%-" + count + "s", s).replace(' ', padChar);
    }

    private String padRight(int i, int count, char padChar) {
        return String.format("%-" + count + "s", i).replace(' ', padChar);
    }
}
