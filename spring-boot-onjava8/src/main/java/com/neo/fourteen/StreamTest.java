package com.neo.fourteen;

import java.util.Random;

/**
 * create by xiaocai on 2021/5/10 15:22
 **/
public class StreamTest {
    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
//        randomTest();
    }

    private static void randomTest() {
        new Random(47)
                .ints(10,99)
                .distinct()
                .limit(10)
                .sorted()
                .forEach(System.out::println);
    }
}
