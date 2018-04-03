package com.alibaba.spring.boot.demo.study;

import java.util.function.Function;

/**
 * @author cvictory ON 2018/1/17
 */
public class AnonymousClassExample {
    Function<String, String> format = new Function<String, String>() {
        @Override
        public String apply(String input){
            return Character.toUpperCase(input.charAt(0)) + input.substring(1);
        }
    };
}
