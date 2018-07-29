package com.cvictory.javatest;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Random;

/**
 * @author cvictory ON 2018/1/17
 */
public class MethodHandleTest {
    public static final Random JVM_RANDOM = new Random();

    static class ClassA {
        public void println(String s) {
            System.out.println("Hi, " + s + ", I'm ClassA");
        }
    }

    static class ClassB {
        public void println(String s) {
            System.out.println("Hi, " + s + ", I'm ClassB");
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = JVM_RANDOM.nextInt(100) % 2 == 0 ? new ClassA()
            : new ClassB();

        getPrintlnMH(obj).invokeExact("MethodHandle");

    }

    private static MethodHandle getPrintlnMH(Object obj) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);
        return MethodHandles.lookup().findVirtual(obj.getClass(), "println", mt).bindTo(obj);
    }
}
