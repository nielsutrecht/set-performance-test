package com.nibado.fastcollections;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class BenchmarkData {
    private static final Random RANDOM = new Random(42);
    public static final List<Integer> INT_DATA_1000_000 = createIntList(100_000_000);
    public static final List<Integer> INT_ACTUAL = loadIdList();
    public static final List<String> STRING_ACTUAL = loadStringList();
    public static final int[] NEEDLES = new int[10];

    static {
        for(int i = 0;i < 5;i++) {
            NEEDLES[i] = INT_ACTUAL.get(i);
            NEEDLES[i + 5] = randomId();
        }
    }

    public static int randomId() {
        return 80_000_000 + RANDOM.nextInt(10_000_000);
    }

    public static List<Integer> randomIntList(int size) {
        if(size <= INT_ACTUAL.size()) {
            return INT_ACTUAL.subList(0, size);
        } else {
            return INT_DATA_1000_000.subList(0, size);
        }
    }

    public static List<Integer> createIntList(int size) {
        var list = new ArrayList<Integer>(size);
        for (int i = 0; i < size; i++) {
            list.add(randomId());
        }

        return Collections.unmodifiableList(list);
    }

    public static int[] toArray(List<Integer> list) {
        var array = new int[list.size()];

        for(int i = 0;i < array.length;i++) {
            array[i] = list.get(i);
        }

        return array;
    }

    public static List<Integer> loadIdList() {
        try {
            var lines = Files.readAllLines(new File("./id-list.txt").toPath());

            return lines.stream().map(Integer::parseInt).distinct().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<String> loadStringList() {
        try {
            var lines = Files.readAllLines(new File("./string-list.txt").toPath());

            return lines.stream().map(s -> s.trim().toLowerCase()).distinct().collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
