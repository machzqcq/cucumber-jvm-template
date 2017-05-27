package com.ecvictor.calculator;

/**
 * Created by ccao on 2017-05-27.
 */
public class ThrowableCaptor {
    public static Throwable captureThrowable(ExceptionThrower exceptionThrower) {
        try {
            exceptionThrower.throwException();
            return null;
        } catch (Throwable caught) {
            return caught;
        }
    }
}