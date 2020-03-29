package com.nibado.fastcollections;

import com.nibado.fastcollections.lookup.IntLookup;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

public class IntLookupBenchmark {

    @State(Scope.Benchmark)
    public static class BenchmarkState {
        @Param({"1", "10", "100", "1000"})
        public int size;

        //@Param({"equals", "javaStringHashSet", "javaHashSet", "arrayList", "array", "arrayBS", "hppcHashSet", "hppcScatterSet"})
        //@Param({"javaHashSet", "hppcHashSet", "hppcScatterSet"})
        //@Param({"hppcHashSet", "hppcScatterSet", "troveHashSet", "fuHashSetDef", "fuHashSetVF", "fuHashSetF"})
        @Param({"javaHashSetDef", "javaHashSetVF", "hppcHashSetDef", "hppcHashSetVF", "fuHashSetDef", "fuHashSetVF"})
        public String implementation;

        public IntLookup intLookup;

        @Setup(Level.Trial)
        public void setUp() {
            var testList = BenchmarkData.randomIntList(size);
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
                .threads(8)
                .mode(Mode.Throughput)
                .warmupIterations(2)
                .measurementIterations(3)
                .warmupTime(iterationTime)
                .measurementTime(iterationTime)
                .build();
        new Runner(opt).run();
    }
}