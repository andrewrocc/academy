package by.academy.benchmark;

import org.openjdk.jmh.annotations.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@State(Scope.Thread)
public class BenchmarkCodeTest {

    @Param({"12.12.2000", "1234567890"})
    private String user_date;

    @Param({"false"})
    private boolean isException;

    @Param({"8"})
    private byte isException_b;

    private String[] patternsDateFormat;

    private SimpleDateFormat simpleDateFormat;

    @Setup
    public void prepare() {
        patternsDateFormat = new String[] {"dd/MM/yyyy", "dd-MM-yyyy", "dd.MM.yyyy"};
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String byteShift() {
        if (user_date.length() != 10) {
            System.out.println("Incorrect date");
            return "Incorrect date";
        }

        for (int i = 0; i < patternsDateFormat.length; i++) {
            simpleDateFormat = new SimpleDateFormat(patternsDateFormat[i]);
            try {
                Date date = simpleDateFormat.parse(user_date);
                break;
            } catch (ParseException ex) {
                isException_b <<= 1;
            }
        }

        return ((isException_b ^ 0b1000) == 0) ? "Incorrect date" : null;
    }

    @Benchmark
    @BenchmarkMode(Mode.AverageTime)
    @Measurement(iterations = 5, timeUnit = TimeUnit.SECONDS)
    @Warmup(iterations = 3, time = 5, timeUnit = TimeUnit.SECONDS)
    @Fork(value = 2)
    @OutputTimeUnit(TimeUnit.NANOSECONDS)
    @Timeout(time = 10, timeUnit = TimeUnit.MILLISECONDS)
    public String booleanState() {
        if (user_date.length() != 10) {
            System.out.println("Incorrect date");
            return "Incorrect date";
        }

        for (var e : patternsDateFormat) {
            simpleDateFormat = new SimpleDateFormat(e);
            try {
                Date date = simpleDateFormat.parse(user_date);
                isException = false;
                break;
            } catch (ParseException ex) {
                isException = true;
            }
        }

        return (isException) ? "Incorrect date" : null;
    }
}
