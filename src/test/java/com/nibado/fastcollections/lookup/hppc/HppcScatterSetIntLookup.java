package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.IntScatterSet;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;

public class HppcScatterSetIntLookup implements IntLookup {
    private final IntScatterSet set;

    public HppcScatterSetIntLookup(List<Integer> data, float loadFactor) {
        set = new IntScatterSet(data.size(), loadFactor);
        data.forEach(set::add);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
