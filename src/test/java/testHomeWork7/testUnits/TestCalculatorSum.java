package testHomeWork7.testUnits;

import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import by.academy.homework7.Calculator;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(Parameterized.class)
public class TestCalculatorSum {

    //region default test
    @Test
    public void testSumSimple() {
        Assert.assertEquals(4.0, Calculator.sum(2.0, 2.0), 0.1);
    }

    @Test
    public void testSumComposite() {
        Assert.assertEquals(100.0, Calculator.sum(34.5, 65.5), 0.1);
    }

    @Test
    public void testSumHard() {
        Assert.assertEquals(1024.5, Calculator.sum(512.0, 512.5), 0.1);
    }
    //endregion

    //region Parametrized test
    private double X;

    private double Y;

    private double EXPECTED;

    public TestCalculatorSum(double x, double y, double EXPECTED) {
        X = x;
        Y = y;
        this.EXPECTED = EXPECTED;
    }

    @Parameterized.Parameters(name = "{index}: sum -> {0} + {1} = {2}")
    public static Iterable<Double[]> getData() {
        return Arrays.asList(new Double[][]{ {2.0, 2.0, 4.0}, {34.5, 65.5, 100.0},
                            {512.0, 512.5, 1024.5}, {524288.0, -35.12, 524252.88},
                            {22222.22, 6398.5, 28620.72}, {8521.99, 325.19, 8847.18}});
    }

    @Test
    public void parametrizedSumTest() {
        Assert.assertEquals(EXPECTED, Calculator.sum(X, Y), 0.1);
    }
    //endregion
}
