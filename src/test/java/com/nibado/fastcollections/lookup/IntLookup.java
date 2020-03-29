package com.nibado.fastcollections.lookup;

import com.nibado.fastcollections.lookup.fastutil.FastUtilHashSetIntLookup;
import com.nibado.fastcollections.lookup.hppc.HppcHashSetIntLookup;
import com.nibado.fastcollections.lookup.hppc.HppcScatterSetIntLookup;
import com.nibado.fastcollections.lookup.java.*;
import com.nibado.fastcollections.lookup.trove.TroveHashSetIntLookup;

import java.util.List;

public interface IntLookup {
    float LOAD_DEFAULT = 0.75f;
    float LOAD_FAST = 0.5f;
    float LOAD_VERY_FAST = 0.25f;

    boolean contains(int value);

    static IntLookup get(String implementation, List<Integer> list) {
        switch (implementation) {
            case "javaStringHashSet":
                return new StringHashSetIntLookup(list);

            case "javaHashSetDef":
                return new HashSetIntLookup(list, LOAD_DEFAULT);
            case "javaHashSetF":
                return new HashSetIntLookup(list, LOAD_FAST);
            case "javaHashSetVF":
                return new HashSetIntLookup(list, LOAD_VERY_FAST);
            case "arrayList":
                return new ArrayListIntLookup(list);
            case "array":
                return new ArrayIntLookup(list);
            case "arrayBS":
                return new ArrayIntBSLookup(list);
            case "equals":
                return new EqualsIntLookup(list);

            case "hppcHashSetDef" :
                return new HppcHashSetIntLookup(list, LOAD_DEFAULT);
            case "hppcHashSetF" :
                return new HppcHashSetIntLookup(list, LOAD_FAST);
            case "hppcHashSetVF" :
                return new HppcHashSetIntLookup(list, LOAD_VERY_FAST);
            case "hppcScatterSet" :
                return new HppcScatterSetIntLookup(list);

            case "troveHashSetDef" :
                return new TroveHashSetIntLookup(list, LOAD_DEFAULT);
            case "troveHashSetF" :
                return new TroveHashSetIntLookup(list, LOAD_FAST);
            case "troveHashSetVF" :
                return new TroveHashSetIntLookup(list, LOAD_VERY_FAST);

            case "fuHashSetDef" :
                return new FastUtilHashSetIntLookup(list, LOAD_DEFAULT);
            case "fuHashSetF" :
                return new FastUtilHashSetIntLookup(list, LOAD_FAST);
            case "fuHashSetVF" :
                return new FastUtilHashSetIntLookup(list, LOAD_VERY_FAST);

            default:
                throw new IllegalArgumentException("Unknown implementation: " + implementation);
        }
    }
}
