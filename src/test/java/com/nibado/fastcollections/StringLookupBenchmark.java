package com.nibado.fastcollections;

import com.nibado.fastcollections.lookup.StringLookup;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class StringLookupBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"javaHashSet", "hppcHashSet", "hppcScatterSet"})
        public String implementation;

        public StringLookup stringLookup;

        public List<String> needles = BenchmarkData.STRING_ACTUAL.stream()
                .limit(10)
                .collect(Collectors.toList());


        @Setup(Level.Trial)
        public void setUp() {
            stringLookup = StringLookup.get(implementation, BenchmarkData.STRING_ACTUAL);
        }
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void stringLookup(Blackhole blackhole, BenchmarkState state) {
        for (int i = 0; i < 10; i++) {
            blackhole.consume(state.stringLookup.contains(state.needles.get(i)));
        }
    }

    public static void main(final String[] args) throws RunnerException {
        var iterationTime = TimeValue.seconds(5);

        final Options opt = new OptionsBuilder()
                .include(".*" + StringLookupBenchmark.class.getSimpleName() + ".*")
                .forks(1)
                .threads(8)
                .mode(Mode.Throughput)
                .warmupIterations(3)
                .measurementIterations(5)
                .warmupTime(iterationTime)
                .measurementTime(iterationTime)
                .build();
        new Runner(opt).run();
    }
}