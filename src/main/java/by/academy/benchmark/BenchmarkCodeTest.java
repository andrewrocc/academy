package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.*;

@State(Scope.Thread)
@Fork(value = 2)
public class BenchmarkCodeTest {

    @Param({ "100000" })                      //1_000_000 this value doesn't have sense to set cuz latency will be too long
    private int array_size;                   //, INITIAL_SIZE;   // the second value is needed to optimize arraylist performance

    private ArrayList<Integer> array;

    private LinkedList<Integer> linked;

    private int[] randomValuesArray;

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

//    @TearDown
//    public void tearDown() {
//        System.gc();
//    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
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
    @BenchmarkMode(Mode.Throughput)
    public void getRandomValueArrayList(Blackhole blackhole) {
        int endValue = array_size;
        while (endValue != 0) {
            array.get(rand.nextInt(array_size - 1));
            endValue--;
        }
        blackhole.consume(endValue);
    }


    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void addValuesLinkedList(Blackhole blackhole) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < array_size; i++) {
            linkedList.addLast(randomValuesArray[i]);
        }
        blackhole.consume(linkedList);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)
    public void getRandomValueLinkedList(Blackhole blackhole) {
        int endValue = array_size;
        while (endValue != 0) {
            linked.get(rand.nextInt(array_size - 1));
            endValue--;
        }
        blackhole.consume(endValue);
    }
}
