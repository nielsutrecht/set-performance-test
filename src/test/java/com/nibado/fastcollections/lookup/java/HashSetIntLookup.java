package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.lookup.IntLookup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetIntLookup implements IntLookup {
    private final Set<Integer> set;

    public HashSetIntLookup(List<Integer> data) {
        set = new HashSet<>(data);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
