package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.IntHashSet;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;

public class HppcHashSetIntLookup implements IntLookup {
    public static final double LOAD_DEFAULT = 0.75;
    public static final double LOAD_FAST = 0.5;
    public static final double LOAD_VERY_FAST = 0.25;

    private final IntHashSet set;

    public HppcHashSetIntLookup(List<Integer> data, double loadFactor) {
        set = new IntHashSet(data.size(), loadFactor);
        data.forEach(set::add);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
