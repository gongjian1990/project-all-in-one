package com.gj.test.guava;

import com.google.common.collect.HashBiMap;

/**
 * @ClassName: GuavaBitMapTest
 * @Description:
 * @Author: 赵云
 * @Date: 2020/5/23 10:47
 * @Version: V1.0
 **/

public class GuavaBitMapTest {
    final static HashBiMap<Object, Object> biMap = HashBiMap.create();

    static {
        for (long i = 0; i < 10000000; i++) {
            biMap.put(new Long(i),"Mech"+i);
        }
    }

    public static void test001(){


        System.out.println("[get start] .......");

        long start = System.currentTimeMillis();

        System.out.println("key: "+ biMap.inverse().get("Mech123246"));

        System.out.println("[get end] ......., cost: "+(System.currentTimeMillis()-start));

    }

    public static void main(String[] args) {
        test001();
    }
}
