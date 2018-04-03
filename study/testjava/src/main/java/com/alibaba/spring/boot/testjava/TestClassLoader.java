package com.alibaba.spring.boot.testjava;

import java.lang.reflect.Method;

//import com.sun.tools.javac.util.Assert;

/**
 * 结论：
 * 1.所有的类都会加载
 * 2.查看反射
 *
 * @author cvictory ON 2017/10/27
 */
public class TestClassLoader {
    public static void main(String[] args) throws Exception {
        Class<?> clz = Class.forName("com.alibaba.spring.boot.testjava.A");
        Object o = clz.newInstance();
        Method m = clz.getMethod("foo", String.class);
        long start = System.nanoTime();
        for (int i = 0; i < 18; i++) {
            m.invoke(o, Integer.toString(i));
            System.out.println(i + "--------" + (System.nanoTime() - start));
        }
        System.out.println("*************************1************************");
        Object o2 = clz.newInstance();
        Method m2 = clz.getMethod("foo", String.class);
        long start3 = System.nanoTime();
        for (int i = 0; i < 18; i++) {
            m2.invoke(o2, Integer.toString(i));
            System.out.println(i + "--------" + (System.nanoTime() - start3));
        }
        System.out.println("*************************2************************");
        Class<?> clz2 = Class.forName("com.alibaba.spring.boot.testjava.A");
        //Assert.check(clz == clz2);
        Object o3 = clz2.newInstance();
        Method m3 = clz2.getMethod("foo", String.class);
        System.out.println("clz1:" + clz + " ; clz2:" + clz2 + "; equal:" + (clz == clz2));
        /**
         * class对象是同一个，为什么下面的method对象不是同一个呢。
         */
        System.out.println("clz1:" + Integer.toHexString(System.identityHashCode(clz)) + " ; clz2:" + Integer
            .toHexString(System.identityHashCode(clz2)) + "; equal:" + (clz == clz2));
        System.out.println("m1:" + m + " ; m2:" + m2 + " ; m3:" + m3 + "; equal:" + (m == m3));
        System.out.println("m1:" + Integer.toHexString(System.identityHashCode(m)) + " ; m2:" + Integer
            .toHexString(System.identityHashCode(m2)) + " ; m3:" + Integer.toHexString(System.identityHashCode(m3))
            + "; equal:" + (m == m3));
        long start4 = System.nanoTime();
        for (int i = 0; i < 18; i++) {
            m3.invoke(o3, Integer.toString(i));
            System.out.println(i + "--------" + (System.nanoTime() - start4));
        }
        System.out.println("*************************3************************");
        Method m5 = clz.getMethod("testDd");
        long start2 = System.nanoTime();
        for (int i = 0; i < 18; i++) {
            m5.invoke(o);
            System.out.println(i + "--------" + (System.nanoTime() - start2));
        }
    }
}
