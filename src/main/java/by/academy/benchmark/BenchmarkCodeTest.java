package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkCodeTest {

    private int[] patternsDateFormat;
    @Setup
    public void prepare() {
        patternsDateFormat = new int[1000];
        for (int i = 0; i < patternsDateFormat.length; i++) {
            patternsDateFormat[i] = i + 1;
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String byteShift() {
        int result_mul = 1;
        for (int i = 0; i < patternsDateFormat.length; i++) {
            result_mul *= patternsDateFormat[i];
        }

        return String.valueOf(result_mul);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String booleanState() {
        int result_mul = 1;
        for (var e : patternsDateFormat) {
            result_mul *= e;
        }

        return String.valueOf(result_mul);
    }
}
