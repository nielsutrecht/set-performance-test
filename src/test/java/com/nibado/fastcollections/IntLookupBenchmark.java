package com.nibado.fastcollections;

import com.nibado.fastcollections.lookup.IntLookup;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class IntLookupBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"10", "100", "1000"})
        public int size;

        //@Param({"javaStringHashSet", "javaHashSet", "arrayList", "array", "arrayBS"})
        @Param({"javaHashSet", "hppcHashSet", "hppcScatterSet"})
        public String implementation;

        private List<Integer> testList;

        public IntLookup intLookup;
        public List<Integer> needles = Arrays.stream(BenchmarkData.NEEDLES).mapToObj(i -> i).collect(Collectors.toList());
        public int needle = BenchmarkData.NEEDLES[0];

        @Setup(Level.Trial)
        public void setUp() {
            testList = BenchmarkData.randomIntList(size);
            intLookup = IntLookup.get(implementation, testList);
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void intLookup(Blackhole blackhole, BenchmarkState state) {
        for (int i = 0; i < 10; i++) {
            blackhole.consume(state.intLookup.contains(BenchmarkData.NEEDLES[i]));
        }
    }

    public static void main(final String[] args) throws RunnerException {
        var iterationTime = TimeValue.seconds(2);

        final Options opt = new OptionsBuilder()
                .include(".*" + IntLookupBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .mode(Mode.Throughput)
                .warmupIterations(2)
                .measurementIterations(2)
                .warmupTime(iterationTime)
                .measurementTime(iterationTime)
                .build();
        new Runner(opt).run();
    }
}