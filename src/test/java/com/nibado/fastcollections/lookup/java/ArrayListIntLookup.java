package com.nibado.fastcollections.lookup.java;

import com.nibado.fastcollections.lookup.IntLookup;

import java.util.ArrayList;
import java.util.List;

public class ArrayListIntLookup implements IntLookup {
    private final ArrayList<Integer> list;

    public ArrayListIntLookup(List<Integer> data) {
        list = new ArrayList<>(data);
    }

    @Override
    public boolean contains(int value) {
        return list.contains(value);
    }
}
