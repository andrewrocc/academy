package testHomeWork7.testUnits;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import by.academy.homework7.Calculator;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestCalculatorMultiply {

    //region default test
    @Test
    public void testMulSimple() {
        Assert.assertEquals(0.0, Calculator.multiply(0.0, 2.0), 0.1);
    }

    @Test
    public void testMulComposite() {
        Assert.assertEquals(2259.75, Calculator.multiply(34.5, 65.5), 0.1);
    }

    @Test
    public void testMulHard() {
        Assert.assertEquals(524288, Calculator.multiply(1024.0, 512.0), 0.1);
    }
    //endregion

    //region Parametrized test
    private double X;

    private double Y;

    private double EXPECTED;

    public TestCalculatorMultiply(double x, double y, double EXPECTED) {
        X = x;
        Y = y;
        this.EXPECTED = EXPECTED;
    }

    @Parameterized.Parameters(name = "{index}: multiply -> {0} + {1} = {2}")
    public static Iterable<Double[]> getData() {
        return Arrays.asList(new Double[][]{ {2.0, 2.0, 4.0}, {34.5, 65.5, 2259.75},
                {512.0, 512.5, 262400.0}, {52.0, -35.12, -1826.23},
                {22222.22, 0.6398, 14217.776356}, {8521.99, 325.19, 2771265.9281}});
    }

    @Test
    public void parametrizedSubTest() {
        Assert.assertEquals(EXPECTED, Calculator.multiply(X, Y), 0.1);
    }
    //endregion
}
