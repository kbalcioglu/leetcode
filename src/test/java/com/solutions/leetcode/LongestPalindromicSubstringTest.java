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
    }

    @Test
    public void test_s6() {
        String s = "aab";
        List<String> expected = List.of("a", "a", "b");
        List<String> result = this.palindromeList(s);
        for (String p : result) {
            System.out.println(p);
        }
    }

    private void assertion(List<String> expected, String result) {
        Assertions.assertEquals(expected.get(0).length(), result.length());
        Assertions.assertEquals(true, expected.contains(result));
    }

    public String expand(String str, int low, int high) {
        int len = str.length();

        // expand in both directions
        while (low >= 0 && high < len &&
                (str.charAt(low) == str.charAt(high))) {
            low--;
            high++;
        }
        return str.substring(low + 1, high);
    }

    // Function to find the longest palindromic substring in `O(n²)` time
    // and `O(1)` space
    public String longestPalindrome(String str) {
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

    public List<String> palindromeList(String str) {
        List<String> result = new ArrayList<>();
        int len = str.length();
        String curr_str;

        for (int i = 0; i < len; i++) {
            curr_str = expand(str, i, i);
            if (curr_str.length() > 0)
                result.add(curr_str);
            curr_str = expand(str, i, i + 1);
            if (curr_str.length() > 0)
                result.add(curr_str);
        }

        return result;
    }

}
