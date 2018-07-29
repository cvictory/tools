package com.cvictory.javatest.spring.boot.testjava;

/**
 * @author cvictory ON 2017/10/30
 * 查看字节码测试
 */
public class TestBytecode implements Super{

    private static final int staticVar = 2;

    private int instanceVar=3;

    private String t = "q测试工程ww0";

    public int instanceMethod(int param){
        return param+1;
    }

}

interface Super{ }

