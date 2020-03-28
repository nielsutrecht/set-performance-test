package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.BenchmarkData;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.Arrays;
import java.util.List;

public class ArrayIntBSLookup implements IntLookup {
    private final int[] array;

    public ArrayIntBSLookup(List<Integer> data) {
        array = BenchmarkData.toArray(data);
        Arrays.sort(array);
    }

    @Override
    public boolean contains(int value) {
        return Arrays.binarySearch(array, value) >= 0;
    }
}
