package com.alibaba.spring.boot.testjava;

/**
 * @author cvictory ON 2017/10/27
 */
public class A {
    public void foo(String name) {
        System.out.println("Hello, " + name);
    }

    public static Bb testBb(){
        return new Bb();
    }

    public Cc testCc(){
        return new Cc();
    }

    public Cc testDd(){
        return new Dd();
    }

}
