package com.neo.source.cache;

import com.neo.source.cache.impl.PerpetualCacheFCache;

import java.util.HashMap;
import java.util.Map;

/**
 * create by xiaocai on 2020/10/22 11:24
 **/
public class FCacheTest {
    public static void main(String[] args) {
        Map<PerpetualCacheFCache,String> map2 = new HashMap<>();
        PerpetualCacheFCache fCache1 = new PerpetualCacheFCache("11");
        PerpetualCacheFCache fCache2 = new PerpetualCacheFCache("11");
        System.out.println(map2.get(fCache2));
    }
}
