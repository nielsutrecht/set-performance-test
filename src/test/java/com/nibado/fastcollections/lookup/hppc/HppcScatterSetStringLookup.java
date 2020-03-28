package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.ObjectScatterSet;
import com.nibado.fastcollections.lookup.StringLookup;

import java.util.List;

public class HppcScatterSetStringLookup implements StringLookup {
    private final ObjectScatterSet<String> set;

    public HppcScatterSetStringLookup(List<String> data) {
        set = new ObjectScatterSet<>(data.size());
        data.forEach(set::add);
    }

    @Override
    public boolean contains(String value) {
        return set.contains(value);
    }
}
