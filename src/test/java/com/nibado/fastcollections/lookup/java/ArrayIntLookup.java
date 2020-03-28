package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.BenchmarkData;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.ArrayList;
import java.util.List;

public class ArrayIntLookup implements IntLookup {
    private final int[] array;

    public ArrayIntLookup(List<Integer> data) {
        array = BenchmarkData.toArray(data);
    }

    @Override
    public boolean contains(int value) {
        for(int i = 0;i < array.length;i++) {
            if(array[i] == value) {
                return true;
            }
        }

        return false;
    }
}
