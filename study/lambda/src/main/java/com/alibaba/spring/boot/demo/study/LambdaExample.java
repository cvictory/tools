package com.alibaba.spring.boot.demo.study;

import java.util.function.Function;

/**
 * @author cvictory ON 2018/1/17
 */
public class LambdaExample {
    int i = 10;
    static int j = 20;

    Function<String, Integer> s = s1 -> Integer.parseInt(s1) + i;

    static Function<String, Integer> t = s -> Integer.parseInt(s) + j;

    Function<String, Integer> f = s -> Integer.parseInt(s);

    static Function<String, Long> l = s -> Long.parseLong(s);

    public static void main(String[] args) {
        System.out.println(new LambdaExample().f.apply("234"));
        System.out.println(l.apply("245"));

        Function<String, Integer> newS = s2 -> Integer.parseInt(s2);
        System.out.println(newS.apply("560"));
    }
}
