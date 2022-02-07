package com.solutions.leetcode;

import com.solutions.leetcode.utils.LRUCache;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LeastRecentlyUsedCacheTest {

    @Test
    public void test_1(){
        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        int val = cache.get(1);
        Assertions.assertEquals(1,val);
        cache.put(3,3);
        val = cache.get(2);
        Assertions.assertEquals(-1,val);
        cache.put(4,4);
        val = cache.get(1);
        Assertions.assertEquals(-1,val);
        val = cache.get(3);
        Assertions.assertEquals(3,val);
        val = cache.get(4);
        Assertions.assertEquals(4,val);
    }

}
