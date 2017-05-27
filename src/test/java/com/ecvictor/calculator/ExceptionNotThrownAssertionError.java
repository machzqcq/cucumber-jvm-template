package com.ecvictor.calculator;

/**
 * Created by ccao on 2017-05-27.
 */
public class ExceptionNotThrownAssertionError extends AssertionError {
    public ExceptionNotThrownAssertionError() {
        super("Expected exception was not thrown.");
    }

}
