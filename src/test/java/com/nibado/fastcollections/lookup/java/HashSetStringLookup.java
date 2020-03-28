package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.lookup.StringLookup;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetStringLookup implements StringLookup {
    private final Set<String> set;

    public HashSetStringLookup(List<String> data) {
        set = new HashSet<>(data);
    }

    @Override
    public boolean contains(String value) {
        return set.contains(value);
    }
}
