package com.ecvictor.calculator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static com.ecvictor.calculator.ThrowableAssertion.assertThrown;


/**
 * Created by caoc on 3/18/2017.
 */
public class CalculatorTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    private Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception {
        Assert.assertTrue(Calculator.add(1, 2) == 3);
    }

    @Test
    public void divide() throws Exception {
        Assert.assertTrue(calculator.divide(1, 2) == 0);
        Assert.assertEquals("1/2 should be 0",
                0, calculator.divide(1, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void divideByZero() throws Exception {
        calculator.divide(1, 0);
    }

    @Test
    public void divideByZero2() throws Exception {
        exception.expect(ArithmeticException.class);
        calculator.divide(1, 0);

    }


    @Test
    public void divideByZero3() throws Exception {
//            http://blog.codeleak.pl/2014/07/junit-testing-exception-with-java-8-and-lambda-expressions.html

//            assertThrown(new Calculator()::divide(1,0))
    }


}