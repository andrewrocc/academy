package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
@Fork(value = 1)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
public class BenchmarkCodeTest {

    @Param({ "100000" })                      //1_000_000 this value doesn't have sense to set cuz latency will be too long
    private int array_size;

    private ArrayList<Integer> array;

    private LinkedList<Integer> linked;

    private int[] randomValuesArray;

    private int[] randomIndexes = { 100, 999, 10000, 10, 54842, 10, 3490, 251, 76584, 11111 };

    private Random rand = new Random();

    @Setup
    public void prepare() {
        randomValuesArray = new int[array_size];
        array = new ArrayList<>();
        linked = new LinkedList<>();
        for (int i = 0; i < array_size; i++) {
            randomValuesArray[i] = rand.nextInt(Integer.MAX_VALUE >> 1);
            array.add(randomValuesArray[i]);
            linked.addLast(randomValuesArray[i]);
        }
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
//    @Measurement(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
//    @Warmup(iterations = 5, time = 500, timeUnit = TimeUnit.MILLISECONDS)
//    @Fork(value = 1)
//    @OutputTimeUnit(TimeUnit.NANOSECONDS)
//    @Timeout(time = 5, timeUnit = TimeUnit.SECONDS)
    public void addValuesArrayList(Blackhole blackhole) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < array_size; i++) {
            arrayList.add(randomValuesArray[i]);
        }
        blackhole.consume(arrayList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void getRandomValueArrayList(Blackhole blackhole) {
        for (int i = 0; i < randomIndexes.length; i++) {
            array.get(randomIndexes[i]);
        }
        blackhole.consume(array);
    }


    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void addValuesLinkedList(Blackhole blackhole) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < array_size; i++) {
            linkedList.addLast(randomValuesArray[i]);
        }
        blackhole.consume(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    public void getRandomValueLinkedList(Blackhole blackhole) {
        for (int i = 0; i < randomIndexes.length; i++) {
            linked.get(randomIndexes[i]);
        }
        blackhole.consume(linked);
    }
}
