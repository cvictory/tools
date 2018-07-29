package com.cvictory.javatest;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        long t1 = System.currentTimeMillis();
        for(int i =0 ; i< 100000 ; i++){
            System.out.println(NumberUtilTest.sum(2,4));
        }
        long t2 = System.currentTimeMillis();
        for(int i =0 ; i< 100000 ; i++){
            System.out.println();
        }
    }


}
