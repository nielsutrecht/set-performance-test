package com.nibado.fastcollections.lookup.fastutil;

import com.nibado.fastcollections.lookup.IntLookup;
import it.unimi.dsi.fastutil.ints.IntOpenHashSet;

import java.util.List;

public class FastUtilHashSetIntLookup implements IntLookup {
    private final IntOpenHashSet set;

    public FastUtilHashSetIntLookup(List<Integer> data, float loadFactor) {
        set = new IntOpenHashSet(data, loadFactor);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
