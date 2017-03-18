package junit;

import org.junit.Assert;
import org.testng.annotations.Test;

/**
 * Created by caoc on 3/18/2017.
 */
public class CalculatorTest {
    @Test
    public void testAdd() throws Exception {
        Assert.assertTrue(Calculator.add(1,1)==2);
        Assert.assertTrue(Calculator.add(1,1)==3);
    }

}