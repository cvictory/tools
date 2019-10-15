package com.cvictory.javatest.lambda;

import java.util.function.Function;

/**
 * @author cvictory ON 2018/1/17
 */
public class LambdaCacheValidExample {

    private int sss = 34;

    public static void main(String[] args) {
        test("23");
        test("34");
        new LambdaCacheValidExample().testInstance("45");
        new LambdaCacheValidExample().testInstance("56");
        new LambdaCacheValidExample().testInstanceArgu("45");
        new LambdaCacheValidExample().testInstanceArgu("56");
    }

    private static void test(String r) {
        Function<String, Integer> newS = s2 -> Integer.parseInt(s2);
        System.out.println(newS.toString() + "__" + newS.apply(r));
    }

    void testInstance(String r) {
        Function<String, Integer> newS = s2 -> Integer.parseInt(s2);
        System.out.println(newS.toString() + "__" + newS.apply(r));
    }

    void testInstanceArgu(String r) {
        Function<String, Integer> newS = s2 -> Integer.parseInt(s2) + sss;
        System.out.println(newS.toString() + "__" + newS.apply(r));
    }
}
