package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.IntHashSet;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;

public class HppcHashSetIntLookup implements IntLookup {
    private final IntHashSet set;

    public HppcHashSetIntLookup(List<Integer> data) {
        set = new IntHashSet(data.size());
        data.forEach(set::add);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
