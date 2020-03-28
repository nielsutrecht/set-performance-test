package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.ObjectHashSet;
import com.nibado.fastcollections.lookup.StringLookup;

import java.util.List;

public class HppcHashSetStringLookup implements StringLookup {
    private final ObjectHashSet<String> set;

    public HppcHashSetStringLookup(List<String> data) {
        set = new ObjectHashSet<>(data.size());
        data.forEach(set::add);
    }

    @Override
    public boolean contains(String value) {
        return set.contains(value);
    }
}
