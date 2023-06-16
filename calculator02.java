import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class calculator02 {
    private static final String Calculator = null;
    private Calculator calculator;

    @Before
    public void setUp() {
        this.calculator = new Calculator();
    }

    @Test
    public void testADD() {
        float a = 5;
        float b = 3;
        float expectedResult = 8;
        float actualResult = Calculator.add(a, b);
        assertEquals(expectedResult, actualResult, 0);
    }

    private void assertEquals(float expectedResult, float actualResult, int i) {
    }

    @Test
    public void testSUBTRACT(String string) {
        float a = 5;
        float b = 3;
        float expectedResult = 2;
        float actualResult = Calculator.subtract(a, b);
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test
    public void testMULTIPLY() {
        float a = 5;
        float b = 3;
        float expectedResult = 15;
        float actualResult = Calculator.multiply(a, b);
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test(expected = null)
    public void testDIVIDE() {
        float a = 10;
        float b = 2;
        float expectedResult = 5;
        float actualResult = Calculator.divide(a, b);
        assertEquals(expectedResult, actualResult, 0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDivideByZero() {
        float a = 10;
        float b = 0;
        Calculator.divide(a, b);
    }
}
