package com.nibado.fastcollections.lookup.hppc;

import com.carrotsearch.hppc.IntScatterSet;
import com.nibado.fastcollections.lookup.IntLookup;

import java.util.List;

public class HppcScatterSetIntLookup implements IntLookup {
    private final IntScatterSet set;

    public HppcScatterSetIntLookup(List<Integer> data) {
        set = new IntScatterSet(data.size());
        data.forEach(set::add);
    }

    @Override
    public boolean contains(int value) {
        return set.contains(value);
    }
}
