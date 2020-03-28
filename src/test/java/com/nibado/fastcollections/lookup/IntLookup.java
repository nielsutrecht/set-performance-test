package com.nibado.fastcollections.lookup;

import com.nibado.fastcollections.lookup.hppc.HppcHashSetIntLookup;
import com.nibado.fastcollections.lookup.hppc.HppcScatterSetIntLookup;
import com.nibado.fastcollections.lookup.java.*;

import java.util.List;

public interface IntLookup {
    boolean contains(int value);

    static IntLookup get(String implementation, List<Integer> list) {
        switch (implementation) {
            case "javaStringHashSet":
                return new StringHashSetIntLookup(list);
            case "javaHashSet":
                return new HashSetIntLookup(list);
            case "arrayList":
                return new ArrayListIntLookup(list);
            case "array":
                return new ArrayIntLookup(list);
            case "arrayBS":
                return new ArrayIntBSLookup(list);

            case "hppcHashSet" :
                return new HppcHashSetIntLookup(list);
            case "hppcScatterSet" :
                return new HppcScatterSetIntLookup(list);

            default:
                throw new IllegalArgumentException("Unknown implementation: " + implementation);
        }
    }
}
