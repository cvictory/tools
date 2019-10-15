package com.cvictory.javatest.lambda;

/**
 * @author cvictory ON 2018/1/15
 */
public class NumberUtilTest {

    public static int sum(int x, int y) {
        int z = 0;
        for (int i = 0; i < 10; i++) {
            z += (i + 1) * x + y;
        }
        return z;
    }
}
