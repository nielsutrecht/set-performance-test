package com.nibado.fastcollections.lookup;

import com.nibado.fastcollections.lookup.fastutil.FastUtilHashSetIntLookup;
import com.nibado.fastcollections.lookup.hppc.HppcHashSetIntLookup;
import com.nibado.fastcollections.lookup.hppc.HppcScatterSetIntLookup;
import com.nibado.fastcollections.lookup.java.*;
import com.nibado.fastcollections.lookup.trove.TroveHashSetIntLookup;

import java.util.List;

public interface IntLookup {
    boolean contains(int value);

    static IntLookup get(String implementation, List<Integer> list, float loadFactor) {
        switch (implementation) {
            case "javaStringHashSet":
                return new StringHashSetIntLookup(list, loadFactor);
            case "javaHashSet":
                return new HashSetIntLookup(list, loadFactor);
            case "arrayList":
                return new ArrayListIntLookup(list);
            case "array":
                return new ArrayIntLookup(list);
            case "arrayBS":
                return new ArrayIntBSLookup(list);
            case "equals":
                return new EqualsIntLookup(list);

            case "hppcHashSet" :
                return new HppcHashSetIntLookup(list, loadFactor);
            case "hppcScatterSet" :
                return new HppcScatterSetIntLookup(list, loadFactor);

            case "troveHashSet" :
                return new TroveHashSetIntLookup(list, loadFactor);

            case "fuHashSet" :
                return new FastUtilHashSetIntLookup(list, loadFactor);

            default:
                throw new IllegalArgumentException("Unknown implementation: " + implementation);
        }
    }
}
