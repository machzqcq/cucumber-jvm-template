package com.ecvictor.calculator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by caoc on 3/18/2017.
 */
public class CalculatorTest {
    @Test
    public void add() throws Exception {
        Assert.assertTrue(Calculator.add(1,2)==3);
    }

    @Test
    public void divide() throws Exception {
        Assert.assertTrue(Calculator.divide(1,2)==0);
        Assert.assertEquals("1/2 should be 0",
                0,Calculator.divide(1,2) );

    }

}