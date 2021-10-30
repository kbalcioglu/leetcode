package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.sql.ClientInfoStatus;
import java.util.*;
import java.util.stream.Collectors;

// TODO : yapamadım !!
// https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
public class SerializeDeserializeBinaryTreeTest {
    @Test
    public void test_1() {
        String given = "1,2,3,4,5,6,7,8";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize(given);
        String result = codec.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_2() {
        String given = "1,2,3,null,null,4,5";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize(given);
        String result = codec.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_3() {
        String given = "1,2,3,4,5,6,7,8,9,10,11,12,13,14,15";
        Codec codec = new Codec();
        //TreeNode node = codec.deserialize(given);
        //String result = codec.serialize(node);
        TreeNode node = codec.deserializeBST(given);
        String result = codec.serializeBST(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_4() {
        String given = "1,2,3,null,null,4,5,6,7,8,9,null,null,11,12";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize(given);
        String result = codec.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_5() {
        String given = "1";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize(given);
        String result = codec.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_6() {
        String given = "4,-7,-3,null,null,-9,-3,9,-7,-4,null,6,null,-6,-6,null,null,0,6,5,null,9,null,null,-1,-4,null,null,null,-2";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize(given);
        String result = codec.serialize(node);
        Assertions.assertEquals(given, result);
    }

    @Test
    public void test_7() {
        String given = "2,1,1";
        Codec codec = new Codec();
        List<TreeNode> expected = List.of(
                new TreeNode(1)
        );
        TreeNode root = codec.deserialize(given);
        List<TreeNode> duplicates = codec.findDuplicateSubtrees(root);
        Assertions.assertEquals(expected, duplicates);
    }

    @Test
    public void test_8() {
        String given = "1,2,3,4,null,2,4,null,null,4";
        Codec codec = new Codec();
        TreeNode node = codec.deserialize("2,4");
        List<TreeNode> expected = List.of(
                node,
                new TreeNode(4)
        );
        TreeNode root = codec.deserialize(given);
        List<TreeNode> duplicates = codec.findDuplicateSubtrees(root);
        Assertions.assertEquals(expected, duplicates);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int value) {
        this.val = value;
        this.right = null;
        this.left = null;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.val;
        if (this.left != null)
            hash = 67 * hash + this.left.hashCode();
        else
            hash = 67 * hash;
        if (this.right != null)
            hash = 67 * hash + this.right.hashCode();
        else
            hash = 67 * hash;
        return hash;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (!(o instanceof TreeNode))
            return false;
        TreeNode t = (TreeNode) o;
        return this.hashCode() == t.hashCode();
    }
}

class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null)
            return "";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> currentlevel = new LinkedList<>();
        Queue<TreeNode> nextlevel = new LinkedList<>();
        currentlevel.add(root);
        while (!currentlevel.isEmpty()) {
            TreeNode temp = currentlevel.poll();
            if (temp.val == -999999999) {
                list.add("null");
            } else {
                list.add(String.valueOf(temp.val));
                if (temp.left != null)
                    nextlevel.add(temp.left);
                else
                    nextlevel.add(new TreeNode(-999999999));
                if (temp.right != null)
                    nextlevel.add(temp.right);
                else
                    nextlevel.add(new TreeNode(-999999999));
            }
            if (currentlevel.isEmpty()) {
                Queue<TreeNode> t = currentlevel;
                currentlevel = nextlevel;
                nextlevel = t;
            }
        }
        while (true) {
            if (list.get(list.size() - 1).equals("null"))
                list.remove(list.size() - 1);
            else
                break;
        }
        return String.join(",", list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s == null || s.length() == 0)
            return null;
        List<String> list = new ArrayList<>();
        String[] arr = s.split(",");
        for (String x : arr) {
            list.add(x);
        }
        int k = 0;
        int m = 0;
        while (true) {
            m += (int) Math.pow(2, k);
            if (m >= list.size())
                break;
            k++;
        }
        for (int i = list.size(); i < m; i++) {
            list.add("null");
        }
        int index = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode node = new TreeNode(Integer.parseInt(list.get(0)));
        q.offer(node);
        while (!q.isEmpty() && index < m) {
            TreeNode current = q.poll();
            if (!list.get(index).equals("null")) {
                current.left = new TreeNode(Integer.parseInt(list.get(index)));
                q.offer(current.left);
            }
            index++;
            if (!list.get(index).equals("null")) {
                current.right = new TreeNode(Integer.parseInt(list.get(index)));
                q.offer(current.right);
            }
            index++;
        }

        return node;
    }

    public String serializeBST(TreeNode root) {
        if (root == null)
            return "";
        List<String> list = new ArrayList<>();
        Queue<TreeNode> currentlevel = new LinkedList<>();
        Queue<TreeNode> nextlevel = new LinkedList<>();
        currentlevel.add(root);
        while (!currentlevel.isEmpty()) {
            TreeNode temp = currentlevel.poll();
            list.add(String.valueOf(temp.val));
            if (temp.left != null)
                nextlevel.add(temp.left);
            if (temp.right != null)
                nextlevel.add(temp.right);
            if (currentlevel.isEmpty()) {
                Queue<TreeNode> t = currentlevel;
                currentlevel = nextlevel;
                nextlevel = t;
            }
        }
        return String.join(",", list);
    }

    public TreeNode deserializeBST(String data) {
        if (data == null || data.length() == 0)
            return null;
        String[] arr = data.split(",");
        TreeNode root = null;
        for (int i = 0; i < arr.length; i++) {
            int val = Integer.parseInt(arr[i]);
            root = insert(root, val);
        }
        return root;
    }

    public TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else {
            TreeNode cur;
            if (val <= root.val) {
                cur = insert(root.left, val);
                root.left = cur;
            } else {
                cur = insert(root.right, val);
                root.right = cur;
            }
            return root;
        }
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Set<TreeNode> result = new HashSet<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        Set<TreeNode> exists = new HashSet<>();
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            if (exists.contains(current)) {
                result.add(current);
            } else {
                exists.add(current);
            }
            if (current.left != null)
                queue.offer(current.left);
            if (current.right != null)
                queue.offer(current.right);

        }

        return result.stream().collect(Collectors.toList());
    }

}
