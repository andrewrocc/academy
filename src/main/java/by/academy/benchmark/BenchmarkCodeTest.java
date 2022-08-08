package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkCodeTest {

    @Param({"10"})       //1_000_000 this value doesn't have sense to set cuz latency will be too long
    private int array_size;

    private List<Integer> array;

    private LinkedList<Integer> linked;

    private int[] randomValuesArray;

    private Random rand = new Random();

    @Setup
    public void prepare() {
        randomValuesArray = new int[array_size];
        linked = new LinkedList<>();
        array = new ArrayList<>();
        for (int i = 0; i < array_size; i++) {
            randomValuesArray[i] = rand.nextInt(Integer.MAX_VALUE >> 1);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public ArrayList<Integer> setValuesArrayListAndGetRandomValue() {
        ArrayList<Integer> listResult = new ArrayList<>();
        for (int i = 0; i < array_size; i++) {
            listResult.add(i);
        }
        return listResult;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void getRandomValue(Blackhole blackhole) {
        int endValue = array_size;
        while (endValue != 0) {
            array.get(rand.nextInt(array_size - 1));
            endValue--;
        }
        blackhole.consume(endValue);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 3, time = 1, timeUnit = TimeUnit.MILLISECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 1)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void setValuesLinkedListAndGetRandomValue(Blackhole blackhole) {
        for (int i = 0; i < array_size; i++) {
            linked.addLast(randomValuesArray[i]);
        }
        int endValue = array_size;
        while (endValue != 0) {
            linked.get(rand.nextInt(array_size));
            endValue--;
        }
        blackhole.consume(endValue);
    }
}
