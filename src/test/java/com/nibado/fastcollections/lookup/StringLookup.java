package com.nibado.fastcollections.lookup;

import com.nibado.fastcollections.lookup.hppc.HppcHashSetStringLookup;
import com.nibado.fastcollections.lookup.hppc.HppcScatterSetStringLookup;
import com.nibado.fastcollections.lookup.java.HashSetStringLookup;

import java.util.List;

public interface StringLookup {
    boolean contains(String value);

    static StringLookup get(String implementation, List<String> list) {
        switch (implementation) {
            case "javaHashSet":
                return new HashSetStringLookup(list);
            case "hppcHashSet":
                return new HppcHashSetStringLookup(list);
            case "hppcScatterSet":
                return new HppcScatterSetStringLookup(list);

            default:
                throw new IllegalArgumentException("Unknown implementation: " + implementation);
        }
    }
}
