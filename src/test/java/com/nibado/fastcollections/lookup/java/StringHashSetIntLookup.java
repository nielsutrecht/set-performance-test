package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StringHashSetIntLookup implements IntLookup {
    private final Set<String> set;

    public StringHashSetIntLookup(List<Integer> data) {
        this.set = data.stream().map(Object::toString).collect(Collectors.toSet());
    }

    @Override
    public boolean contains(int value) {
        return set.contains(Integer.toString(value));
    }
}
