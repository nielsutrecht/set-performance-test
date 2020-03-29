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
        @Param({"equals,,1", "arrayList,,1", "arrayList,,10", "arrayList,,100", "arrayList,,1000", "array,,1", "array,,10", "array,,100", "array,,1000", "arrayBS,,1", "arrayBS,,10", "arrayBS,,100", "arrayBS,,1000", "javaHashSet,0.75,1", "javaHashSet,0.75,10", "javaHashSet,0.75,100", "javaHashSet,0.75,1000", "javaHashSet,0.5,1", "javaHashSet,0.5,10", "javaHashSet,0.5,100", "javaHashSet,0.5,1000", "javaHashSet,0.25,1", "javaHashSet,0.25,10", "javaHashSet,0.25,100", "javaHashSet,0.25,1000", "hppcHashSet,0.75,1", "hppcHashSet,0.75,10", "hppcHashSet,0.75,100", "hppcHashSet,0.75,1000", "hppcHashSet,0.5,1", "hppcHashSet,0.5,10", "hppcHashSet,0.5,100", "hppcHashSet,0.5,1000", "hppcHashSet,0.25,1", "hppcHashSet,0.25,10", "hppcHashSet,0.25,100", "hppcHashSet,0.25,1000", "hppcScatterSet,0.75,1", "hppcScatterSet,0.75,10", "hppcScatterSet,0.75,100", "hppcScatterSet,0.75,1000", "hppcScatterSet,0.5,1", "hppcScatterSet,0.5,10", "hppcScatterSet,0.5,100", "hppcScatterSet,0.5,1000", "hppcScatterSet,0.25,1", "hppcScatterSet,0.25,10", "hppcScatterSet,0.25,100", "hppcScatterSet,0.25,1000", "troveHashSet,0.75,1", "troveHashSet,0.75,10", "troveHashSet,0.75,100", "troveHashSet,0.75,1000", "troveHashSet,0.5,1", "troveHashSet,0.5,10", "troveHashSet,0.5,100", "troveHashSet,0.5,1000", "troveHashSet,0.25,1", "troveHashSet,0.25,10", "troveHashSet,0.25,100", "troveHashSet,0.25,1000", "fuHashSet,0.75,1", "fuHashSet,0.75,10", "fuHashSet,0.75,100", "fuHashSet,0.75,1000", "fuHashSet,0.5,1", "fuHashSet,0.5,10", "fuHashSet,0.5,100", "fuHashSet,0.5,1000", "fuHashSet,0.25,1", "fuHashSet,0.25,10", "fuHashSet,0.25,100", "fuHashSet,0.25,1000"})
        public String variant;

        public IntLookup intLookup;

        @Setup(Level.Trial)
        public void setUp() {
            var v = variant.split(",");

            var testList = BenchmarkData.randomIntList(Integer.parseInt(v[2]));
            var loadFactor = "".equals(v[1]) ? 0.0f : Float.parseFloat(v[1]);
            intLookup = IntLookup.get(v[0], testList, loadFactor);
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
                .warmupIterations(3)
                .measurementIterations(5)
                .warmupTime(iterationTime)
                .measurementTime(iterationTime)
                .build();
        new Runner(opt).run();
    }
}