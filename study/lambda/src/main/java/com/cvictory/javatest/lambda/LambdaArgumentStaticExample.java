package com.cvictory.javatest.lambda;

import java.util.function.Function;

/**
 * @author cvictory ON 2018/1/17
 */
public class LambdaArgumentStaticExample {
    static int i = 10;

    Function<String, Integer> f = s -> Integer.parseInt(s) + i;
}
