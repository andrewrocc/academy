package by.academy.benchmark;

import by.academy.homework3.services.DynamicIntArray;
import org.openjdk.jmh.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkCodeTest {

    @Param({ "10", "1000", "10000", "100000", "1000000" })
    private int array_size;

    private DynamicIntArray dynamic_array;

    private Integer[] array;

    @Setup
    public void prepare() {
        Random r = new Random();
        array = new Integer[array_size];
        dynamic_array = new DynamicIntArray(array_size);
        for (int i = 0; i < array.length; i++) {
            int random_value = r.nextInt(Integer.MAX_VALUE);
            array[i] = random_value;
            dynamic_array.add(random_value);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String linkedListSort() {
        LinkedList<Integer> linkedList = new LinkedList<Integer>(Arrays.asList(array));
        Collections.sort(linkedList);

        return String.valueOf(linkedList.indexOf(9));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String arrayListSort() {
        ArrayList<Integer> naiveArrayList = new ArrayList<Integer>(Arrays.asList(array));
        Collections.sort(naiveArrayList);

        return String.valueOf(naiveArrayList.indexOf(9));
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String rawArray() {
        Arrays.sort(array);

        return String.valueOf(array[9]);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 1, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String dynamicIntArray() {

        return String.valueOf(array[9]);
    }
}
