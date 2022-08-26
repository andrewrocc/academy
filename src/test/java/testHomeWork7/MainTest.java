package testHomeWork7;

import org.junit.runner.JUnitCore;
import testHomeWork7.testUnits.TestCalculatorSuitTest;

public class MainTest {
    public static void main(String[] args) {
        JUnitCore core = new JUnitCore();
        core.addListener(new CalculatorTestListener());
        core.run(TestCalculatorSuitTest.class);
    }
}
