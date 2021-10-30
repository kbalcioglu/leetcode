package com.solutions.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.*;

public class LongestPalindromicSubstringTest {
    @Test
    public void test_s1() {
        String s = "babad";
        List<String> expected = List.of("bab", "aba");
        String result = this.longestPalindrome(s);
        this.assertion(expected, result);
    }

    @Test
    public void test_s2() {
        String s = "cbbd";
        List<String> expected = List.of("bb");
        String result = this.longestPalindrome(s);
        this.assertion(expected, result);
    }

    @Test
    public void test_s3() {
        String s = "a";
        List<String> expected = List.of("a");
        String result = this.longestPalindrome(s);
        this.assertion(expected, result);
    }

    @Test
    public void test_s4() {
        String s = "ac";
        List<String> expected = List.of("a", "c");
        String result = this.longestPalindrome(s);
        this.assertion(expected, result);
    }

    @Test
    public void test_s5() {
        String s = "twbiqwtafgjbtolwprpdnymaatlbuacrmzzwhkpvuwdtyfjsbsqxrlxxtqkjlpkvpxmlajdmnyepsmczmmfdtjfbyybotpoebilayqzvqztqgddpcgpelwmriwmoeeilpetbxoyktizwcqeeivzgxacuotnlzutdowiudwuqnghjgoeyojikjhlmcsrctvnahnoapmkcrqmwixpbtirkasbyajenknuccojooxfwdeflmxoueasvuovcayisflogtpxtbvcxfmydjupwihnxlpuxxcclbhvutvvshcaikuedhyuksbwwjsnssizoedjkbybwndxpkwcdxaexagazztuiuxphxcedqstahmevkwlayktrubjypzpaiwexkwbxcrqhkpqevhxbyipkmlqmmmogrnexsztsbkvebjgybrolttvnidnntpgvsawgaobycfaaviljsvyuaanguhohsepbthgjyqkicyaxkytshqmtxhilcjxdpcbmvnpippdrpggyohwyswuydyrhczlxyyzregpvxyfwpzvmjuukswcgpenygmnfwdlryobeginxwqjhxtmbpnccwdaylhvtkgjpeyydkxcqarkwvrmwbxeetmhyoudfuuwxcviabkqyhrvxbjmqcqgjjepmalyppymatylhdrazxytixtwwqqqlrcusxyxzymrnryyernrxbgrphsioxrxhmxwzsytmhnosnrpwtphaunprdtbpwapgjjqcnykgspjsxslxztfsuflijbeebwyyowjzpsbjcdabxmxhtweppffglvhfloprfavduzbgkw";
        List<String> expected = List.of("byyb");
        long start = System.currentTimeMillis();
        String result = this.longestPalindrome(s);
        long end = System.currentTimeMillis();
        System.out.println(end - start);
        System.out.println(result);

        long start2 = System.currentTimeMillis();
        String result2 = this.longestPalindrome2(s);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2);
        System.out.println(result2);
    }

    private void assertion(List<String> expected, String result) {
        Assertions.assertEquals(expected.get(0).length(), result.length());
        Assertions.assertEquals(true, expected.contains(result));
    }

    private boolean isPalindrome(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();
        String rev = sb.toString();
        return rev.equals(str);
    }

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0)
            return "";
        else if (s.length() == 1)
            return s;
        else if (isPalindrome(s)) {
            return s;
        } else if (s.length() == 2) {
            return s.substring(0, 1);
        }
        int n = s.length();
        int len = n;

        String result = s.substring(0, 1);

        for (int i = 0; i < n; i++) {
            Set<String> tested = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                String subStr = s.substring(j, j + len);
                if (!tested.contains(subStr)) {
                    tested.add(subStr);
                    if (this.isPalindrome(subStr)) {
                        return subStr;
                    }
                }

            }
            len--;
        }
        return result;
    }

    public String expand(String str, int low, int high) {
        int len = str.length();

        // expand in both directions
        while (low >= 0 && high < len &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }

        // return palindromic substring
        return str.substring(low + 1, high);
    }

    // Function to find the longest palindromic substring in `O(n²)` time
    // and `O(1)` space
    public String longestPalindrome2(String str) {
        int len = str.length();
        String max_str = "";
        String curr_str;
        int max_length = 0;
        int curr_length;

        // consider every character of the given string as a midpoint and expand
        // in both directions to find maximum length palindrome

        for (int i = 0; i < len; i++) {
            // find the longest odd length palindrome with `str[i]` as a midpoint

            curr_str = expand(str, i, i);
            curr_length = curr_str.length();


            // update maximum length palindromic substring if odd length
            // palindrome has a greater length

            if (curr_length > max_length) {
                max_length = curr_length;
                max_str = curr_str;
            }

            // Find the longest even length palindrome with str[i] and
            // str[i+1] as midpoints. Note that an even length palindrome
            // has two midpoints.

            curr_str = expand(str, i, i + 1);
            curr_length = curr_str.length();

            // update maximum length palindromic substring if even length
            // palindrome has a greater length

            if (curr_length > max_length) {
                max_length = curr_length;
                max_str = curr_str;
            }
        }

        return max_str;
    }

}
