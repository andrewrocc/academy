package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkCodeTest {

    @Param({"20"})
    private int N;
    private int[][] array;

    @Setup
    public void prepare() {
        array = new int[N][N];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = counter++;
            }
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 2, timeUnit = TimeUnit.NANOSECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 1, timeUnit = TimeUnit.NANOSECONDS)
    public int testMethod() {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Warmup(iterations = 5)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 1, timeUnit = TimeUnit.NANOSECONDS)
    public int testMethod2() {
        int sum = 0;
        for (int j = 0; j < array.length; j++) {
            for (int i = 0; i < array[j].length; i++) {
                sum += array[i][j];
            }
        }
        return sum;
    }
}
