package com.nibado.fastcollections.lookup.trove;

import com.nibado.fastcollections.lookup.IntLookup;
import gnu.trove.set.hash.TIntHashSet;

import java.util.List;

public class TroveHashSetIntLookup implements IntLookup {
    private final TIntHashSet set;

    public TroveHashSetIntLookup(List<Integer> data, float loadFactor) {
        set = new TIntHashSet(data.size(), loadFactor);
        set.addAll(data);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
