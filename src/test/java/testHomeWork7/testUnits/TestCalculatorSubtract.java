package testHomeWork7.testUnits;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import by.academy.homework7.Calculator;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestCalculatorSubtract {

    //region default test
    @Test
    public void testSubSimple() {
        Assert.assertEquals(0.0, Calculator.subtract(2.0, 2.0), 0.1);
    }

    @Test
    public void testSubComposite() {
        Assert.assertEquals(-31.0, Calculator.subtract(34.5, 65.5), 0.1);
    }

    @Test
    public void testSubHard() {
        Assert.assertEquals(512.0, Calculator.subtract(1024.0, 512.0), 0.1);
    }
    //endregion

    //region Parametrized test
    private double X;

    private double Y;

    private double EXPECTED;

    public TestCalculatorSubtract(double x, double y, double EXPECTED) {
        X = x;
        Y = y;
        this.EXPECTED = EXPECTED;
    }

    @Parameterized.Parameters(name = "{index}: subtract -> {0} + {1} = {2}")
    public static Iterable<Double[]> getData() {
        return Arrays.asList(new Double[][]{ {2.0, 2.0, 0.0}, {34.5, 65.5, -31.0},
                {512.0, 512.5, -0.5}, {524288.0, -35.12, 524323.12},
                {22222.22, 6398.5, 15823.72}, {8521.99, 325.19, 8196.8}});
    }

    @Test
    public void parametrizedSubTest() {
        Assert.assertEquals(EXPECTED, Calculator.subtract(X, Y), 0.1);
    }
    //endregion
}
