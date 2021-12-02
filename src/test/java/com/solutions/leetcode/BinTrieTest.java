package com.solutions.leetcode;

import com.solutions.leetcode.models.BinGap;
import com.solutions.leetcode.utils.BinTrie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class BinTrieTest {
    @Test
    public void test_split_1() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("400", "499");
        List<BinGap> expected = List.of(
                new BinGap("400", "499"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_2() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("424", "443");
        List<BinGap> expected = List.of(
                new BinGap("424", "424"),
                new BinGap("425", "425"),
                new BinGap("426", "426"),
                new BinGap("427", "427"),
                new BinGap("428", "428"),
                new BinGap("429", "429"),
                new BinGap("430", "439"),
                new BinGap("440", "440"),
                new BinGap("441", "441"),
                new BinGap("442", "442"),
                new BinGap("443", "443"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_3() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("420", "734");
        List<BinGap> expected = List.of(
                new BinGap("420", "429"),
                new BinGap("430", "439"),
                new BinGap("440", "449"),
                new BinGap("450", "459"),
                new BinGap("460", "469"),
                new BinGap("470", "479"),
                new BinGap("480", "489"),
                new BinGap("490", "499"),
                new BinGap("500", "599"),
                new BinGap("600", "699"),
                new BinGap("700", "709"),
                new BinGap("710", "719"),
                new BinGap("720", "729"),
                new BinGap("730", "730"),
                new BinGap("731", "731"),
                new BinGap("732", "732"),
                new BinGap("733", "733"),
                new BinGap("734", "734"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_4() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("409", "499");
        List<BinGap> expected = List.of(
                new BinGap("409", "409"),
                new BinGap("410", "419"),
                new BinGap("420", "429"),
                new BinGap("430", "439"),
                new BinGap("440", "449"),
                new BinGap("450", "459"),
                new BinGap("460", "469"),
                new BinGap("470", "479"),
                new BinGap("480", "489"),
                new BinGap("490", "499"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_5() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("409", "499");
        List<BinGap> expected = List.of(
                new BinGap("409", "409"),
                new BinGap("410", "419"),
                new BinGap("420", "429"),
                new BinGap("430", "439"),
                new BinGap("440", "449"),
                new BinGap("450", "459"),
                new BinGap("460", "469"),
                new BinGap("470", "479"),
                new BinGap("480", "489"),
                new BinGap("490", "499"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_6() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("1420", "1734");
        List<BinGap> expected = List.of(
                new BinGap("1420", "1429"),
                new BinGap("1430", "1439"),
                new BinGap("1440", "1449"),
                new BinGap("1450", "1459"),
                new BinGap("1460", "1469"),
                new BinGap("1470", "1479"),
                new BinGap("1480", "1489"),
                new BinGap("1490", "1499"),
                new BinGap("1500", "1599"),
                new BinGap("1600", "1699"),
                new BinGap("1700", "1709"),
                new BinGap("1710", "1719"),
                new BinGap("1720", "1729"),
                new BinGap("1730", "1730"),
                new BinGap("1731", "1731"),
                new BinGap("1732", "1732"),
                new BinGap("1733", "1733"),
                new BinGap("1734", "1734"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_7() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("700", "734");
        List<BinGap> expected = List.of(
                new BinGap("700", "709"),
                new BinGap("710", "719"),
                new BinGap("720", "729"),
                new BinGap("730", "730"),
                new BinGap("731", "731"),
                new BinGap("732", "732"),
                new BinGap("733", "733"),
                new BinGap("734", "734"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_split_8() {
        BinTrie trie = new BinTrie();
        BinGap given = new BinGap("730", "734");
        List<BinGap> expected = List.of(
                new BinGap("730", "730"),
                new BinGap("731", "731"),
                new BinGap("732", "732"),
                new BinGap("733", "733"),
                new BinGap("734", "734"));
        List<BinGap> result = trie.splitToGaps(given);

        Assertions.assertNotNull(result);
        trie.printGaps(result);
        Assertions.assertEquals(expected.size(), result.size());
        for (int i = 0; i < expected.size(); i++) {
            Assertions.assertEquals(expected.get(i), result.get(i));
        }
    }

    @Test
    public void test_insert_1() {
        BinTrie trie = new BinTrie();
        String cardType = "deneme";
        trie.insert("400", "499", cardType);

        var node = trie.getTrie();
        Assertions.assertNotNull(node);
        Assertions.assertNotNull(node.getChild(4));
        node = node.getChild(4);
        Assertions.assertEquals(cardType, node.getCardType());
        Assertions.assertTrue(node.isAllFromHere());
    }

    @Test
    public void test_insert_2() {
        BinTrie trie = new BinTrie();
        String cardType = "deneme";
        trie.insert("424", "443", cardType);

        var node = trie.getTrie();
        Assertions.assertNotNull(node);
        Assertions.assertNotNull(node.getChild(4));
        node = node.getChild(4);
        Assertions.assertNotNull(node.getChild(2));
        Assertions.assertNotNull(node.getChild(3));
        Assertions.assertNotNull(node.getChild(4));
        var node3 = node.getChild(3);
        Assertions.assertEquals(cardType, node3.getCardType());
        Assertions.assertTrue(node3.isAllFromHere());
        var node2 = node.getChild(2);
        for (int i = 4; i <= 9; i++) {
            Assertions.assertNotNull(node2.getChild(i));
            Assertions.assertEquals(cardType, node2.getChild(i).getCardType());
            Assertions.assertTrue(node2.getChild(i).isAllFromHere());
        }
        var node4 = node.getChild(4);
        for (int i = 0; i <= 3; i++) {
            Assertions.assertNotNull(node4.getChild(i));
            Assertions.assertEquals(cardType, node4.getChild(i).getCardType());
            Assertions.assertTrue(node4.getChild(i).isAllFromHere());
        }
    }

    @Test
    public void test_insert_3() {
        BinTrie trie = new BinTrie();
        String cardType = "deneme";
        BinGap given = new BinGap("420", "734");
        List<BinGap> result = trie.splitToGaps(given);
        trie.printGaps(result);
        trie = new BinTrie();
        trie.insert("420", "734", cardType);
        var node = trie.getTrie();
        Assertions.assertNotNull(node);
        for (int k = 5; k <= 7; k++) {
            Assertions.assertNotNull(node.getChild(k));
            var childNode = node.getChild(k);
            if (k == 4) {
                for (int i = 2; i <= 9; i++) {
                    Assertions.assertNotNull(childNode.getChild(i));
                    var childNode2 = childNode.getChild(i);
                    Assertions.assertEquals(cardType, childNode2.getCardType());
                    Assertions.assertTrue(childNode2.isAllFromHere());
                }
            } else if (k == 7) {
                for (int i = 0; i <= 3; i++) {
                    if (i == 3) {
                        Assertions.assertNotNull(childNode.getChild(i));
                        var childNode2 = childNode.getChild(i);
                        for (int j = 0; j <= 4; j++) {
                            Assertions.assertNotNull(childNode.getChild(i));
                            var childNode3 = childNode2.getChild(j);
                            Assertions.assertEquals(cardType, childNode3.getCardType());
                            Assertions.assertTrue(childNode3.isAllFromHere());
                        }
                    } else {
                        Assertions.assertNotNull(childNode.getChild(i));
                        var childNode2 = childNode.getChild(i);
                        Assertions.assertEquals(cardType, childNode2.getCardType());
                        Assertions.assertTrue(childNode2.isAllFromHere());
                    }
                }
            } else {
                Assertions.assertEquals(cardType, childNode.getCardType());
                Assertions.assertTrue(childNode.isAllFromHere());
            }
        }
    }

    @Test
    public void test_search_1() {
        BinTrie trie = new BinTrie();
        String cardType = "deneme";
        trie.insert("420", "734", cardType);
        var node = trie.getTrie();
        List<String> givenExistsList = List.of("42800435300000", "6544564456", "59999999999", "42000000000001", "734000000001", "734999999999999");
        List<String> givenNotExistsList = List.of("735000000000", "41999999999999");
        for (String given : givenExistsList) {
            String result = trie.search(given);
            System.out.println("given : " + given + " - result : " + result);
            Assertions.assertEquals(cardType, result);
        }
        for (String given : givenNotExistsList) {
            String result = trie.search(given);
            System.out.println("given : " + given + " - result : " + result);
            Assertions.assertEquals(null, result);
        }


    }

    @Test
    public void test_search_2() {
        BinTrie trie = new BinTrie();
        String cardType = "deneme";
        trie.insert("4019", "4900", cardType);

        var node = trie.getTrie();
        Assertions.assertNotNull(node);
        String result = trie.search("40110435300000");
        Assertions.assertNull(result);
    }
}
