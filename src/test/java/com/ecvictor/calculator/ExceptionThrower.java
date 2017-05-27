package com.ecvictor.calculator;

/**
 * Created by ccao on 2017-05-27.
 */
@FunctionalInterface
interface ExceptionThrower {
    void throwException() throws Throwable;
}

