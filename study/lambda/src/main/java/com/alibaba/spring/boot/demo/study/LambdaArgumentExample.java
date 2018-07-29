package com.cvictory.javatest;

import java.util.function.Function;

/**
 * @author cvictory ON 2018/1/17
 */
public class LambdaArgumentExample {
    int i = 10;

    Function<String, Integer> f = s -> Integer.parseInt(s) + i;
}
